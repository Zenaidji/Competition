package competition.observers;

import competition.Competition;
import competition.infos.Infos;

public class MookObserver implements Observercmp {

	public int nbOserve;
	public int received;
	private Competition competition;
	
	public MookObserver() {
		this.nbOserve=0;
		this.received=0;
	}

	@Override
	public void observe(Infos i) {
		this.nbOserve++;
		
	}

	@Override
	public void setCurentInfo(Infos i) {
		this.received++;

	}

	@Override
	public Infos getCurentInfo() {
		
		return null;
	}

	@Override
	public void setCompetition(Competition c) {
		this.competition=c;

	}

}
