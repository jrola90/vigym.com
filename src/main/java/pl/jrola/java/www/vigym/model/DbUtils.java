package pl.jrola.java.www.vigym.model;

public abstract class DbUtils {

	public static class USERS_TABLE {
		public static final String TABLE_NAME = "users";
		public static final String ID = "user_id";
		public static final String NICKNAME = "user_nickname";
		public static final String PASSWORD = "user_password";
		public static final String EMAIL = "user_mail";
		public static final String MOBILE_ID = "user_mobile_id";
	}

	public static class EXERCISES_TABLE {
		public static final String TABLE_NAME = "exercises";
		public static final String ID = "exercise_id";
		public static final String NAME = "exercise_name";
		public static final String DESC = "exercise_desc";
	}
	
}