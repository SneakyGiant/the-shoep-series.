import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyClass {
	String correctLetters = "";
	String chosenWord = "";
	String input = "";
	String[] Crap = {"crap","shit","fuck"};
	int fuckMe = 0;
   public static void main(String args[]) {
	//hier ga ik het woord random kiezen en daarna splitsen in letters.
	//ik wil een limiet instellen van 8 keer raden
	//ik wil een visueel beeld van het raden
	//hoe maak ik een begin?
	int F = (int)(Math.random()*3);
	String Fuck = Crap[F];
	for(int i = 0; i != Fuck.length(); i++ ){
	   String[] newFuck = Fuck.split("");
	}
	for(i = 0; i < newFuck.length(); i++){
		if( input.equals(newFuck[i]) ){
		
		}
	}
   }
}
