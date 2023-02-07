package competition;

import java.util.*;

import competitor.Competitor;
import matchs.DefaultMatch;
import matchs.Match;

public class Tournament extends Competition {
	
	/**
	 * create a new tournament
	 * @param lc the list of all competitors
	 */
	public Tournament(List<Competitor> lc) throws Puissance2Exception{
		super(lc);
		if(!Operation.islog2(lc.size())){

			throw new Puissance2Exception("pas une puissance de deux");
			
		}
	
		
	}
	

	@Override
	/**
	 * play the all the matches of the tournament
	 */
	protected void play(List<Competitor> lc){
		Competitor [] winnertab=new Competitor[lc.size()];
		winnertab = lc.toArray(winnertab);
		int tour=0;
		while(tour<Operation.log2(lc.size())) {
			tour=tour + 1;
			List<Competitor>tmpl=new ArrayList<>();
			for(int i=0;i<winnertab.length;i+=2) {
				this.playMatch(winnertab[i],winnertab[i+1]);
				if(this.ranking.get(winnertab[i])==tour) {
					tmpl.add(winnertab[i]);
				}
				else {
					tmpl.add(winnertab[i+1]);
				}
			}
			winnertab=new Competitor[tmpl.size()];
			winnertab = tmpl.toArray(winnertab);
		}
	}
	
	/**
	 * create the type of match to play the tournament
	 */
	protected Match createMatch() {
		return new DefaultMatch();
		
	}
	
	
	public    int getNbMatch(){
	int n=this.getCompetitors().size()-1;
	return n;
	}
	
	
		
	
 
	}
