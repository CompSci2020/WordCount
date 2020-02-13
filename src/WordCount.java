/*
 * WordCount.java
 * Chapter 12 Exercise 1
 * Lawrenceville Press
 * June 24, 2005
 */
 
 import java.io.*;
 
 /**
  * A program that displays the number of words and the average word length
  * in the source.txt text file.
  */
 public class WordCount {

	public static void main(String[] args) {
		File textFile = new File("source.txt");
		FileReader in;
		BufferedReader readFile;
		char charInFile;
		int wordCount = 0;
		int numChars = 0;
		
		try {
			in = new FileReader(textFile);
			readFile = new BufferedReader(in);
    		do {
    			charInFile = (char)readFile.read();
				if ((charInFile >='a' && charInFile <='z') || (charInFile >='A' && charInFile <='Z')) {
					wordCount++;
					while ((charInFile >='a' && charInFile <='z') || (charInFile >='A' && charInFile <='Z')) {
						numChars++;
						charInFile = (char)readFile.read();
					}
				}
			} while (charInFile != (char)-1);
			System.out.println("Number of words: " + wordCount);
			System.out.println("Average word length: " + numChars/wordCount);
    		readFile.close();
    		in.close();
    	} catch (FileNotFoundException e) {
			System.out.println("File does not exist or could not be found.");
			System.err.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Problem reading file.");
    		System.err.println("IOException: " + e.getMessage());
    	}
	}
 }