import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
    public class D2 {
    	public static String correctletters = "";
    	public static String chosenword = "";
    	public static String list = "";
    	public static String split = "";
    public static void main(String[] args) { 
	    // hier maken we een arraylist voor de fout geraadde letters zodat we die makkelijk kunnen selecteren en opslaan
		ArrayList<String> wrongletters = new ArrayList<String>();
		String[] words = {"nanny", "headphones", "background", "computer", "submarine", "coincide",
				"cinema", "deep", "coffee", "ample", "coma", "trust", "vulcano",				
				"leak", "slippery", "dimension", "pavement", "mark", "slab", "layout",
				 "pneumonoultramicroscopicsilicovolcanoconiosis", "stall", "nun",
				 "veteran", "lamp", "mosaic", "opera", "obese", "drink", "suggest"};
		int wrong = 0;
	    // het woord word hier gekozen uit de arraylist met math.random
		int n = (int) (Math.random() * 29);
		chosenword = words[n];
		for (int y=0; y<chosenword.length(); y++) {
			correctletters = correctletters + "_ ";
		}
	    // hier splitten we het woord in een array van losse letters
		for (int i = 0;i < chosenword.length(); i++){
		    split = split + chosenword.charAt(i)+" ";
		}
	    //dit is de frame waarhet spel word afgespeelt
	JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame=new JFrame();

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    JPanel buttonpanel = new JPanel();
	//hier kunne we letters of het woord raden
    JTextField top_text = new JTextField(20);
    JButton buton=new JButton("check");
    buton.setSize(250, 20);
    JButton nieuw = new JButton("new game");
    nieuw.setSize(250, 20);
    JTextField wg = new JTextField(String.valueOf(wrong),20);
    JTextField wl = new JTextField(list, 20);
    JTextField output = new JTextField(correctletters);
    wg.setText(10-wrong + " wrong guesses left");
	wl.setText("wrong guesses "+wrongletters);
	
    nieuw.addActionListener(new ActionListener() {
	    // hier word de knop new game gemaakt daarmee kun je ten alle tijden de game resetten
    	public void actionPerformed(ActionEvent e) {	    
    	frame.dispose();
		D2.correctletters = "";
		wrongletters.removeAll(wrongletters);  
		top_text.setText("");
		D2.main(null);
    	}
    });
    buton.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
    		guess(nieuw, output, wl, wg, chosenword, correctletters, wrong, wrongletters, top_text);
    	}
    });
    top_text.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
             if(e.getKeyCode() == KeyEvent.VK_ENTER && wg.getText() != "correct guess"){           	
            	guess(nieuw, output, wl, wg, chosenword, correctletters, wrong, wrongletters, top_text);
            }
        }
    });
    buttonpanel.add(nieuw);
    buttonpanel.add(buton);
    
    panel.add(top_text);
    panel.add(buttonpanel);
    panel.add(wg);
    panel.add(wl);
    panel.add(output);
    
    frame.add(panel, BorderLayout.CENTER);
    frame.pack();
    frame.setTitle("Shoup 2 electric boogaloo");          
 	frame.setSize(420,420);
 	frame.setResizable(true);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
	    //hier controllerd hij de letter die je invoert bij het textfield of hij goed of fout is
    static void guess(JButton nieuw, JTextField output, JTextField wl, JTextField wg, String chosenword, String correctletters, int wrong, ArrayList<String> wrongletters, JTextField top_text) {
    	list = String.join(", ", wrongletters);
		String input = top_text.getText();        		
		function(nieuw, output, wl, wg ,input, chosenword, correctletters, wrong, wrongletters);
		top_text.setText("");
    }
		
    static void function(JButton nieuw, JTextField output, JTextField wl, JTextField wg, String input, String chosenword, String correctletters, int wrong, ArrayList<String> wrongletters) {
    	wrong = wrongletters.size();
    	//als de input overeenkomt met het gekozen woord of letter dan komt hij hieer te staan op de stippellijntjes
    	if (input.equals(chosenword) || !correctletters.contains("_")) {
    		wg.setText("correct guess");
			wl.setText("");
			output.setText(input);
			nieuw.setEnabled(true);
    	}
		//als het fout is kom hij in een aparte box te staan en gaat het aantal keer raden naar beneden
	    else if(wrong <= 10){
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
    				output.setText(correctletters);
    				if (correctletters.contains("_")) {   					
    					wg.setText(10-wrong + " wrong guesses left");
    					wl.setText("wrong guesses "+wrongletters);
    					output.setText(correctletters);
    				}
    				else {
    					wg.setText("correct guess");
    					wl.setText("");
    					output.setText(correctletters);
    				}
    			}
    			else {
    				wrongletters.add(input);    							
    				wg.setText(10-wrong + " wrong guesses left");
    				wl.setText("wrong guesses "+wrongletters);
    				output.setText(correctletters);
    			}
    		}
    		else {
    			wrongletters.add(input);    					
    			wg.setText(10-wrong + " wrong guesses left");
    			wl.setText("wrong guesses "+wrongletters);
    			output.setText(correctletters);
    		}
    	}
    	else{
    		wg.setText("you've lost");
    		wl.setText("the word was "+chosenword);
    		nieuw.setEnabled(true);
    	}
    	D2.correctletters = correctletters;
    }
    }
