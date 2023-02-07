package matchs;

import competitor.Competitor;

public  interface Match {
	
	public Competitor getLoser(Competitor winner,Competitor c1,Competitor c2) ;
	

	
	/**
	 * play the match between the two competitors
	 */
	public  Competitor playThisMatch(Competitor c1,Competitor c2);

}
