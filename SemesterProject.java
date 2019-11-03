package com.fairfield.semesterproject;
import java.util.Arrays;
import java.util.Scanner;

public class SemesterProject //creating a class to run the following program 
{
	
	public static final int max= 200; //setting the number of students as the constant 

	static ReadStudents rs = new ReadStudents(); 

	private static int english[]= rs.getEnglishScore(); //initialize the English score array with values from the data 
	private static int history[]= rs.getHistoryScore();  //initialize the History score array with values from the data 
	private static int math[] = rs.getMathematicsScore(); //initialize the Mathematics score array with values from the data 
	private static int science[]= rs.getScienceScore();//initialize the Science score array with values from the data 
	private static int id[]= rs.getStudentId(); //initialize the Student ID array with values from the data 
	private static String firstname[]= rs.getFirstName(); //initialize the first name array with values from the data 
	private static String lastname[]= rs.getLastName(); //initialize the last name array with values from the data 
	
	public static void main( String[] args) //the main method 
	
	{
		
		interfacewithuser(); //invoking the interface with the user 
	}
	
	public static void display() //method to display the student ID, first name, last name, total score and percentage of the students 
	{
		
		
		int[] totalscore = totalscore(english, history, math, science); //invoking total score method 
		double[] percent= percentagestudents(english, history, math, science); //invoking method to calculate percentages 
		
		for (int i =0; i<max; i++) {
			System.out.println(firstname[i] + " " + lastname[i] + " has a student ID " + id[i] + " with a total score of " + totalscore[i] + " and percentage " +  percent[i] );
		}
		
	}
	
	public static int[] totalscore(int english[], int history[], int mathematics[], int science[]) //method to sum the English, math, science and history scores 
	{
		
		
		int [] totalScore;
		totalScore = new int[200]; //declaring a new array to store total scores 
		
		for (int i = 0; i<200; i++)
		{
			totalScore[i]= english[i]+ mathematics[i]+ science[i] + history[i];	
		}
		
		return totalScore; //returning the total score array
	}
	
	public static double[] percentagestudents(int english[], int history[], int mathematics[], int science[]) //method to calculate the percentage of each students 
	{
		double[] percentage;
		percentage = new double[200]; //declaring new array for percentages of each student 
		
		for (int i=0; i<200; i++)
		{
		    percentage[i]= (english[i]+ mathematics[i]+ science[i] + history[i])/4.00;

		}
		
		return percentage; //returning the percentage array
		}
	
	public static int[] topten(int scores[]) //function to find the top ten scores in the subject passed as a parameter
	{
		int[] copiedArray = Arrays.copyOf(scores, max); //making a copy of the array so that it does not alter the original array
		int[] topTenScores = new int[10]; //new array for storing top ten scores
		for(int i=0; i< max; i++) { 
			for (int j=i+1; j<max; j++) { //sorting the array according to the decreasing order 
				if (copiedArray[i] < copiedArray[j]) {
					int temp = copiedArray[i]; 
					copiedArray[i] = copiedArray[j];
					copiedArray[j] = temp;
				}
			}
		}
		for (int i = 0; i< 10; i++) {
			topTenScores[i] = copiedArray[i]; //storing the top ten scores from the sorted array
		}
		return topTenScores; //returning the scores of the top ten students 
	}
	
	public static int[] getIndexesOfTopTenStudents(int[] topTenScores, int[] scores)  //function to get the top ten indexes
	{
		int[] topTenIndexes = new int[10]; //creating new array to store the indexes of the top ten students
		boolean present = false; 
		for (int i= 0; i< topTenScores.length; i++) { //outer loop for the top ten scores
			for (int j=0; j < scores.length; j++) { //inner loop for the all the scores 
				if (topTenScores[i] == scores[j]) //checking if top ten is equal to scores 
					{
					for (int k=0; k<topTenIndexes.length; k++) {
						if (j == topTenIndexes[k]) {
							present = true;
							break;
						}
					}
					if (present) {
						continue;
					} else {
						topTenIndexes[i] = j;
					}
				}
				present = false;
			}
		}
		return topTenIndexes; //returning the indexes of top ten students 
	}
	
	public static int findwhopassed(int[] scores) //function to find number of students  who passed 
	{
		int countpass=0; //variable to store the number of students who passed 
		for(int i=0; i< scores.length; i++)
		{
			if(scores[i] > 60) //condition to check if the scores are passing or not
			{
				countpass++;
			}
		}
		return countpass; //returning the number of students who passed 
	}

	public static int findwhofailed(int[] scores) //function to find number of students who failed 
	{
		int countfail=0; //variable to store the number of students who failed 
		for(int i=0; i< scores.length; i++)
		{
			if(scores[i] < 60) //condition to check if the scores are failing or not
			{
				countfail++;
			}
		}
		return countfail; //returning the number of students who failed 
	}
	
	public static double passpercent(int scores[]) //function to find the pass percentage in the score passed as the parameter 
	{
	   int numpass = findwhopassed(scores); //calling the function to get the number of students passed 

	   double percentage = ((numpass * 100)/ 200); //calculating the percentage
	   
	   return percentage; //return pass percent
	   
	}
	
	public static int twofailed (int english[], int history[], int mathematics[], int science[] )
    {
		int count[];
		count = new int[200];
		int c=0;
	  for(int i=0; i<=199; i++)
	  {
		 if(mathematics[i]< 60)
			 count[i]++;
		 if(english[i]< 60)
			 count[i]++;
		 if(history[i] < 60)
			 count[i]++;
		 if(science[i] < 60)
			 count[i]++;
	  
		 if(count[i] >2)
		 {
			 c++;
		 }
	  }
	  return c;
    }



   public static void interfacewithuser() //method to interact with the user 
	{
		while (true) //setting the condition to true so that the menu runs endlessly till the user wants to quit 
		
		{
			System.out.println("This is a program that takes real life data of 200 students "
					+ "\n" +  "and displays the data, adds their total score and calculates the percentage "
							+ "\n" + "prints details of top ten, finds number of students passed and failed" + "\n" +
					 "the pass percentage in each subject and number of students failed in more than 2 subjects    " + "\n" );
			System.out.println("----------------------------------------" + "\n");
			System.out.println("Choose from the menu below:");
			System.out.println();
			System.out.println("Enter 1 for getting the details of the students with total score and percentage"); //option to display all details 
			System.out.println("Enter 2 for the total score of all the students"); //option to print the total score of all students 
			System.out.println("Enter 3 for  percentage of all the students"); //option to print the percentage of all students 
			System.out.println("Enter 4 for the details of the top students in all the subjects"); //option to print details of top ten students 
			System.out.println("Enter 5 for the number of students who passed and failed in each subject"); //option to print the number of students passed and failed 
			System.out.println("Enter 6 for the pass percent in each subject");  //option to print pass percentage
			System.out.println("Enter 7 for the number of students who failed in more than 2 subjects"); //option to print the number of students who failed in more than 2 subjects 
			System.out.println("Enter 0 for exiting the program"); //option to exit the program
			Scanner sc = new Scanner(System.in);
			int value = sc.nextInt(); //storing the input from the user 
			
			if(value==1) 
			{
				display(); //invoking display method if user chooses 1 
			    System.out.println();

			} 
			else if (value == 2) 
			{
				
				int[] totalscore = totalscore(english, history, math, science);
				System.out.println("The total scores of all students are: ");
				for(int i =0; i<=199; i++)
				{ 
					System.out.println(totalscore[i]); //printing out the total scores if the user chooses option 2 
				}
			    System.out.println();


			} 
			else if (value == 3) 
			{
				
				double percent[] = percentagestudents(english, history, math, science); 
				System.out.println("The percentage of all the students are: ");
				for(int i =0; i<=199; i++) { 
					System.out.println(percent[i]); //printing out the percentage if the user chooses option 3 
				}
			    System.out.println();

			}
			else if (value ==4) 
			{
				int[] topTenForScience = topten(science); //calling the function to get  top ten students for science 
			    int[] topTenIndexesforscience = getIndexesOfTopTenStudents(topTenForScience, science); //calling function to get top ten index for science scores 
			    System.out.println("The top ten students in Science are:");
			    for(int i=0; i<=9 ;  i++)
			    { //printing the details of top ten students in science 
			    	System.out.println(firstname[topTenIndexesforscience[i]] + " " + lastname[topTenIndexesforscience[i]] + " with the ID " + id[topTenIndexesforscience[i]] );
			    }
			    int[] topTenForEnglish = topten(english); //calling the function to get top ten students for English
			    int[] topTenIndexesforenglish = getIndexesOfTopTenStudents(topTenForEnglish, english); //calling function to get top ten index for english scores 
			    System.out.println();
			    System.out.println("The top ten students in English are:");
			    for(int i=0; i<=9 ;  i++)
			    { //printing the details of top ten students in English
			    	System.out.println(firstname[topTenIndexesforenglish[i]] + " " + lastname[topTenIndexesforenglish[i]] + " with the ID " + id[topTenIndexesforenglish[i]] );
			    }
			    int[] topTenForMath = topten(math); //calling the function to get top ten students in math
			    int[] topTenIndexesformath = getIndexesOfTopTenStudents(topTenForMath, math); //calling function to get top ten index for math scores 
			    System.out.println();
			    System.out.println("The top ten students in Math are:");
			    for(int i=0; i<=9 ;  i++)
			    { //printing the details of top ten students in math
			    	System.out.println(firstname[topTenIndexesformath[i]] + " " + lastname[topTenIndexesformath[i]] + " with the ID " + id[topTenIndexesformath[i]] );
			    }
			    int[] topTenForHistory = topten(history); //calling the function to get top ten students in history
			    int[] topTenIndexesforhistory = getIndexesOfTopTenStudents(topTenForHistory, history); //calling function to get top ten index for history
			    System.out.println();
                System.out.println("The top ten students in History are:");
			    for(int i=0; i<=9 ;  i++)
			    {
			    	System.out.println(firstname[topTenIndexesforhistory[i]] + " " + lastname[topTenIndexesforhistory[i]] + " with the ID " + id[topTenIndexesforhistory[i]] );
			    }  
			    System.out.println();

			} 
			else if (value ==5)  //for the option 5 printing the number of students passed and failed 
			{
			 System.out.println("The number of students who passed in Mathematics are " + findwhopassed(math)); //calling the function and printing 
			 System.out.println("The number of students who passed in English are " + findwhopassed(english));
			 System.out.println("The number of students who passed in Science are " + findwhopassed(science));
			 System.out.println("The number of students who passed in History are " + findwhopassed(history));
			 System.out.println("The number of students who failed in Mathematics are " + findwhofailed(math));
			 System.out.println("The number of students who failed in English are " + findwhofailed(english));
			 System.out.println("The number of students who failed in Science are " + findwhofailed(science));
			 System.out.println("The number of students who failed in History are " + findwhofailed(history));
			    System.out.println();

			}  
			else if (value == 6) 
			{ //for option 6, printing the pass percentage in each subject 	 
			 System.out.println("The pass percentage of students in Mathematics is " + passpercent(math)); //calling the function and printing 
			 System.out.println("The pass percentage of students in English is " + passpercent(english));
			 System.out.println("The pass percentage of students in Science is " + passpercent(science));
			 System.out.println("The pass percentage of students in History is " + passpercent(history));
			    System.out.println();

			} 
			else if (value == 7) 
			{ //calling the function by passing arguments  and printing 
				System.out.println("The number of students who failed in more than 2 subjects are " + twofailed(english, history, math, science));
			    System.out.println();
			} 
			else if (value ==0)
			{ //exit from the loop if the user wants to quit the program
			 
				System.out.println("Okay boss, we are exiting then");
			    System.out.println();

			}
			
			else 
			{
			//for if the user inputs any number not mentioned in the menu
				System.out.println("Please choose something from the menu only"); //asking the user to choose only from the menu
			    System.out.println();
            }
			
		} //closing the while loop
		
		
	} //closing the interface method 
	
} //closing the class 


