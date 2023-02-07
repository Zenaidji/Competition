package competition.observers;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competition.infos.Infos;
import competitor.Competitor;

public abstract class ObservableTest {
	protected Observercmp obs;
	
	public abstract Observercmp init();
	
	@BeforeEach
	public void initialisation() {
		this.obs=init();
	}
	
	@Test
	public void theObserverGetTheRightInfo() {
		Infos i = new Infos(new Competitor("hakim"),new Competitor("ghani"),"0-2");
		assertFalse(i.equals(obs.getCurentInfo()));
		this.obs.setCurentInfo(i);
		assertTrue(i.equals(obs.getCurentInfo()));
	}
}
