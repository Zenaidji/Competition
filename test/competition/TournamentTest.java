package competition;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import competitor.Competitor;
public class TournamentTest extends CompetitionTest{
	
	private int nbCompetitors=4;
	
	

	@Override
	public Competition createCompetition() {
		// TODO Auto-generated method stub
		Competitor frodo= new Competitor("frodo");
		Competitor jimmy = new Competitor("jimmy");
		Competitor hammer = new Competitor("hammer");
		Competitor lamber = new Competitor("lamberjack");
		List<Competitor> lc = new ArrayList<>();
		lc.add(frodo);
		lc.add(jimmy);
		lc.add(lamber);
		lc.add(hammer);
		return new Tournament(lc);
	}
	
	
	
	 //tester si une exception est leveé quand le nombre de competiteurs n'est pas une puissance de deux 
	 @Test
	public void testNbCompetitorsWhenNotEven() throws Puissance2Exception {
		    Competitor frodo= new Competitor("frodo");
			Competitor jimmy = new Competitor("jimmy");
			Competitor hammer = new Competitor("hammer");
			List<Competitor> competiteurs=new ArrayList<>();
			competiteurs.add(frodo);
			competiteurs.add(jimmy);
			competiteurs.add(hammer);
			assertThrows(Puissance2Exception.class,()->new Tournament(competiteurs));
	 }
	 
	 @Test
	 //teste le nommbre de match jouer durant le déroulement du tournoi
	 public void testPlayNbMtchAfterPlaying() {
		 super.testAbstractPlay();
		 this.c1.play();
		 int sum=0;
		 for(Competitor c:this.c1.playedMatch.keySet()){
			 sum+=this.c1.playedMatch.get(c); 
		 }
		 assertEquals((this.c1.getCompetitors().size()*2)-2,sum);	 
	 }
	 
	 
	 @Test
	 //teste le nombre de point durant le déroulement du tournoi
	 public void testPlayNbPointAfterPlaying() {
		 super.testAbstractPlay();
		 this.c1.play();
		 int sum=0;
		 for(Competitor c:this.c1.ranking().keySet()){
			 sum+=this.c1.ranking().get(c); 
		 }
		 assertEquals(this.c1.getCompetitors().size()-1,sum);
		 
		 
	 }
	 //tester le nombre de points et le nombre de match du vainqueur
	 
	 @Test
	public void  testThepointOfTheWinner(){
		 super.testAbstractPlay();
		 this.c1.play();
		 int NbCompetiteur=this.c1.getCompetitors().size();
		 int NbpointWinner=Operation.log2(NbCompetiteur);
		 assertTrue(this.c1.ranking().containsValue(NbpointWinner));		 
	 }
	 
	 @Test
	 public void testTheNbMatchOfTheWinner() {
		 super.testAbstractPlay();
		 this.c1.play();
		 int NbCompetiteur=this.c1.getCompetitors().size();
		 int NbmatchWinner=Operation.log2(NbCompetiteur);
		 assertTrue(this.c1.playedMatch().containsValue(NbmatchWinner)); 

	 }
	 
	 
	 
	 
	
	 
	 
	 
	 
	 
	
	

	

	
	
	
}
