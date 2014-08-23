package pl.jrola.java.www.vigym.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Utils {

	public static final String DATE_FORMAT = "yyyy-MM-dd";
	
	public static String generateSHA1Hash(String message) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			md.update(message.getBytes());
			return new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	
	public static void logError(Exception e) {
		e.printStackTrace();
	}
	
	public static String getDateAsString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(Utils.DATE_FORMAT);
		return sdf.format(date);
	}
	
}