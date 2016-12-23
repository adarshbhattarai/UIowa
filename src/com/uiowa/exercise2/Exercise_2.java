package com.uiowa.exercise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Exercise_2 {

	public static final int TOTAL_COUNTIES_IA = 99;

	static Set<String> RESIDING_COUNTY = new HashSet<String>();
	static Set<String> HOME_COUNTY = new HashSet<String>();
	static Set<String> COUNTY = new HashSet<String>();
	static Set<String> COUNTIES_IN_IA = new HashSet<String>();
	static Set<String> studentsNotinUIA = new HashSet<String>();

	// all those counties where students are from 
	public static List<String> ALL_COUNTIES = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileRead();
		totalCounties();

		int cStdNotInUIA = TOTAL_COUNTIES_IA - HOME_COUNTY.size();
		studentsNotinUIA.addAll(COUNTIES_IN_IA);
		studentsNotinUIA.removeAll(HOME_COUNTY);

		System.out.println("Number of Students Residing Counties = " + RESIDING_COUNTY.size());
		System.out.println("Number of Students Home Counties = " + HOME_COUNTY.size());
		System.out.println("Home County where no students are residing is from " + COUNTY.toString());
		System.out.println("Answer 1 : " + cStdNotInUIA + " Counties did not send students to the U of Iowa");
		System.out.println("They are : " + studentsNotinUIA);

		System.out.println("Answer 2: " + maxStudentCounty());
	}

	private static String maxStudentCounty() {
		// TODO Auto-generated method stub

		Collections.sort(ALL_COUNTIES);
		System.out.println(ALL_COUNTIES);
		// Converting List to array
		String[] values = ALL_COUNTIES.toArray(new String[ALL_COUNTIES.size()]);
		int count = 1, prevcount = 1;
		String county = null;
		for (int i = 0; i < values.length; i++) {

			if (i + 1 < values.length && values[i].equals(values[i + 1])) {
				count++;

			} else {
				if (count >= prevcount) {
					prevcount = count;
					county = values[i];
				}

				count = 1;

			}
		}

		return "Most students are from " + county + " County. Number of students = " + prevcount;
	}

	// Data read from counties_iowa.txt
	private static Set<String> totalCounties() {
		// TODO Auto-generated method stub
		String countiesdata = "doc/counties_iowa.txt";
		try {
			Scanner inputStream = new Scanner(new File(countiesdata));
			String data = null;
			// Reading all the county names from counties_iowa
			while (inputStream.hasNext()) {
				data = inputStream.nextLine();
				String[] listOfData = data.split(" County,");
				COUNTIES_IN_IA.add(listOfData[0]);
			}

			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return COUNTIES_IN_IA;

	}

	// this reads the column values of the file from test-data.csv
	private static void fileRead() {
		// TODO Auto-generated method stub
		String testData = "doc/test-data.csv";
		File file = new File(testData);

		try {
			Scanner inputStream = new Scanner(file);
			String data = null;
			// to omit the heading
			inputStream.nextLine();

			while (inputStream.hasNext()) {

				// Rows of the test-data
				data = inputStream.nextLine();
				// Adding those data to an array
				String[] values = data.split(",");
				// Second column is the residing county adding in a hashset. No
				// duplicate values
				RESIDING_COUNTY.add(values[1]);
				// ALL counties of all students
				ALL_COUNTIES.add(values[5]);
				// sixth column is the HOMECOUNTY.
				HOME_COUNTY.add(values[5]);
				// COUNTY For extra county that no student is residing.
				// So adding total home county minus the residing county
				COUNTY.addAll(HOME_COUNTY);
				COUNTY.removeAll(RESIDING_COUNTY);

			}

			inputStream.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
