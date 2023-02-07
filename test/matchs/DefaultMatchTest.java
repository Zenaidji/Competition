package matchs;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import competitor.Competitor;

public class DefaultMatchTest extends MatchTest {

	@Override	
	public Match createMatch() {
		this.c1=new Competitor("jimmy");
		this.c2= new Competitor("frodo");
		return new DefaultMatch() ;
	}
	
	@Test 
	public void playThisMatchTest() {
		
		Competitor afterPlaying =  this.match.playThisMatch(this.c1,this.c2);
		assertTrue(afterPlaying.equals(this.c1) || afterPlaying.equals(this.c2) );
	}

}
