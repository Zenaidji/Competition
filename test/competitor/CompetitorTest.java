package competitor;

import static org.junit.Assert.*;

import org.junit.jupiter.api.*;

public class CompetitorTest {
	
	private Competitor c1;
	
	@BeforeEach
	public void init() {
		this.c1=new Competitor("frodo");
	}
	
	@Test 
	public void testToString(){
		assertEquals("frodo",this.c1.toString());
		
	}
		
	
	
	

}
