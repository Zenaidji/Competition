package competition;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;

import competition.selection.Selection;
import competitor.Competitor;

public class MasterTest extends CompetitionTest {
	private int nbCompetiteurs =21;
	private List<Competitor> lc ;
	private int nbPoule=4;
	private Master master =this.createMaster();

  
	@Override
	public Competition createCompetition() {
		this.lc=new ArrayList<>();
		for (int i=0;i<this.nbCompetiteurs;i++) {
			this.lc.add(new Competitor("competiteur "+String.valueOf(i)));
		}
			Selection s = new MockSelection(); 
		
		return new Master(lc, s, this.nbPoule);
}	
	private Master createMaster() {
		this.lc=new ArrayList<>();
		for (int i=0;i<this.nbCompetiteurs;i++) {
			this.lc.add(new Competitor("competiteur "+String.valueOf(i)));
		}
			Selection s = new MockSelection(); 
		
		return new Master(lc, s, this.nbPoule);
}
	
	// on va se focaliser sur le test de npmbre de match joue 

	@Test
	public void playTest() {
		for(Competitor c :this.c1.getCompetitors()) {
			assertEquals(0,this.c1.ranking().get(c));
			assertEquals(0,this.c1.playedMatch().get(c));
		}
		this.c1.play();
		int cptMatch = 0;
		for(Competitor c :this.c1.getCompetitors()) {
			cptMatch+=this.c1.playedMatch().get(c);
		}
		assertEquals(186,cptMatch);
		
		}
	
	
	@Test
	public void divisionMarche() {

		assertEquals(0,this.master.getPoules().size());
		this.master.division();
		assertEquals(this.nbPoule,this.master.getPoules().size());
		List<Competitor> allC=new ArrayList<>();
		for (League l :this.master.getPoules()) {
			for(Competitor c : l.getCompetitors()) {
				allC.add(c);
			}
		}
		for(Competitor c:this.master.getCompetitors()) {
			assertTrue(allC.contains(c));
		}
	}
	
	@Test
	public void groupeStagePlayedWellTest() {
		for(Competitor c :this.c1.getCompetitors()) {
			assertEquals(0,this.c1.ranking().get(c));
			assertEquals(0,this.c1.playedMatch().get(c));
		}
		this.master.division();
		this.master.playPoules();
		// tester les points dans chaque league
		for(League l :this.master.getPoules()) {
			Collection<Competitor> keysInRanking=l.ranking().keySet();
			System.out.println("******" +l.getCompetitors().size());
			int sumPoints=0;
			for(Competitor c:keysInRanking) {
				sumPoints+=l.ranking().get(c);
			}
			assertEquals(l.getCompetitors().size()*(l.getCompetitors().size()-1),sumPoints);
			
		}
		
		// tester le nombre de match de chaque league
		
		for (League l :this.master.getPoules()) {
			Collection<Competitor> keysInPlayedMAtch=l.playedMatch().keySet();	
			for(Competitor c:keysInPlayedMAtch) {
				assertEquals(2*(l.getCompetitors().size()-1),l.playedMatch().get(c));
			}
		}
	
		
		
	}
	
	@Test
	public void FinalsWellPlayed() {
		this.master.division();
		this.master.playPoules();
		List <Competitor> qualifiers = this.master.getSelection().select(this.master.getPoules());
		this.master.playFinals(qualifiers);
		 int sumPoints=0;
		 int sumPlayedM=0;
		 for(Competitor c:this.master.getFinals().ranking().keySet()){
			 sumPoints+=this.master.getFinals().ranking().get(c); 
			 sumPlayedM+=this.master.getFinals().playedMatch().get(c);
		 }
		 assertEquals(this.master.getFinals().getCompetitors().size()-1,sumPoints);
		 assertEquals((this.master.getFinals().getCompetitors().size()*2)-2,sumPlayedM);
	}
	
		
	

}
	

