package competition.selection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import competition.League;
import competition.Operation;
import competitor.Competitor;

public class SelectTwoFirst implements Selection {
	
	public SelectTwoFirst() {
		
		
	}
	


	@Override
	/**
	 * select the two  best competitors from each League
	 * @param lg List of League 
	 * @return List of competitors that contains the two best competiors of each League 
	 */
	public List<Competitor> select(List<League> lg) {
		List<Competitor> qualifier=new ArrayList<>(); 
		for (League l:lg) {
			Map<Competitor,Integer>temp=l.ranking();
			Competitor c1=Operation.getfst(temp);
			temp.remove(c1);
			Competitor c2 =Operation.getfst(temp);
			qualifier.add(c1);
			qualifier.add(c2);
			
		}
		return qualifier;
		
	}

}
