import java.util.Scanner;
public class test {

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
			
			
			int i = chosenword.indexOf(input);
			while(i <= chosenword.length()) {
				String a = correctletters.substring(0, 2*chosenword.indexOf(input));
				char b = input.charAt(0);
				String c = correctletters.substring(2*chosenword.indexOf(input)+1);
				correctletters = a + b + c;
			     i++;
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
