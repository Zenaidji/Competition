package competition.observers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import competition.Competition;
import competition.League;
import competitor.Competitor;

public class BookMakerTest extends ObservableTest {

	@Override
	public Observercmp init() {
		
		return new BookMaker("Ghani");
	}
	
	
	
	@Test 
	public void cotesTest() {
		BookMaker bk=new BookMaker("hakim");
		Map<Competitor,Float> cotes=bk.getCotes();
		for(Competitor c:cotes.keySet()) {
			assertEquals(2,cotes.get(c));
			
		}
	}
		
		
	@Test 
	public void cotesTestAfterMatch() {
		BookMaker bk=new BookMaker("hakim");
		List <Competitor>lc=new ArrayList<>();
		Competitor c1=new Competitor ("jsv");
		Competitor c2=new Competitor ("jcr");
		
		lc.add(c1);
		lc.add(c2);
		Competition c=new League(lc);
		c.addObserver(bk);
		c.playMatch(lc.get(0),lc.get(1));
		int p1=c.ranking().get(c1);
		int p2=c.ranking().get(c2);
		
		Competitor winner;
		Competitor loser;
		if(p1>p2) {
			winner = c1;
			loser =c2;
		}
		else {
			winner =c2;
			loser = c1;
		}
		Map<Competitor,Float> cotes=bk.getCotes();
		assertTrue(cotes.get(winner)<=cotes.get(loser));
		
	
		
		
		
		
			
		
	}
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	

}
