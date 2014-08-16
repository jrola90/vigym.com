package pl.jrola.java.www.vigym.model.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProfileInfoEntityTest {

	ProfileInfoEntity info1;
	ProfileInfoEntity info2;
	ProfileInfoEntity info3;
	ProfileInfoEntity info4;
	ProfileInfoEntity info5;
	ProfileInfoEntity info6;
	
	UserEntity user;
	
	@Before
	public void setUp() throws Exception {
		user = new UserEntity(1L, "", "", "", 1L);
		info1 = new ProfileInfoEntity(1L, "name", "desc", user, 1L);
		info2 = new ProfileInfoEntity(1L, "name", "desc", user, 1L);
		info3 = new ProfileInfoEntity(2L, "name", "desc", user, 1L);
		info4 = new ProfileInfoEntity(1L, "name1", "desc", user, 1L);
		info5 = new ProfileInfoEntity(1L, "name", "desc1", user, 1L);
		info6 = new ProfileInfoEntity(1L, "name", "desc1", user, 11L);
	}

	@Test
	public void testEqualsObject() {
		assertEquals(true, info1.equals(info1));
		assertEquals(false, info1.equals(null));
		assertEquals(true, info1.equals(info2));
		assertEquals(true, info2.equals(info1));
		assertEquals(false, info1.equals(info3));
		assertEquals(false, info1.equals(info4));
		assertEquals(false, info1.equals(info5));
		assertEquals(false, info1.equals(info6));
		
	}

}
