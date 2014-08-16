package pl.jrola.java.www.vigym.model.entities;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

public class ProfileInfoValueEntityTest {

	ProfileInfoEntity pi;

	ProfileInfoValueEntity piv1;
	ProfileInfoValueEntity piv2;
	ProfileInfoValueEntity piv3;
	ProfileInfoValueEntity piv4;
	ProfileInfoValueEntity piv5;

	SimpleDateFormat sdf;
	
	@Before
	public void setUp() throws Exception {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		pi = new ProfileInfoEntity(1L, "", "", new UserEntity(), 1L);
		piv1 = new ProfileInfoValueEntity(1L, sdf.parse("11-08-2014"), 11.,
				new UnitEntity(), pi, 1L);
		piv2 = new ProfileInfoValueEntity(2L, sdf.parse("12-08-2014"), 13.,
				new UnitEntity(), pi, 1L);
		piv3 = new ProfileInfoValueEntity(3L, sdf.parse("12-08-2014"), 12.,
				new UnitEntity(), pi, 1L);
		pi.getProfileInfoValues().add(piv1);
		pi.getProfileInfoValues().add(piv2);
		pi.getProfileInfoValues().add(piv3);
	}

	@Test
	public void testCompareTo() {
		assertEquals(0, piv1.compareTo(piv1));
		assertEquals(-1, piv1.compareTo(piv2));
		assertEquals(1, piv2.compareTo(piv1));
		assertEquals(-1, piv1.compareTo(piv3));
		assertEquals(-1, piv2.compareTo(piv3));
		assertEquals(1, piv3.compareTo(piv2));
	}
	
	@Test
	public void testGetLastDate() throws Exception {
		assertEquals(sdf.parse("12-08-2014"), pi.getLastDate());
	}
	
	@Test
	public void testGetCurrentValue() {
		assertEquals(new Double(12), pi.getCurrentValue());
	}

	@Test
	public void testProgress() {
		assertEquals(new Double(1), pi.getProgress());
	}

}