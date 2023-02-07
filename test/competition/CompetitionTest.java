package competition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competition.infos.Infos;
import competition.observers.BookMaker;
import competition.observers.MookObserver;
import competition.observers.Observercmp;
import competition.observers.Reporter;
import competitor.Competitor;


public abstract class CompetitionTest {
	protected  Competition c1;
	
	
	public  abstract Competition createCompetition();
	

	@BeforeEach
	public void init() {
		this.c1=createCompetition();
		this.c1.addObserver(new BookMaker("Winamax"));
		this.c1.addObserver(new Reporter("canal+"));
	}
	
	
	@Test
	public void TestPlaycall() {
		List<Competitor> mkcompetitors=new ArrayList<Competitor>();
		MookCompetition mkcompetition=new MookCompetition(mkcompetitors);
		assertEquals(0,mkcompetition.getplaycalls());
		mkcompetition.play();
		assertEquals(1,mkcompetition.getplaycalls());
		mkcompetition.play();
		assertEquals(2,mkcompetition.getplaycalls());
	}
	
	@Test
	public void testAbstractPlay(){
		Collection<Competitor> keysInRanking=this.c1.ranking().keySet();
		Collection<Competitor> keysInPlayedMAtch=this.c1.playedMatch().keySet();
		
		//tester le  nombres de points des competitors
		 for (Competitor c:keysInRanking){
			 assertEquals(0,this.c1.ranking().get(c));
		 }
		 //tester si tous les competiteurs dans ranking et nb played match sont dans la liste initiale
		 assertEquals(keysInRanking.size(),this.c1.getCompetitors().size());
		 for (Competitor c:keysInRanking){
			 assertTrue(this.c1.getCompetitors().contains(c));
		 }
		 
		 // tester le nombre de match initial 
		 assertEquals(keysInPlayedMAtch.size(),this.c1.getCompetitors().size());
		 for (Competitor c :keysInPlayedMAtch) {
			 assertTrue(this.c1.getCompetitors().contains(c));
			 assertEquals(0,this.c1.playedMatch().get(c));
		 }
		 
	
		
		
		
	}
	
	@Test
	public void playMatchTest() { 
		Competitor competitor1 = this.c1.getCompetitors().get(0);
		Competitor competitor2=this.c1.getCompetitors().get(1);
		
		assertEquals(0,this.c1.playedMatch().get(competitor1));
		assertEquals(0,this.c1.playedMatch().get(competitor2));
		
		assertEquals(0,this.c1.ranking().get(competitor1));
		assertEquals(0,this.c1.ranking().get(competitor2));
		
		this.c1.playMatch(competitor1, competitor2);
		
		// verfifer que le nombre de match joué par les deux equipes a augmenté
		assertEquals(1,this.c1.playedMatch().get(competitor1));
		assertEquals(1,this.c1.playedMatch().get(competitor2));
		
		// verifier que les points d au moins une equipe est acrementéé
		assertTrue(1==this.c1.ranking().get(competitor1) || 1==this.c1.ranking().get(competitor2) );
		
		
	}
	
	@Test
	public void broadCast() {
		List<Observercmp> allObs=this.c1.getObservers();
		Infos d =allObs.get(0).getCurentInfo(); 
		for(Observercmp o :allObs) {
			assertEquals(d,o.getCurentInfo());
		}
		Infos i = new Infos(this.c1.getCompetitors().get(0),this.c1.getCompetitors().get(1),"0-2");
		this.c1.observeAll(i);
		for(Observercmp o :allObs) {
			assertEquals(i,o.getCurentInfo());
		}
	}
	
	
	@Test
	public void TestUpadte(){
		MookObserver mk=new MookObserver();
		this.c1.addObserver(mk);
		this.c1.play();
		assertEquals(this.c1.getNbMatch(),mk.nbOserve);
	
	
		
		
		
		
		
	}


	
	

}
