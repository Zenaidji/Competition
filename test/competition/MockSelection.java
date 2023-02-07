package competition;

import java.util.ArrayList;
import java.util.List;

import competition.League;
import competition.selection.Selection;
import competitor.Competitor;

public class MockSelection implements Selection {
	
	/**  slect 
	 * 
	 */
	@Override
	public List<Competitor> select(List<League> lg) {
		List<Competitor> res=new ArrayList<>();
		for(League l : lg) {
			Competitor [] tab = new Competitor[l.ranking().size()];
			tab=l.ranking().keySet().toArray(tab);
			res.add(tab[0]);
		}
		return res;
	}

}
