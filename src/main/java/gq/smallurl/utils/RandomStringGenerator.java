package gq.smallurl.utils;

import java.util.Random;

/**
 * @author  Robin Raju
 * @since Sept 14, 2015
 *
 * */
public class RandomStringGenerator {
	/**
	 * @param 	len required length for random string
	 * @return  random string with specified length
	 * */
	public static String getRandomString(int len) {
		final String AB = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
}
