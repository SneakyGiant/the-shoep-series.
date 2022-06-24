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
	GridBagLayout layout = new GridBagLayout();
	JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame=new JFrame();

    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    
    JTextField top_text = new JTextField(20);
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.fill = GridBagConstraints.VERTICAL;
    layout.setConstraints(top_text, gbc);
    
    JButton buton=new JButton("check");
    buton.setSize(250, 20);
    gbc.gridx = 0;
    gbc.gridy = 1;
    layout.setConstraints(buton, gbc);
    
    JButton nieuw = new JButton("new game");
    nieuw.setSize(250, 20);
    gbc.gridx = 1;
    gbc.gridy = 1;  
    layout.setConstraints(nieuw, gbc);
    
    JTextField wg = new JTextField(String.valueOf(wrong),20);
    gbc.gridx = 0;
    gbc.gridy = 2;
    layout.setConstraints(wg, gbc);
    
    JTextField wl = new JTextField(list, 20);
    gbc.gridx = 0;
    gbc.gridy = 3;
    layout.setConstraints(wl, gbc);
    
    JTextField output = new JTextField(correctletters);
    gbc.gridx = 0;
    gbc.gridy = 4; 
    layout.setConstraints(output, gbc);
    
    nieuw.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		D2.main(null);
    	}
    });
    buton.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
    		list = String.join(", ", wrongletters);
    		String input = top_text.getText(); 
    		
    		function(output, wl, wg ,input, chosenword, correctletters, wrong, wrongletters);
    		
    	}
    });
    panel.add(top_text);
    panel.add(nieuw);
    panel.add(buton);
    panel.add(wg);
    panel.add(wl);
    panel.add(output);
    frame.add(panel);
    frame.pack();
    frame.setTitle("Shoup 2 electric boogaloo");          
 	frame.setSize(420,420); 
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }  
    static void function(JTextField output, JTextField wl, JTextField wg, String input, String chosenword, String correctletters, int wrong, ArrayList<String> wrongletters) {
    	wrong = wrongletters.size();
    	if (input.equals(chosenword) || !correctletters.contains("_")) {
    		wg.setText("correct guess");
			wl.setText("");
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
