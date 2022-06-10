import java.util.Scanner;
public class D2 {
	public static void main(String[] args) {
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
		function(chosenword, correctletters, wrong);		
	}

static void function(String chosenword, String correctletters, int wrong) {
	final Scanner inputread = new Scanner(System.in);
	String input = inputread.nextLine();
	
	
	if (input.equals(chosenword) || !correctletters.contains("_")) {
		System.out.println("correct guess");
		inputread.close();
	}
	else if(wrong == 9){
		System.out.println("you've lost");
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
					function(chosenword, correctletters, wrong);
				}
				else {
					System.out.println("correct guess");
					inputread.close();
				}
			}
			else {
				wrong++;
				System.out.println(correctletters);
				System.out.println(10-wrong + " wrong guesses left");
				function(chosenword, correctletters, wrong);
			}
		}
		else {
			wrong++;
			System.out.println(correctletters);
			System.out.println(10-wrong + " wrong guesses left");
			function(chosenword, correctletters, wrong);
		}
	}	
}
}
