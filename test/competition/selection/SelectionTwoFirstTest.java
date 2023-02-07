package competition.selection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import competition.League;
import competitor.Competitor;

public class SelectionTwoFirstTest extends SelectionTest {

	@Override
	public Selection createSelection() {
		return new SelectTwoFirst();
		
	}
	
	@Test 
	 public void checkSelectedCompetitorTest(){
		List<League> lg=new ArrayList<> ();
		List <Competitor>lc=new ArrayList<>();
		lc.add(new Competitor("jcr"));
		lc.add(new Competitor("jsv"));
		lc.add(new Competitor("jsk"));
		lc.add(new Competitor("jsmb"));
	     League l=new League(lc);
	     l.play();
	     lg.add(l);
	     League res=lg.get(0);
	     
		List<Competitor> selected =this.selection.select(lg);
		assertEquals(2*lg.size(),selected.size());
		assertTrue(lc.contains(selected.get(0)));
		assertTrue(lc.contains(selected.get(1)));
		Collection<Integer> points=res.ranking().values();
		Integer [] tab = new Integer[points.size()];
		tab=points.toArray(tab);
		Arrays.sort(tab, Collections.reverseOrder());
		assertTrue(res.ranking().get(selected.get(0))== tab[0]);
		assertTrue(res.ranking().get(selected.get(1))== tab[1]);
		
		
	}
	
	
	
	
	
	

}
