/**
 * 
 */
package competition;

import java.util.List;

import competitor.Competitor;
import matchs.DefaultMatch;
import matchs.Match;


public class MookCompetition extends Competition {
	private int playcalls;

	/**
	 * @param lc
	 */
	public MookCompetition(List<Competitor> lc) {
		super(lc);
		this.playcalls=0;
	}

	
	@Override
	protected void play(List<Competitor> lc) {
		 this.playcalls+=1;
	}
	public int getplaycalls() {
		return this.playcalls;
	}

	@Override
	protected Match createMatch() {
		
		return new DefaultMatch();
	}

	@Override
	public void displayCompetition() {
		
		
	}

	@Override
	protected int getNbMatch() {
		
		return 0;
	}
	

}
