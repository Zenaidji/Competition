package competition.selection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import competition.League;
import competition.Operation;
import competitor.Competitor;

public class SelectWithTwoRandomThird implements Selection {

	/**
	  * create an object that select the two first from each groupe
	  */
	public SelectWithTwoRandomThird() {
	
	}
	
	

	@Override
	/**
	 * the method that implement the selection of the two firsts from each group
	 * @param List of played league
	 * @return List of qualified competitors
	 */
	public List<Competitor> select(List<League> lg) {
		List<Competitor> qualifiers = new ArrayList<>();
		List <List<Competitor>> all = new ArrayList<>();
		List <Competitor> thirds= new ArrayList<>();
		// selectionnement des 3 de chaque league
		for (League l :lg ) {
			
			all.add(Operation.getNthfst(l.ranking(), 3));
		}
		
		for (List<Competitor> ll:all){
			qualifiers.add(ll.get(0));
			qualifiers.add(ll.get(1));
			thirds.add(ll.get(2));
		}
		Random rand = new Random();
		for (int i =0;i<2;i++) {
			int choice =rand.nextInt(thirds.size());
			qualifiers.add(thirds.get(choice));
			thirds.remove(choice);
		}
		
		
		

		
		
		
		return qualifiers;
	}

}
