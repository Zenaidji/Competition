package competition.division;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import competition.League;
import competitor.Competitor;

public class Devision {
private List<Competitor> lc;
private int nbpoules;


	/**
	 * create a new deviseur
	 * @param nbpoules number of groupes in the groupe stage
	 * @param lc List of competitors to devide into groupes
	 */
	public  Devision(int nbpoules,List<Competitor> lc) {	
		this.lc=lc;
		this.nbpoules = nbpoules;
		
	}
	
	/**
	 * the methods that devides the list of competitors into leagues
	 * @return List of leagues that represents the groups 
	 */
	public List<League> createPoule(){
		int nbTeamsInP=this.lc.size()/this.nbpoules;
		List <League> res = new ArrayList<>();
		List<List<Competitor>>tmpl = new ArrayList<>();
		for(int i =0;i<this.nbpoules;i++) {
			tmpl.add(new ArrayList<Competitor>());
		}
		int cptTeams = 0;
		Iterator<List<Competitor>> itList= tmpl.iterator();
		List<Competitor> poule =itList.next();
		Iterator <Competitor>itComp=this.lc.iterator();
		while(itList.hasNext()) {
			
				poule.add(itComp.next());
				cptTeams++;
			
			if(cptTeams==nbTeamsInP) {
				cptTeams=0;
				if(itList.hasNext()) {
					poule=itList.next();
				}
			}
		}
		while(itComp.hasNext()){
			poule.add(itComp.next());
			
		}
		for(List<Competitor> l : tmpl) {
			res.add(new League(l));
			}
	return res;
	}
}
