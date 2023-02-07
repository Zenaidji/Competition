package competition.selection;

import org.junit.jupiter.api.BeforeEach;

public abstract class SelectionTest {
	protected Selection selection;
	public abstract Selection createSelection();
	@BeforeEach
	public void init() {
		this.selection=this.createSelection();
	}
}
