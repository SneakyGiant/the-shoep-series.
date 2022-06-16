import java.util.Scanner;
import java.util.ArrayList;
public class D2 {

	public static void main(String[] args) {
		ArrayList<String> wrongletters = new ArrayList<String>();
		String chosenword = "";
		String[] words = {"nanny", "headphones", "background", "computer", "submarine", "coincide",
				"cinema", "deep", "coffee", "ample", "coma", "trust", "vulcano",				
				"leak", "slippery", "dimension", "pavement", "mark", "slab", "layout",
				 "pneumonoultramicroscopicsilicovolcanoconiosis", "stall", "nun",
				 "veteran", "lamp", "mosaic", "opera", "obese", "drink", "suggest"};
		String correctletters = "";
		int wrong = 0;
		int n = (int) (Math.random() * 29);
		chosenword = words[n];
		for (int y=0; y<chosenword.length(); y++) {
			correctletters = correctletters + "_ ";
		}
		function(chosenword, correctletters, wrong, wrongletters);
	}

static void function(String chosenword, String correctletters, int wrong, ArrayList<String> wrongletters) {
	final Scanner inputread = new Scanner(System.in);
	String input = inputread.nextLine();
	
	
	if (input.equals(chosenword) || !correctletters.contains("_")) {
		System.out.println("correct guess");
		System.out.println("");
		inputread.close();
	}
	else if(wrong == 9){
		System.out.println("you've lost");
		System.out.println("");
		System.out.println("the word was "+chosenword);
		inputread.close();
	}
	else {
		if(input.length()==1) {
			if(chosenword.contains(input)) {
				int i = chosenword.indexOf(input);
				while(i <= chosenword.length() && i != -1) {
					String a = correctletters.substring(0, 2*i);
					char b = input.charAt(0);
					String c = correctletters.substring(2*i+1);
					correctletters = a + b + c;
				     i = chosenword.indexOf(input, i+1);
				}
				System.out.println(correctletters);
				if (correctletters.contains("_")) {
					System.out.println(10-wrong + " wrong guesses left");
					System.out.println("wrong guesses "+wrongletters);
					System.out.println("");
					function(chosenword, correctletters, wrong, wrongletters);
				}
				else {
					System.out.println("correct guess");
					System.out.println("");
					inputread.close();
				}
			}
			else {
				wrong++;
				wrongletters.add(input);
				System.out.println(correctletters);
				System.out.println(10-wrong + " wrong guesses left");
				System.out.println("wrong guesses "+wrongletters);
				System.out.println("");
				function(chosenword, correctletters, wrong, wrongletters);
			}
		}
		else {
			wrong++;
			wrongletters.add(input);
			System.out.println(correctletters);			
			System.out.println(10-wrong + " wrong guesses left");
			System.out.println("wrong guesses "+wrongletters);
			System.out.println("");
			function(chosenword, correctletters, wrong, wrongletters);
		}
	}	
}
}
