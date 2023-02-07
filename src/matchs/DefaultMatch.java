package matchs;

import java.util.Random;

import competitor.Competitor;

public class DefaultMatch implements Match {
	/**
	 * @see matchs.Match
	 */
	public DefaultMatch() {
		super();
	}

	@Override
	/**
	 * @see matchs.Match
	 */
	public Competitor playThisMatch(Competitor c1,Competitor c2) {
		Random rand = new Random();
		int choice = rand.nextInt(2);
		if(choice == 0) {
			return c1;
		}
		else {
			return c2;
		}
		
	}
	public Competitor getLoser(Competitor winner,Competitor c1,Competitor c2) {
		if(winner.equals(c2))
			return c1;
		else
			return c2;
		
	}

}
