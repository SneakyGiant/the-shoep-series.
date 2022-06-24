import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
    public class D2 {  
    	public static String correctletters = "";
    	public static String chosenword = "";
    	public static String list = "";
    public static void main(String[] args) { 
		ArrayList<String> wrongletters = new ArrayList<String>();
		String[] words = {"nanny", "headphones", "background", "computer", "submarine", "coincide",
				"cinema", "deep", "coffee", "ample", "coma", "trust", "vulcano",				
				"leak", "slippery", "dimension", "pavement", "mark", "slab", "layout",
				 "pneumonoultramicroscopicsilicovolcanoconiosis", "stall", "nun",
				 "veteran", "lamp", "mosaic", "opera", "obese", "drink", "suggest"};
		int wrong = 0;
		int n = (int) (Math.random() * 29);
		chosenword = words[n];
		for (int y=0; y<chosenword.length(); y++) {
			correctletters = correctletters + "_ ";
		}
	JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame=new JFrame();

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    JTextField top_text = new JTextField(20);
    JButton buton=new JButton("check");
    buton.setSize(250, 20);
    JButton nieuw = new JButton("new game");
    nieuw.setSize(250, 20);
    nieuw.setEnabled(false);
    JTextField wg = new JTextField(String.valueOf(wrong),20);
    JTextField wl = new JTextField(list, 20);
    JTextField output = new JTextField(correctletters);
    wg.setText(10-wrong + " wrong guesses left");
	wl.setText("wrong guesses "+wrongletters);
    nieuw.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		frame.dispose();
    		correctletters = "";
    		wrongletters.removeAll(wrongletters);   		
    		D2.main(null);
    	}
    });
    buton.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
    		list = String.join(", ", wrongletters);
    		String input = top_text.getText(); 
    		
    		function(nieuw, output, wl, wg ,input, chosenword, correctletters, wrong, wrongletters);
    		
    	}
    });
    panel1.add(top_text);
    panel2.add(nieuw);
    panel2.add(buton);
    panel3.add(wg);
    panel4.add(wl);
    panel5.add(output);
    panel.add(panel1);
    panel.add(panel2);
    panel.add(panel3);
    panel.add(panel4);
    panel.add(panel5);
    frame.add(panel, BorderLayout.CENTER);
    frame.pack();
    frame.setTitle("Shoup 2 electric boogaloo");          
 	frame.setSize(420,420);
 	frame.setResizable(true);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }  
    static void function(JButton nieuw, JTextField output, JTextField wl, JTextField wg, String input, String chosenword, String correctletters, int wrong, ArrayList<String> wrongletters) {
    	wrong = wrongletters.size();
    	
    	if (input.equals(chosenword) || !correctletters.contains("_")) {
    		wg.setText("correct guess");
			wl.setText("");
			output.setText(input);
			nieuw.setEnabled(true);
    	}
    	else if(wrong == 9){
    		wg.setText("you've lost");
    		wl.setText("the word was "+chosenword);
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
    	D2.correctletters = correctletters;
    }
    }
