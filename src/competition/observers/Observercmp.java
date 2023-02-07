package competition.observers;

import competition.Competition;
import competition.infos.Infos;

public interface Observercmp {
	
	/**
	 * set the curent information with the new information
	 * @param i information   observed
	 */
	public void observe(Infos i);
	
	/**
	 * set the curent information with the new information
	 * @param i
	 */
	public void setCurentInfo(Infos i);
	/**
	 * 	get the curent information
	 * @return  return the curent information
	 */
	public Infos getCurentInfo();
	
	/**
	 * 
	 * @param c set the competition 
	 */
	public void setCompetition(Competition c);

}
