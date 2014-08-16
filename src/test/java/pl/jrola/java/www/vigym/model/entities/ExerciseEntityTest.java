package pl.jrola.java.www.vigym.model.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExerciseEntityTest {

	private ExerciseEntity exercise1;
	private ExerciseEntity exercise2;
	private ExerciseEntity exercise3;
	private ExerciseEntity exercise4;
	private ExerciseEntity exercise5;
	
	@Before
	public void setUp() throws Exception {
		exercise1 = new ExerciseEntity(1L, "name1", "desc1");
		exercise2 = new ExerciseEntity(2L, "name2", "desc2");
		exercise3 = new ExerciseEntity(1L, "name1", "desc1");
		exercise4 = new ExerciseEntity(2L, "name11", "desc1");
		exercise5 = new ExerciseEntity(2L, "name1", "desc11");
	}

	@Test
	public void testEqualsObject() {
		assertEquals(false, exercise1.equals(exercise2));
		assertEquals(true, exercise1.equals(exercise3));
		assertEquals(false, exercise1.equals(exercise4));
		assertEquals(false, exercise1.equals(exercise5));
		assertEquals(true, exercise1.equals(exercise1));
		assertEquals(false, exercise1.equals(null));
	}

}