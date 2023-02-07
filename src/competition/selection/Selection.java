package competition.selection;

import java.util.ArrayList;
import java.util.List;

import competition.League;
import competitor.Competitor;

public interface Selection {
	
	
	/**
	 * the method that implements the type of selection
	 * @param lg List of o=played league in which selction must be done
	 * @return List of selected Competitors
	 */
	public   List <Competitor>select(List<League> lg);
	
}
