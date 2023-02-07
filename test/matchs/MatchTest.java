package matchs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competitor.Competitor;

public abstract class MatchTest {
	
	protected  Match match;
	protected Competitor c1;
	protected Competitor c2;
	
	public abstract Match createMatch();
	
	@BeforeEach 
	public void init() {
		this.match=this.createMatch();
	}
	
	
	

}
