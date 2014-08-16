package pl.jrola.java.www.vigym.model.entities;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

public class UserEntityTest {

	UserEntity user1;
	UserEntity user2;
	UserEntity user3;
	UserEntity user4;

	ExerciseEntity exercise;

	TrainingEntity training1;
	TrainingEntity training2;
	TrainingEntity training3;

	@Before
	public void setUp() throws Exception {
		user1 = new UserEntity(1L, "a", "b", "c", 1L);
		user2 = new UserEntity(1L, "a", "b", "c", 1L);
		user3 = new UserEntity(2L, "a", "bb", "c", 1L);
		user4 = new UserEntity(1L, "a", "b", "cc", 2L);

		exercise = new ExerciseEntity(1L, "", "");

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		training1 = new TrainingEntity(1L, sdf.parse("11-08-2014"), 1.1, 1,
				exercise, user1, 1L);

		training2 = new TrainingEntity(2L, sdf.parse("12-08-2014"), 1.1, 1,
				exercise, user1, 1L);

		training3 = new TrainingEntity(3L, sdf.parse("12-08-2014"), 1.1, 1,
				exercise, user1, 1L);

	}

	@Test
	public void testEqualsObject() {
		assertEquals(true, user1.equals(user1));
		assertEquals(false, user1.equals(null));
		assertEquals(true, user1.equals(user2));
		assertEquals(false, user1.equals(user3));
		assertEquals(false, user1.equals(user4));
	}

	@Test
	public void testGetLastTraining() throws Exception {

		user1.getTrainings().add(training1);
		user1.getTrainings().add(training2);
		user1.getTrainings().add(training3);

		assertEquals(training3, user1.getLastTraining());
	}
}
