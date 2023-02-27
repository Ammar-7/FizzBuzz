import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;

public class Wordle {

	// TODO: implement this method!
	private static String[] getWords(int minFreq){

		String words = readAllLinesFromDict();

		// TODO
		//  - read line-by-line
		//  - skip if ...
		//    - word is not a noun (NoC)
		//    - word contains a non-alpha character
		//    - frequency is below minFreq
		//    - last letter is 's'
		//    - if length != 5
		//  - convert to upper case
		//  - append to StringBuilder (with separator)
		//  - split result to array

		return new String[] {"PAPER", "METAL", "DELAY"};


	}

	public static void main(String[] args) {
		// Call words from Text file
		String words = readAllLinesFromDict();
		String[] str;

		// StringBuilder def.
		StringBuilder sb = new StringBuilder();



		// Spilt Words File to lines with split(/n) Methode 
		String [] lines = words.split("\n");
		System.out.println(lines.length);

		//  - read line-by-line using for loop
		//  - skip if ...

		for (String zeile: lines) {
			//System.out.println(zeile.length());
			String []word = zeile.split("\t");
			if (word[1] == "NoC") 
				continue;	
			for (int i = 0;i<word[0].length();i++) {
				if (!(Character.isLetter(word[0].charAt(i)))) {
					continue;					
		         }
			}

			if (word[0].endsWith("s")) 
				continue;
			if (word[0].length() !=5) 
				continue;
			
			if (600 >Integer.parseInt(word [2])) 
				continue;			
			System.out.println(word[0]);

			
		}

		
	}


	private static String readAllLinesFromDict(){
		try {
			return Files.readString(Path.of("C:\\Users\\ammar\\Desktop\\words.txt"));
		} catch (IOException e){
			e.printStackTrace();
			throw new UncheckedIOException(e);
		}

	}


	private static void playWordle(String[] words){
		Scanner scanner = new Scanner(System.in);
		boolean finished = false;
		int tries = 0;

		String secret = words[(new Random()).nextInt(words.length)];
		java.util.Set<String> set = java.util.Set.of(words);

		System.out.printf("Number of words in dictionary: %d%n", words.length);
		System.out.println("Guess the secret word! You have 6 guesses!");

		while (!finished){

			String input = scanner.nextLine();

			if (input.length() != 5){
				System.out.println("Please enter exactly 5 characters");
				continue;
			}

			if (!set.contains(input.toUpperCase())){
				System.out.println("Word is not in dictionary!");
				continue;
			}


			int matches = 0;


			for (int i = 0; i < 5; i++){

				char inputChar = Character.toUpperCase(input.charAt(i));

				if (inputChar == secret.charAt(i)){
					System.out.print(inputChar);
					matches++;
				} else if (secret.indexOf(inputChar) != -1){
					System.out.print("?");
				} else {
					System.out.print("!");
				}
			}

			System.out.println();

			if (matches == 5){
				System.out.println("You guessed right!");
				finished = true;
			}

			tries++;

			if (tries == 6){
				System.out.println("No tries left!");
				System.out.printf("The word was: %s", secret);
				finished = true;
			}

		}

	}


}
