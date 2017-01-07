package domain.helpers;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

public class PeselHelperTest {
    public static String CORRECT_PESEL = "96061010469";
	
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
/*
	@Test
	public void extractDateFromPeselTest(){
		Date date = PeselHelper.getDate(CORRECT_PESEL);
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(1996, 6, 10);
		assertEquals(date, calendar.getTime());
	}
	
	@Test
	public void extractGenderFromPeselTest(){
		Gender gender = PeselHelper.getGender(CORRECT_PESEL);
		assertEquals(Gender.FEMALE, gender);
	}
	*/
}
