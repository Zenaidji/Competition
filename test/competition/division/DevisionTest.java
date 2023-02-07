package competition.division;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.jupiter.api.*;
import competition.League;
import competitor.Competitor;


public class DevisionTest {
	
	private  List<Competitor>lc;
	private int nbPoules=5;
	private int nbCompetiteurs=21;
	private Devision division;
	
	@BeforeEach
	public void init() {
		
		lc=new ArrayList<>();
		for (int i=0;i<this.nbCompetiteurs;i++) {
			lc.add(new Competitor("competiteur "+String.valueOf(i)));
		}	
		this.division=new Devision(this.nbPoules,this.lc);
	}
	
	@Test
	public void NbPoulesCreatedTest() {
		List<League> lg=this.division.createPoule();
		assertEquals(this.nbPoules,lg.size());
	}
	
	@Test
	public void allTeamsinThePoulesTest() {
		int cptTeams=0;
		List<League> lg=this.division.createPoule();
		for(League l :lg) {
			cptTeams+=l.getCompetitors().size();
			
		}
		assertEquals(this.nbCompetiteurs,cptTeams);
	}
	@Test
	public void eachTeamInLeaguesOnceTest() {
		Map<Competitor,Integer>found= new HashMap<>();
		for(Competitor c :this.lc) {
			found.put(c, 0);
		}
		List<League> lg=this.division.createPoule();
		for(League l : lg) {
			for(Competitor c :l.getCompetitors()) {
				found.put(c, found.get(c)+1);
			}
		}
		
		for(Competitor c :this.lc) {
			assertSame(1,found.get(c));
		}
		
		
	}
	
	

}
