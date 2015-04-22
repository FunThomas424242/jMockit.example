package jmockit.example;

import mockit.Injectable;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Tested;
import mockit.Verifications;

import org.junit.Test;

public class RechnerTest {

	@Mocked
	private Formatierer formatierer;
	
	@Injectable
	private String format="#.###.##";
	
	@Tested
	Rechner rechner;

	@Test
	public void addiereZulaessig() {
		
		new NonStrictExpectations(){{
			new Formatierer(format); result=formatierer; times=0;
		}};

		rechner.addiere(3, 4);
		
		new Verifications(){{
			formatierer.formatiere(7); times=1;
		}};
		
	}

}
