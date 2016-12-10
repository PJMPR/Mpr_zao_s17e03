package domain.helpers;

import static org.junit.Assert.*;

import org.junit.Test;

public class PeselHelperTest {

	
	
	@Test
	public void CheckPeselTest() {
		
		String correctPesel = "43061213866";
		boolean isCorrect = PeselHelper.checkPesel(correctPesel);
		assertTrue(isCorrect);
		String peselWithChar = "adcsadfsadcsa";
		isCorrect=PeselHelper.checkPesel(peselWithChar);
		assertFalse(isCorrect);
		isCorrect = PeselHelper.checkPesel("213242353464576");
		assertFalse(isCorrect);
		isCorrect = PeselHelper.checkPesel("43061213867");
		assertFalse(isCorrect);
	}

}
