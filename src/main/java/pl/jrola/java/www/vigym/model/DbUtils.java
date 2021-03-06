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
	
	public static class TRAININGS_TABLE {
		public static final String TABLE_NAME = "trainings";
		public static final String ID = "training_id";
		public static final String DATE = "training_date";
		public static final String VALUE = "training_value";
		public static final String COUNT = "training_count";
		public static final String EXERCISE = "training_exercise_id";
		public static final String USER = "training_user_id";
		public static final String MOBILE_ID = "training_mobile_id";
	}
	
	public static class PROFILE_INFO_TABLE {
		public static final String TABLE_NAME = "profile_information";
		public static final String ID = "prof_info_id";
		public static final String NAME = "prof_info_name";
		public static final String DESC = "prof_info_desc";
		public static final String USER = "prof_info_user_id";
		public static final String MOBILE_ID = "prof_info_mobile_id";
	}
	
	public static class UNITS_TABLE {
		public static final String TABLE_NAME = "units";
		public static final String ID = "unit_id";
		public static final String NAME = "unit_name";
		public static final String DESC = "unit_desc";
		public static final String SHORT_NAME = "unit_short_name";
	}
	
	public static class PROFILE_INFO_VALUES_TABLE {
		public static final String TABLE_NAME = "profile_information_values";	
		public static final String ID = "prof_info_val_id";
		public static final String VALUE = "prof_info_val_value";
		public static final String DATE = "prof_info_val_date";
		public static final String UNIT = "prof_info_val_unit_id";
		public static final String PROF_INFO = "prof_info_val_info_id";
		public static final String MOBILE_ID = "prof_info_val_mobile_id";
	}
	
}