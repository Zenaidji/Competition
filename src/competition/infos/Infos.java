package competition.infos;

import competitor.Competitor;

public class Infos {
	private Competitor winner;
	private Competitor loser;
	private String score;
	
	public Infos(Competitor winner, Competitor loser, String score) {
		this.winner = winner;
		this.loser = loser;
		this.score = score;
	}
	
	/**
	 * 
	 * @return the winer  of the match
	 */
	public Competitor getWinner() {
		return this.winner;
	}
	
	/**
	 * 
	 * @return the score of the match
	 */
	public String getScore() {
		return this.score;
	}
	
	/**
	 * 
	 * @return the loser of the match
	 */
	
	public Competitor getLoser() {
		return this.loser;
	}
}
