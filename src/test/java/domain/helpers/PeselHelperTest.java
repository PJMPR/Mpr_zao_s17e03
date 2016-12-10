package domain.helpers;

import static org.junit.Assert.*;

import org.junit.Test;

public class PeselHelperTest {
    public static String CORRECT_PESEL = "43061213866";
	
	@Test
	public void CheckCorrectPeselTest() {
		boolean isCorrect = PeselHelper.checkPesel(CORRECT_PESEL);
		assertTrue(isCorrect);
    }

	@Test
	public void CheckPeselWithInvalidCharactersTest() {
		String peselWithChar = "adcsadfsadcsa";
		isCorrect=PeselHelper.checkPesel(peselWithChar);
		assertFalse(isCorrect);
    }

	@Test
	public void CheckPeselWithInvalidLengthTest() {
		isCorrect = PeselHelper.checkPesel("213242353464576");
		assertFalse(isCorrect);
    }

	@Test
	public void CheckPeselWithInvalidChecksumTest() {
		isCorrect = PeselHelper.checkPesel("43061213867");
		assertFalse(isCorrect);
	}

}
