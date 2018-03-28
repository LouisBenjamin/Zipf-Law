/* PURPOSE:
 * A program to verify Zipf’s law with a text. Specifically, the program asks the user for an input text file and counts how many words the file contains 
  and displays the following statistics: 
  - Display each word in the text along with its rank and frequency.
- Display the total number of word tokens and word types. The number of word tokens refers to the total number of words in the 
	text (the number of times the method Scanner.next() returned a String); whereas the number of word types refers to the number of different words in the text. For example, if the word “the” appears 30 times, it will count as 30 word tokens, but only 1 word type.
- Display statistics on the happax legomena: the number of happax, the percentage of happax (nb happax ÷ nb of word types), and 
 	how many of the tokens in the text they account for (nb happax ÷ nb of word tokens).
- Display statistics on the stops words:  the number of stop words,  the percentage of stop words (nb stop words ÷ nb of word types), 
	and  how many of the tokens in the text they account for (total frequency of stop stops ÷ nb of word tokens).*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zipf extends Word{

	public static void main(String[] args) {
		
		System.out.print("Welcome to part I of my program! Let's begin.\n\n");

		
		Scanner sc0 = new Scanner(System.in);
		File testFile = null;
		System.out.print("Enter input file: ");
		String fileName = sc0.nextLine();	
		
		do {
			try {
				testFile = new File(fileName);
				if (!(testFile.exists()))
					throw new FileNotFoundException();    
			} 
			catch (FileNotFoundException e) {
				System.out.print("File does not exist. Please enter another file name: ");
				fileName = sc0.nextLine();
				testFile = new File(fileName);						
			}
		} while (!(testFile.exists()));	
	
		buildHistogram(testFile);
		sc0.close();
		System.out.print("\n\nThis is the end of my program! Goodbye!");

	
	}

}
