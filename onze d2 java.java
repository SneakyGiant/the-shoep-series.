import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyClass {
	String correctLetters = "";
	String chosenWord = "";
	String input = "";
	String[] Words = {"skeleton","ghost","spooky"};
	int x = 0;
   public static void main(String args[]) {
	//hier ga ik het woord random kiezen en daarna splitsen in letters.
	//ik wil een limiet instellen van 8 keer raden
	//ik wil een visueel beeld van het raden
	//hoe maak ik een begin?
	int F = (int)(Math.random()*3);
	String List = Words[F];
	for(int i = 0; i != List.length(); i++ ){
	   String[] newList = List.split("");
	}
	for(i = 0; i < newList.length(); i++){
		if( input.equals(newList[i]) ){
		
		}
	}
   }
}
