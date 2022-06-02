public class MyClass {
	public static void main(String args[]) {
		String correctletters = "";
		String chosenword = "";
		String input = "";
		String[] words = {"nanny", "headphones"}; //hier moeten stings komen
		int anders_werkt_deze_bullshit_niet = 0;
		

		if (anders_werkt_deze_bullshit_niet == 0) {
	        int n = (int)(Math.random() * 2);        
	        chosenword = words[n];
	        for(int x = 0; x<chosenword.length(); x++){
	            correctletters = correctletters + "_";
	        }
		}
		
		if (chosenword.contains(args[0])) {
			 for(int y = 0; y<args[0].length(); y++){
		        	if (args[0].charAt(y) == chosenword.charAt(y)) {
					for (int m = 0; m<chosenword.length(); m++){
						String a = correctletters.substring(0, chosenword.indexOf(chosenword.charAt(y)));
						char b = chosenword.charAt(y);
						String c = correctletters.substring(chosenword.indexOf(chosenword.charAt(y)) + 1);
						correctletters = a + b + c;
					}
		        	}
		        }
		}
		
       
        if (args[0] == chosenword){
            System.out.println("Correct guess");
        }
        else{
		for (int i = 0; i<correctletters.length(); i++){
			input = input + correctletters.charAt(i) + " ";
		}
		System.out.println(input);
        }
    }
}
