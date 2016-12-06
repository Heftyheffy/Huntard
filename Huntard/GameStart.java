import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.util.concurrent.*;

public class GameStart extends JFrame{
    ArrayList<Character> chars;
    JTextArea storyArea;
    Font storyFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    JPanel lPanel, rPanel, midPanel, topPanel;
    JLabel gorilla, mainPanel;
    Color color1, color2;
    javax.swing.Timer timerFadeIn, timerFadeOut;
    int alpha;
    
    public GameStart(ArrayList<Character> c){
	this.chars = c;
	color1 = new Color(220,0,0);
	color2 = new Color(130,0,0);
	
	lPanel = new JPanel();
	rPanel = new JPanel();
	midPanel = new JPanel();
	mainPanel = new JLabel(new ImageIcon("harambe.jpg"));
	topPanel = new JPanel();
	storyArea = new JTextArea();

	mainPanel.setLayout(new BorderLayout());
	topPanel.setPreferredSize(new Dimension(150, 150));
	topPanel.setOpaque(false);

	gorilla = new JLabel(new ImageIcon("gorillaL.png"));
	lPanel.add(gorilla);
	lPanel.setOpaque(false);
	gorilla = new JLabel(new ImageIcon("gorillaR.png"));
	rPanel.add(gorilla);
	rPanel.setOpaque(false);        
	
	setSize(1200, 700);	
	setResizable(false);	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	storyArea.setEditable(false);
	storyArea.setFont(storyFont);
	storyArea.setForeground(color1);
	storyArea.setBackground(color1);
	storyArea.setText("After the death of Harmabe, the beloved leader and spiritual messiah of all gorilla kind, the grief weighed heavy upon the hearts of all");
	storyArea.setPreferredSize(new Dimension(456, 400));
	storyArea.setLineWrap(true);
	storyArea.setWrapStyleWord(true);
	storyArea.setOpaque(false);
	storyArea.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
	midPanel.add(storyArea);	
	midPanel.setOpaque(false);
	
	mainPanel.add(lPanel, BorderLayout.WEST);
	mainPanel.add(midPanel, BorderLayout.CENTER);
	mainPanel.add(rPanel, BorderLayout.EAST);
	mainPanel.add(topPanel, BorderLayout.NORTH);	
	add(mainPanel);

	setLocationRelativeTo(null);	
	setVisible(true);
	fadeOut();
    }

    public void fadeOut(){
	alpha = 255;
	timerFadeOut = new javax.swing.Timer(20, new ActionListener(){
		public void actionPerformed(ActionEvent evt){
		    if(alpha == 0){
			timerFadeOut.stop();
			if(storyArea.getText().startsWith("After")){
				storyArea.setText("Violence erupted against their human oppressors. Many arose to try to quell the anger and lead the gorillas back to their peaceful ways, but the intense grief led to a violence of even greater intensity and soon there was nothing but rage and destruction");			        
				fadeIn();
			    }
			else if(storyArea.getText().startsWith("Violence")){
			    storyArea.setText("But physical violence did not ease the suffering of the gorillas. The despair festered in their minds like a tumor. It made them irrational and fervent in their mayhem. The tumor grew and soon it began causing physical deformations.");
			    fadeIn();
			}
			else if(storyArea.getText().startsWith("But p")){
			    storyArea.setText("The world was in ruins. The gorillas' fury spared nothing. Beloved monuments were reduced to rubble. People waited in fear for their turn to be savagely killed by the gorillas.");
			    fadeIn();
			}
			else if(storyArea.getText().startsWith("The")){
			    storyArea.setText("Many settlements hoped to be spared from a piteous fate by trying to appease the spirit of Harmabe through an ancient tradition that requires casting out all those named \"Dick\".");
			    fadeIn();
			}
			else if(storyArea.getText().startsWith("Many")){
			    storyArea.setText("But the gorillas were past all comprehension. Their malignant tumor robbed them of their cognitive processes. They existed only to destroy. They had become gorilla zombies. Gorilla nazi zombies.");
			    fadeIn();
			}
			else{
			    gs.dispose();
			    HuntardMainScreen.startHMS(chars);
			}
		    }
		    else{			
			storyArea.setForeground(new Color(220, 0, 0, (alpha-=1)));			
			storyArea.updateUI();
		    }
		}
	    });
	timerFadeOut.start();        
    }
    
    public void fadeIn(){
	alpha = 0;
	timerFadeIn = new javax.swing.Timer(20, new ActionListener(){
		public void actionPerformed(ActionEvent evt){
		    if(alpha == 255){
			timerFadeIn.stop();
			fadeOut();
		    }
		    else{			
			storyArea.setForeground(new Color(220, 0, 0, (alpha+=1)));			
			storyArea.updateUI();
		    }
		}
	    });
	timerFadeIn.start();        
    }    

    static GameStart gs;
    public static void start(ArrayList<Character> c){
	gs = new GameStart(c);
    }    
}
