package competition;

import java.util.ArrayList;
import java.util.List;

import competition.division.Devision;
import competition.observers.Observercmp;
import competition.selection.Selection;
import competitor.Competitor;
import matchs.DefaultMatch;
import matchs.Match;

public class Master extends Competition {
	private Devision poulCreateur;
	protected Selection getSelection() {
		return selection;
	}

	private Selection selection;
	private Tournament tournoi;
	private List<League> poules;
	private int nbBool;

	public Master(List<Competitor> lc,Selection selection,int nbpool) {
		super(lc);
		this.selection=selection;
		this.poulCreateur=new Devision(nbpool,lc);
		this.poules=new ArrayList<>();
		this.nbBool=nbpool;
	}

	@Override
	protected Match createMatch() {
		
		return new DefaultMatch();
	}	

	@Override
	protected void play(List<Competitor> lc) {
		this.playPoules();
		
		List <Competitor>qualifiers=this.selection.select(this.poules);
		this.playFinals(qualifiers);
		
			
	}

	protected void playFinals(List<Competitor> qualifiers) {
		displayQualifiers(qualifiers);
		
		System.out.println("\n *******playing finals******\n");
		this.tournoi=new Tournament (qualifiers);
		for (Observercmp o :this.observers) {
			this.tournoi.addObserver(o);
		}
		this.tournoi.play();
		for(Competitor c : tournoi.getCompetitors()) {
			this.ranking.put(c, this.ranking.get(c)+tournoi.ranking().get(c));
			this.playedMatch.put(c,this.playedMatch.get(c)+tournoi.playedMatch().get(c) );
		}
	}

	/**
	 * @param qualifiers the qualifiers to the finals
	 */
	private void displayQualifiers(List<Competitor> qualifiers) {
		System.out.println("******qualifiers are : \n ");
		for(Competitor c :qualifiers) {
			System.out.println("\u001B[32m"+c+"\u001B[37m");
		}
	}
 
	/**
	 * play the groupe stage of the master
	 */
	protected void playPoules() {
		this.division();
		int cptGroupes=0;
		for(League l:this.poules) {
			System.out.println("Matchs of the "+ cptGroupes+"th groupe");
			l.play();
			cptGroupes++;
		
			for(Competitor c : l.getCompetitors()) {
				this.ranking.put(c, l.ranking().get(c));
				this.playedMatch.put(c,l.playedMatch().get(c) );
			}
		}
	}
	
	/**
	 * initialize the groupes 
	 */
	protected void division() {
		this.poules=this.poulCreateur.createPoule();
		for(League l : this.poules) {
			for (Observercmp o:this.observers) {
				l.addObserver(o);
			}
		}
	}
	
	/**
	 * get the list of the groupes of the master
	 * @return list of the groupes of the master
	 */
	protected List<League> getPoules(){
		return this.poules;
	}
	
	/**
	 * get the tournament in which the finals are played
	 * @return the tournament in which the finals are played
	 */
	protected Tournament getFinals() {
		return this.tournoi;
	}

	
	/**
	 * get the number of groupes of the master 
	 * @return the number of groupes of the master 
	 */
		protected int getNbBool() {
		return nbBool;
	}
	
	/**
	 * display the ranking of each groupes,the finals and all the master and the winner of the master
	 */
	public void displayCompetition() {
		int cptGroupes=1;
		System.out.println("*******phase de groupe *******");
			for(League l : this.poules) {
				System.out.println("ranking groupe "+ cptGroupes);
				cptGroupes++;
				l.displayCompetition();
			}
		System.out.println("*******elimination direct *******");
		this.tournoi.displayCompetition();
		System.out.println("*******ranking de Master *******");
		super.displayCompetition();
		
		Competitor winner = Operation.getfst(this.tournoi.ranking());
		System.out.println("*******Winner *******");
		System.out.println("\u001B[32m"+winner+"\n");
			
	}

	@Override
	protected int getNbMatch() {
		int res =0;
		for (League l : this.poules) {
			res+=l.getNbMatch();
		}
		res+=this.tournoi.getNbMatch();
		return res;
	}
	
	

	
	
	
		
	

}
