package pl.jrola.java.www.vigym.model.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UnitEntityTest {

	UnitEntity unit1;
	UnitEntity unit2;
	UnitEntity unit3;
	UnitEntity unit4;
	UnitEntity unit5;

	@Before
	public void setUp() throws Exception {
		unit1 = new UnitEntity(1L, "name", "desc", "shortName");
		unit2 = new UnitEntity(1L, "name", "desc", "shortName");
		unit3 = new UnitEntity(2L, "name", "desc", "shortName");
		unit4 = new UnitEntity(1L, "name", "desc1", "shortName");
		unit5 = new UnitEntity(1L, "name", "desc", "shortName1");
	}

	@Test
	public void testEqualsObject() {
		assertEquals(false, unit1.equals(null));
		assertEquals(true, unit1.equals(unit1));
		assertEquals(true, unit1.equals(unit2));
		assertEquals(true, unit2.equals(unit1));
		assertEquals(false, unit1.equals(unit3));
		assertEquals(false, unit1.equals(unit4));
		assertEquals(false, unit1.equals(unit5));
	}

}
