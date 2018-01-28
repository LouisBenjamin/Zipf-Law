/*PURPOSE:
 * The word class contains two important variable the string of the world itself
 * and the frequency found within the text. This method contains the buildHistogram method
 * which creates the whole histogram*/


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Word implements Comparable<Word>{
	
	public String word;
	private int freq;
	
	
	public Word() {
		word = null;
		freq = 0;
	}
	public Word(String w, int f ) {
		word = w;
		freq = f;
	}
	public Word(Word w) {
		this.word = w.word;
		this.freq = w.freq;
	}
	
	
	public String getWord() {
		return this.word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}

	
	public void incrementFrequency(){
	    this.freq++;
	}
	
	@Override
	public String toString() {
	    return ("(Word: "+this.getWord()+", Frequency: " + this.getFreq()+")");
	}

//builds the whole histogram
	public static List<Word> buildHistogram(File file){
		
		List<Word> arrayList = new ArrayList<Word>();


		try {
		    Scanner sc = new Scanner(new FileReader(file));
	
		    do {
			    //If the next word is a word with letter from the alphabet
		    	if (sc.hasNext("[A-Za-z]+")) {
		    		String nextWord = sc.next();
		    	
		    		addWord(nextWord,arrayList);
		    	}
		    	else
		    		sc.next();		    
			
		    } while (sc.hasNext());
		    sc.close();
		}
		catch (FileNotFoundException e) {
		
			
		}
		
		Collections.sort(arrayList);
		displayWords(arrayList);
		   
		

		
		return arrayList;
	}
	
	//adds words to the arraylist and checks if there is any duplicate before
	
	public static void addWord(String w, List<Word> aL) {
	
		
		if (aL.size() == 0)
			aL.add(new Word(w,1));
		else {
			boolean dupExists = false;
			for (int i = 0; i < aL.size(); i++) {
				if (w.equals(aL.get(i).word)) {
					aL.get(i).incrementFrequency();
					dupExists = true;
					break;
				}
			}
			if (!(dupExists))
				aL.add(new Word(w,1));
		}

		
	}
	/*The list of rank/word/frequency must be displayed in descending order of frequency, 
	 * and all words with the same frequency
	 *  must be displayed in alphabetical order (uppercases before lowercases).
	 *  This overrided method basically allows me to sort them in that way.*/
	@Override
    public int compareTo(Word otherWord) {
        int compare = (otherWord.getFreq())-this.freq;
        if (compare == 0) {
        	compare = this.word.compareTo(otherWord.getWord());	
        }
        return compare;
    }

//displays the histogram with stats
	public static void displayWords(List<Word> aL) {
		
		double tokenCounter = 0;
		double wordTypeNumber  = aL.size();
		double happaxCounter = 0;
		double stopWordCounter = 0;
		
		System.out.println("================================");
		System.out.printf("%-10s %-15s %-15s\n", "RANK", "FREQ", "WORD");
		System.out.println("================================");
		for (int i = 0; i < aL.size(); i++) {
			if (aL.get(i).getWord().length() <= 4 && aL.get(i).getFreq() >= 10)
				stopWordCounter++; //It is assumed that a stop word is a word that has a length of 4 characters or less and that appears at least 10 times in the text.
			if (aL.get(i).getFreq() == 1)
				happaxCounter++;
			tokenCounter += aL.get(i).freq; 
			System.out.printf("%-10s %-15s %-15s\n", (i+1),aL.get(i).getFreq(),aL.get(i).getWord());
		}	
		System.out.println("================================");
	
		System.out.println("Nb of word tokens: "+(int)tokenCounter);
		System.out.println("Nb of word types: "+(int)wordTypeNumber);
		System.out.println("\nNb of Happax: "+(int)happaxCounter);
		
		System.out.print("%");
		System.out.printf(" of Happax:  %.1f%%%n", ((happaxCounter/wordTypeNumber)*100));
		System.out.printf("Happax account for:  %.1f%%%n", ((happaxCounter/tokenCounter)*100));

		System.out.println("\nNb of stop words: "+(int)stopWordCounter);
		System.out.print("%");
		System.out.printf(" of stop words:  %.1f%%%n", ((stopWordCounter/wordTypeNumber)*100));
		System.out.printf("Stop wordsc account for:  %.1f%%%n", ((stopWordCounter/tokenCounter)*100));
	}
	







}


	











