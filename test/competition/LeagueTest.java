package competition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;

import competitor.Competitor;

public class LeagueTest extends CompetitionTest {

	@Override
	public Competition createCompetition() {
		// TODO Auto-generated method stub
		Competitor frodo= new Competitor("frodo");
		Competitor jimmy = new Competitor("jimmy");
		List<Competitor> lc = new ArrayList<>();
		lc.add(frodo);
		lc.add(jimmy);
		return new League(lc);
	}
	
	@Test
	public void playWithParameterTestPointsAfterCallingPLay() {
		super.testAbstractPlay();
		this.c1.play();
		
		Collection<Competitor> keysInRanking=this.c1.ranking().keySet();
		int sumPoints=0;
		for(Competitor c:keysInRanking) {
			sumPoints+=this.c1.ranking.get(c);
		}
		assertEquals(2*(this.c1.getCompetitors().size()-1),sumPoints);
		
	}
	
	@Test
	public void playWithParameterTestNbMatchPlayedAfterCallingPlay() {
		super.testAbstractPlay();
		this.c1.play();
		Collection<Competitor> keysInPlayedMAtch=this.c1.playedMatch().keySet();	
		for(Competitor c:keysInPlayedMAtch) {
			assertEquals(2*(this.c1.getCompetitors().size()-1),this.c1.playedMatch().get(c));
		}
		
	}
	
	
	

}
