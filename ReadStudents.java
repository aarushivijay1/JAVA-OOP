package com.fairfield.semesterproject;

import java.io.File;
import java.util.Scanner;

public final class ReadStudents {

	/*
	 * The purpose of this class is to read the random_students_data.csv file
	 * The format of the file is text with comma separated fields.
	 * 
	 *  Description of the fields:
	 *  Student Id (integer),First Name (string),Last Name (string),Score in Science (integer),Score in History (integer),Score in Mathematics (integer),Score in English (integer)
	 *  
	 *  each column will be stored into a separate array
	 * 
	 */

	private static int[] studentId = new int[200];
	private static String[] firstName = new String[200];
	private static String[] lastName = new String[200];
	private static int[] scienceScore = new int[200];
	private static int[] historyScore = new int[200];
	private static int[] mathematicsScore = new int[200];
	private static int[] englishScore = new int[200];

	public ReadStudents() {
		
		// scanner to read each token of a line
		Scanner rowScanner;

		// trying to open the file
		try (Scanner scanner = new Scanner(new File("/Users/aarushi.vijay/eclipse-workspace/Semester/src/com/fairfield/semesterproject/random_students_data.csv"));) {

			int i = 0;

			//read line by line
			while (scanner.hasNextLine()) {

				rowScanner = new Scanner( scanner.nextLine() );
				rowScanner.useDelimiter(",");

				studentId[i] = Integer.parseInt( rowScanner.next() );
				firstName[i] = rowScanner.next();
				lastName[i] = rowScanner.next();
				scienceScore[i] = Integer.parseInt( rowScanner.next() );
				historyScore[i] = Integer.parseInt( rowScanner.next() );
				mathematicsScore[i] = Integer.parseInt( rowScanner.next() );
				englishScore[i] = Integer.parseInt( rowScanner.next() );

				i++;

			}
		}catch( Exception e ) {
			System.out.println("Not sure where the file is ...");
		}

	}

	
	/*
	 * returns array of student IDs
	 */
	public static int[] getStudentId() {
		return studentId;
	}

	
	/*
	 * returns array of student first names
	 */
	public static String[] getFirstName() {
		return firstName;
	}
	
	
	/*
	 * returns array of student last names
	 */
	public static String[] getLastName() {
		return lastName;
	}
	
	
	/*
	 * returns array of student score in science
	 */
	public static int[] getScienceScore() {
		return scienceScore;
	}
	
	
	/*
	 * returns array of student score in history
	 */
	public static int[] getHistoryScore() {
		return historyScore;
	}
	
	
	/*
	 * returns array of student score in mathematics
	 */
	public static int[] getMathematicsScore() {
		return mathematicsScore;
	}
	
	
	/*
	 * returns array of student score in english
	 */
	public static int[] getEnglishScore() {
		return englishScore;
	}

	
}
