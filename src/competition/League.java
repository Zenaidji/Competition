package competition;

import java.util.List;
import java.util.Map;

import competitor.Competitor;
import matchs.DefaultMatch;
import matchs.Match;

public class League extends Competition {

	/**
	 * create a new league
	 * @param lc the list of the competitors of the league
	 */
	public League(List<Competitor> lc) throws Puissance2Exception{
		super(lc);
	}

	@Override
	/**
	 * play the competition as a league 
	 */
	protected void play(List<Competitor> lc) {
		
		for (Competitor c :lc) {
			for (Competitor j :lc) {
				if(! c.equals(j)) {
					this.playMatch(c,j);
				}
			}
		}
		
		
	}
	
	/**
	 * create the type of match to play the tournament
	 */
	protected Match createMatch() {
		return new DefaultMatch();
		
	}
	
	
	
	public  int getNbMatch(){
		int n=this.getCompetitors().size();
		int res=(n-1)*n;
		return res;
		
		
	}
	
	
	
}
