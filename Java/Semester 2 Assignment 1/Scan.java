package assignment1;
import java.util.Scanner; //need to import the scanner class to use a scanner

public class Scan {
	
	static char alphabet[] = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	static char letters;
	static char testType;
	static long startTime;
	static long endTime;
	static long totalTime;
	static double finalTime;
	//I used static variables as I only needed to use them in this class
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in); //creates scanner
		
		System.out.println("Speed test for the letters of the alphabet. Would you like to go backwards or forwards? (b/f?)");
		testType = scan.next().charAt(0);
		//picks up on the first character that the user types. I decided to allow the user to type
		//more, incorrect letters after the first one and still be correct so this only takes the
		//character at index zero of input
		
		while(testType !='f' && testType!='b') {
			System.out.println("Invalid entry. Enter f or b to begin.");
			testType=scan.next().charAt(0);
			//this while loop runs until the user inputs an f or a b, ie chooses forwards or backwards
		}
		
		if(testType=='f') {
			System.out.println("Forwards it is! You may begin.");
			
			for(int i=0; i<26; i++) {
				System.out.printf("Type the letter %c:\n", alphabet[i]);
				letters=scan.next().charAt(0);
				if(i==1) {
					startTime = System.nanoTime();
					//startTime saves the time at which the user inputs the first letter, a 
				}
				
				
				while(letters!=alphabet[i]) {
					letters=scan.next().charAt(0);
				}
				
				if(letters==alphabet[i]) {
					System.out.printf("Correct!\n");
				}
				}
			//the while and if loops here check the users input to see if they are getting
			//the letters correct.If the input is incorrect it is ignored until a correct
			//answer is inputted
			
			endTime = System.nanoTime(); //the time at the end of the test
			totalTime = endTime - startTime; //the time taken to complete the test in nanoseconds
			finalTime = (double) totalTime/1000000000; //the time taken converted to seconds in double form
			System.out.println("Congratulations! You completed the speed test in " +finalTime+ " seconds.");
			}
		
		else if(testType=='b') {
			//same format as the code for forwards
			System.out.println("Backwards it is! You may begin.");
			
			for(int i=alphabet.length-1; i>=0; i--) {
			//iterates backwards through array alphabet
			System.out.printf("Type the letter %c:\n", alphabet[i]);
			letters=scan.next().charAt(0);
			
			if(i==alphabet.length-1) {
				startTime = System.nanoTime();
				//startTime saves the time at which the user inputs the first letter, a 
			}
				
				while(letters!=alphabet[i]) {
					letters=scan.next().charAt(0);
				}
				
				if(letters==alphabet[i]) {
					System.out.printf("Correct!\n");
				}
				}
		
			
			endTime = System.nanoTime();
			totalTime = endTime - startTime;
			finalTime = (double) totalTime/1000000000;
			System.out.println("Congratulations! You completed the speed test in " +finalTime+ " seconds.");
			}
			
				
		scan.close();
		//scanner is closed to avoid memory leak
	}
	}