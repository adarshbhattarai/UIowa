package com.uiowa.exercise1;

import java.util.Arrays;

public class Exercise_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] codes = new String[] { "A1", "F1", "F12", "F7", "A9", "A3" };
		solution(codes);
		for (String string : codes) {
			System.out.println(string);
		}
	}

	public static String[] solution(String[] codes) {
		Arrays.sort(codes);
		numericSort(codes);
		return codes;
	}

	private static void numericSort(String[] codes) {
		// TODO Auto-generated method stub

		for (int i = 0; i < codes.length; i++) {
			// Numeric values for sorting the list
			int firstint = Integer.parseInt(codes[i].substring(1));
			for (int j = i + 1; j < codes.length; j++) {
				int secondint = Integer.parseInt(codes[j].substring(1));
				String temp;
				// Comparing the first characters, if they are equal then sort
				if (codes[i].charAt(0) == codes[j].charAt(0)) {
					if (firstint > secondint) {
						temp = codes[i];
						codes[i] = codes[j];
						codes[j] = temp;
					}
				}
			}
		}

	}

}
