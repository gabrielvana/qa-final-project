package utils;

import java.util.Random;

public class RandomGenerator {
	
	// metoda generare random INT-uri 
	public static int integerValue(int upperRange) {
		Random random = new Random();
		return random.nextInt(upperRange);
	}
	
	// metoda generare random STRING-uri 
	public static String stringValue(int count) {
		String CHARACTER_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*CHARACTER_STRING.length());
			builder.append(CHARACTER_STRING.charAt(character));
				}
		return builder.toString();
	}

}
