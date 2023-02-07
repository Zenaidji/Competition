package competition.observers;

import java.util.HashMap;
import java.util.Map;

import competition.Competition;
import competition.infos.Infos;
import competitor.Competitor;

public class BookMaker implements Observercmp {
	private Map<Competitor,Float> cotes;
	private Infos info;
	private String name;
	private Competition c;

	public BookMaker(String name) {
	 this.cotes=new HashMap<Competitor,Float>();	
	 this.name=name;
	 
	}
	
	
	
	/**
	 * sen
	 * @param i information to send
	 */
	public void setCurentInfo(Infos i) {
		this.info=i;	
		
	}
	
	
	@Override
	public void setCompetition(Competition c) {
		this.c=c;
		this.init();
	}
	
	
	@Override
	public String toString() {
		return  this.name;
	}


	
	/**
	 * fill the map of cotes with with the first cotes value
	 */
	public void init() {
		for(Competitor co:this.c.getCompetitors()){
			this.cotes.put(co, (float) 2);
			
		}
		
		
		
	}

	@Override
	public void observe(Infos i) {
		this.setCurentInfo(i);
		Competitor win = this.info.getWinner();
		Competitor los = this.info.getLoser();
		 this.decreaseCote(win);
		 this.increaseCote(los);
		 
		 this.report(win,los);

	}
	
	/**
	 * display the cotation  of the two players
	 * @param win the winner
	 * @param los the loser
	 */
	
	private void report(Competitor win, Competitor los) {
		System.out.printf("%s   :  %s   actual cotation %.2f and   %s   cotation is   %.2f \n",this.name,win.toString(),this.cotes.get(win),los.toString(),this.cotes.get(los));
		
	}



	/**
	 * get  cotes of all competitors
	 * @return the map that contain the cotes of each competitor 
	 */
	public Map<Competitor,Float> getCotes(){
		return this.cotes;
	}
	
	/**
	 * decrease the cotes of the competitor passed as argument
	 * @param c comlpetitor
	 */
	private void decreaseCote(Competitor c) {
		if(this.cotes.get(c)>0) {
			this.cotes.put(c, (float) (this.cotes.get(c)-0.20));
		}
	}
	
	/**
	 * increase the cotes of the competitor passed as argument
	 * @param c competitor
	 */
	private void increaseCote(Competitor c) {
		
			this.cotes.put(c, (float) (this.cotes.get(c)+0.20));
		
	}
	







	@Override
	public Infos getCurentInfo() {
		
		return this.info;
	}




	



	




}
