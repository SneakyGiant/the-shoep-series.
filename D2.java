public class D2 {
    public static void main(String[] args) {

        int n = (int)(Math.random() * 10);
        String[] words = {"nanny"}; //hier moeten stings komen
        String chosenword = words[0];
        String correctletters = "";
        for(int x = 0; x<chosenword.length(); x++){
            correctletters = correctletters + "_ ";
        }
        for(int y = 0; y<args[0].length(); y++){
        	if (args[0].charAt(y) == chosenword.charAt(y)){
                correctletters.replace(correctletters.charAt(y), args[0].charAt(y));
            }
        }
        if (args[0] == chosenword){
            System.out.println("Correct guess");
        }
        else{
            System.out.println(correctletters);
        }
    }
}
