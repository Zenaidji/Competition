package competition.score;

import java.util.Random;

public class DefaultScoreGenerator implements ScoreGenerator {

	public DefaultScoreGenerator() {
		
	}
	@Override
	public String generate() {
		int b1;
		int b2=0;
		Random r = new Random();
		b1 = r.nextInt(9)+1;
		b2=r.nextInt(b1);
		return b1+"-"+b2;
		
	}
	
}
