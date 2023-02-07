package competition.selection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import competition.League;
import competitor.Competitor;

public class SelectWithTwoRandomThirdTest extends SelectionTest{
	public List<League> lg=new ArrayList<>();
	public List<Competitor> l1=new ArrayList<>();
	public List<Competitor> l2=new ArrayList<>();
	public static int size=12;
	
	

	@Override
	public Selection createSelection() {
		
		return new SelectWithTwoRandomThird();
	}
	
	
 
  	
  	public void setup() {
  		for (int i=0;i<this.size/2;i++) {
			this.l1.add(new Competitor("competiteur "+String.valueOf(i)));
		}
  		
  		for (int i=size/2;i<this.size;i++) {
			this.l2.add(new Competitor("competiteur "+String.valueOf(i)));
		}
  }
  	
  	
  	
  	
  
  	 @Test
   public void selectTest(){
  		 this.setup();
  		 this.lg.add(new League(l1));
  		 this.lg.add(new League(l2));
  		 this.lg.get(0).play();
  		 this.lg.get(1).play();
  		 List<Competitor>selected= this.selection.select(lg);
  		 assertEquals(3*this.lg.size(),selected.size());
  		 List <Competitor>tmp1=lg.get(0).getCompetitors();
  		 List <Competitor>tmp2=lg.get(1).getCompetitors();
  		 tmp1.addAll(tmp2);
  		 for (Competitor c :selected) {
  			 assertTrue(tmp1.contains(c));
  			 tmp1.remove(c);
  		 }
  		 
  		for (Competitor c :selected) {
 			 assertFalse(tmp1.contains(c));
 			 
 		 }
  		 
  		 
  		 
  		
	  
  }
	
	
	
	
	
	

	
}
