import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.FlowLayout;
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
    panel.setLayout(new FlowLayout());
    JTextField top_text = new JTextField("a", 20);         
    JButton buton=new JButton("click");
    buton.setBounds(130,100,100, 40);
    
    JTextField wg = new JTextField(String.valueOf(wrong),20);
    JTextField wl = new JTextField(list, 20);
    JTextField output = new JTextField(correctletters,20);
    
    buton.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
    		list = String.join(", ", wrongletters);
    		String input = top_text.getText();   		
    		function(output, wl, wg ,input, chosenword, correctletters, wrong, wrongletters);
    	}
    });
    panel.add(top_text);
    panel.add(buton);
    panel.add(wg);
    panel.add(wl);
    panel.add(output);
    frame.add(panel);
    frame.pack();
    frame.setTitle("Shoup 2 electric boogaloo");          
 	frame.setSize(420,420); 
 	frame.setResizable(false);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }  
    static void function(JTextField output, JTextField wl, JTextField wg, String input, String chosenword, String correctletters, int wrong, ArrayList<String> wrongletters) {
    	
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

    				}
    				else {
    					wg.setText("correct guess");
    					wl.setText("");
    				}
    			}
    			else {
    				wrong++;
    				wrongletters.add(input);
    				output.setText(correctletters);
    				wg.setText(10-wrong + " wrong guesses left");
    				wl.setText("wrong guesses "+wrongletters);

    			}
    		}
    		else {
    			wrong++;
    			wrongletters.add(input);
    			output.setText(correctletters);		
    			wg.setText(10-wrong + " wrong guesses left");
    			wl.setText("wrong guesses "+wrongletters);
    		}
    		System.out.println(wrong);
    	}
    }
   
