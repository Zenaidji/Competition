package competition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import competition.infos.Infos;
import competition.observers.Observercmp;
import competition.score.DefaultScoreGenerator;
import competition.score.ScoreGenerator;
import competitor.Competitor;
import matchs.Match;
import util.MapUtil;

public abstract class Competition {
	private final List<Competitor> competitors;
	protected Map <Competitor,Integer> ranking;
	protected Map<Competitor,Integer> playedMatch;
	protected Match match;
	protected List<Observercmp> observers;
	protected ScoreGenerator sg;
	
	/**
	 * Create a new Competition
	 * @param lc list of the competitors for the new competition
	 */
	public Competition(List<Competitor> lc){
		this.competitors=lc;
		this.ranking= new HashMap<>();
		this.playedMatch=new HashMap<>();
		this.init();
		this.initMaps();
		this.observers=new ArrayList<>();
		this.sg=new DefaultScoreGenerator();
	}
	
	/**
	 * create the type of the match which will be played in the competition
	 * @return match will be played in the competition
	 */
	protected  abstract Match createMatch();
	
	/**
	 * Initialize the match to play the competiton
	 */
	private void init() {
		this.match=this.createMatch();
	}
	 /**
	  * Initialize the two maps playedMatch and ranking
	  */
	protected void initMaps() {
		for(Competitor c:this.competitors) {
			this.ranking.put(c,0);
			this.playedMatch.put(c,0);
			}
		
	}
	
	/**
	 * play all the competition
	 */
	public void play() {
		this.play(this.competitors);
		
	}
	
	
	
	
	/**
	 * play the competition ( all the matches) of the competition between the teams of the list lc
	 * @param lc the list of competitors 
	 */
	protected abstract void play(List<Competitor> lc) ;
	
	/**
	 * play a match between two competitor
	 * @param c1 the first competitor
	 * @param c2 the second competitor
	 */
	public void playMatch(Competitor c1,Competitor c2) {
		Competitor winner = this.match.playThisMatch(c1, c2);
		this.ranking.put(winner,this.ranking.get(winner)+1);
		this.playedMatch.put(c1,this.playedMatch.get(c1)+1);
		this.playedMatch.put(c2,this.playedMatch.get(c2)+1);
		this.dispalyOneMatch(c1,c2,winner);
		Competitor loser = this.match.getLoser(winner,c1,c2);
		String score = this.sg.generate();
		Infos in = new Infos(winner,loser,score);
		this.observeAll(in);
		
		
	};
	
	/**
	 * return the ranking  of the competition sorted in descending way 
	 * @return the ranking of the competition 
	 */
	public Map<Competitor, Integer> ranking(){
		return MapUtil.sortByDescendingValue(this.ranking);
	}

	/**
	 * get the list of competitors
	 * @return the list of competitors
	 */
	public List<Competitor> getCompetitors() {
		return this.competitors;
	}
	
	/**
	 * get the map with for each competitor its number of points 
	 * @return a map of Competitors : nb point of the competitor
	 */
	public Map<Competitor,Integer> playedMatch(){
		return this.playedMatch;
	}
	
	/**
	 * display the two teams playing a match and the winner
	 * @param c1 the first team
	 * @param c2 the second team
	 * @param win the winner after playing the match c1 vs c2
	 */
	private void dispalyOneMatch(Competitor c1,Competitor  c2,Competitor win) {
		System.out.println(c1 + " vs " +c2 + "------>" + "\u001B[32m"+win + " wins"+"\u001B[37m");
	}
	
	public void displayCompetition() {
		Map<Competitor,Integer>compRanking= this.ranking();
		System.out.println("***Ranking***");
		for(Competitor c:compRanking.keySet()) {
			System.out.println(c.toString()+"-->"+compRanking.get(c));
			
		}
		
		
	}
	
	
	/**
	 * send the information i to all observers
	 * @param i inormation to send 
	 */
	
	protected void observeAll(Infos i) {
		for (Observercmp o: this.observers) {
			o.observe(i);	
		}
	}
	
	
	
	/***
	 * add new observer to the list of observers
	 * @param o observer 
	 */
	public void addObserver(Observercmp o) {
		o.setCompetition(this);
		this.observers.add(o);
		
	}
	
	/**
	 * get all observers
	 * @return the list of all observers
	 */

	public List<Observercmp> getObservers() {
		
		return this.observers;
	}
	
	
	/**
	 * get the total number of match played during the competition
	 * @return number of match
	 */
	protected  abstract int getNbMatch();
	

}
