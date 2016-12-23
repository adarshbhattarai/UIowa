package com.uiowa.exercise1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise1_java8 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> words = Arrays.asList("A1", "F1", "F12", "F7", "A9", "A3");

		Stream<String> sortedFirst = words.stream()
				// Sorting the Integer values
				.sorted((x, y) -> Integer.compare(Integer.parseInt(x.substring(1)), Integer.parseInt(y.substring(1))))
				// Sorting the first characters
				.sorted((x, y) -> Character.compare(x.charAt(0), y.charAt(0)));

		System.out.println(sortedFirst.collect(Collectors.toList()));

	}

}
