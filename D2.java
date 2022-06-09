
 import java.util.Scanner;
public class D2 {

	public static void main(String[] args) {
		String chosenword = "";
		String[] words = {"nanny", "headphones"};
		String correctletters = "";
		int n = (int) (Math.random() * 2);
		chosenword = words[n];
		for (int y=0; y<chosenword.length(); y++) {
			correctletters = correctletters + "_ ";
		}
		function(chosenword, correctletters);
		
	}


static void function(String chosenword, String correctletters) {
	final Scanner inputread = new Scanner(System.in);
	String input = inputread.nextLine();
	
	
	if (chosenword == input) {
		System.out.println("correct guess");
		inputread.close();
	}
	else {
		if(chosenword.contains(input)) {
			for (int x=0; x<chosenword.length(); x++) {
				correctletters.replace(correctletters.charAt(2*chosenword.indexOf(input)+1), input.charAt(0));
			}
			System.out.println(correctletters);
			function(chosenword, correctletters);
		}
		else {
			System.out.println(correctletters);
			function(chosenword, correctletters);
		}
	}
	
	}
}
