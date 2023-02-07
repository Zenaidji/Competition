package competition.observers;
import java.util.Map;

import competition.Competition;
import competition.infos.Infos;
import competitor.Competitor;

public class Reporter implements Observercmp {
	

	private Infos info;
	private String name;
	private Competition c;
	
	public Reporter(String name) {
		this.name=name;
			}


	public void observe(Infos i) {
		this.setCurentInfo(i);
		System.out.println(this.toString()+" reported that "+this.info.getWinner()+" won with a score of "+ this.info.getScore()+ " vs "+this.info.getLoser());	
		
	}

	
	public void setCurentInfo(Infos i){
		this.info=i;
	
		
	}


	public Infos getCurentInfo() {
		
		return this.info;
	}


	public void setCompetition(Competition c){
		this.c=c;
		
	}


	@Override
	public String toString() {
		return this.name;
	}

}
