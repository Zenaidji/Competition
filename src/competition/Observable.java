package competition;

import competition.infos.Infos;

public interface Observable {
	
	/**
	 * send the information i to All observers
	 * @param i the inforamtion 
	 */
	public void broadcast(Infos i);
}
