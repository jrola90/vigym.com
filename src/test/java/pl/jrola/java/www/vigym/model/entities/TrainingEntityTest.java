package pl.jrola.java.www.vigym.model.entities;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

public class TrainingEntityTest {

	TrainingEntity training1;
	TrainingEntity training2;
	TrainingEntity training3;
	TrainingEntity training4;
	TrainingEntity training5;

	@Before
	public void setUp() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		UserEntity user = new UserEntity(1L, "", "", "", 1L);
		ExerciseEntity exercise = new ExerciseEntity(1L, "", "");

		training1 = new TrainingEntity(1L, sdf.parse("11-08-2014"), 1.1, 1,
				exercise, user, 1L);
		training2 = new TrainingEntity(1L, sdf.parse("11-08-2014"), 1.1, 1,
				exercise, user, 1L);
		training3 = new TrainingEntity(1L, sdf.parse("12-08-2014"), 1.1, 12,
				exercise, user, 1L);
		training4 = new TrainingEntity(2L, sdf.parse("11-08-2014"), 1.1, 1,
				exercise, user, 1L);
		training5 = new TrainingEntity(1L, sdf.parse("12-08-2014"), 1.1, 1,
				exercise, user, 1L);

	}

	@Test
	public void testEqualsObject() {
		assertEquals(false, training1.equals(null));
		assertEquals(true, training1.equals(training1));
		assertEquals(true, training1.equals(training2));
		assertEquals(false, training1.equals(training3));
		assertEquals(false, training1.equals(training4));
		assertEquals(false, training1.equals(training5));
	}

	@Test
	public void testCompareObject() {
		assertEquals(1, training1.compareTo(null));
		assertEquals(0, training1.compareTo(training1));
		assertEquals(0, training1.compareTo(training2));
		assertEquals(-1, training1.compareTo(training5));
		assertEquals(1, training5.compareTo(training1));
		assertEquals(1, training3.compareTo(training2));
	}

}