package pl.jrola.java.www.vigym.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class Utils {

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
	
}