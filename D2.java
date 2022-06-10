import java.util.Scanner;
public class D2 {
	public static void main(String[] args) {
		String chosenword = "";
		String[] words = {"nanny", "headphones", "background", "computer", "submarine"};
		String correctletters = "";
		int n = (int) (Math.random() * 5);
		chosenword = words[n];
		for (int y=0; y<chosenword.length(); y++) {
			correctletters = correctletters + "_ ";
		}
		function(chosenword, correctletters);		
	}


static void function(String chosenword, String correctletters) {
	final Scanner inputread = new Scanner(System.in);
	String input = inputread.nextLine();
	
	
	if (input.equals(chosenword)) {
		System.out.println("correct guess");
		inputread.close();
	}
	else {
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
			function(chosenword, correctletters);
		}
		else {
			System.out.println(correctletters);
			function(chosenword, correctletters);
		}
	}	
}
}
