package domain.helpers;

import static org.junit.Assert.*;

import org.junit.Test;

public class PeselHelperTest {
    public static String CORRECT_PESEL = "43061213866";
	
	@Test
	public void CheckCorrectPeselTest() {
		assertTrue(PeselHelper.checkPesel(CORRECT_PESEL));
    }

	@Test
	public void CheckPeselWithInvalidCharactersTest() {
		assertFalse(PeselHelper.checkPesel("A3O61213866"));
    }

	@Test
	public void CheckPeselWithInvalidLengthTest() {
		assertFalse(PeselHelper.checkPesel("213242353464576"));
    }

	@Test
	public void CheckPeselWithInvalidChecksumTest() {
		assertFalse(PeselHelper.checkPesel("43061213867"));
	}

}
