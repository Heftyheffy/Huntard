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
    JPanel lPanel, rPanel, midPanel, mainPanel;
    JLabel gorilla;
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
	mainPanel = new JPanel();
	storyArea = new JTextArea();

	gorilla = new JLabel(new ImageIcon("gorillaL.png"));
	lPanel.add(gorilla);
	lPanel.setBackground(color1);
	gorilla = new JLabel(new ImageIcon("gorillaR.png"));
	rPanel.add(gorilla);
	rPanel.setBackground(color1);
	
	setSize(1200, 700);
	setResizable(false);	
	setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	storyArea.setEditable(false);
	storyArea.setFont(storyFont);
	storyArea.setForeground(Color.black);
	storyArea.setBackground(color1);
	storyArea.setText("After the death of Harmabe, the\nbeloved leader and spiritual messiah\nof all gorilla kind, the grief weighed\nheavy upon the hearts of all");
	midPanel.add(storyArea);
	
	mainPanel.add(lPanel, BorderLayout.WEST);
	mainPanel.add(midPanel, BorderLayout.CENTER);
	mainPanel.add(rPanel, BorderLayout.EAST);
	mainPanel.setBackground(color1);
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
				storyArea.setText("Violence erupted against their human\noppressors. Many arose to try to quell\nthe anger and lead the gorillas\nback to their peaceful ways, but\nthe intense grief led to a violence\nof even greater intensity and soon\nthere was nothing but rage and\ndestruction");
				fadeIn();
			    }
			else if(storyArea.getText().startsWith("Violence")){
			    storyArea.setText("But physical violence did not eas\nthe suffering of the gorillas. The\ndespair festered in their minds like\na tumor. It made them irrational and\nfervent in their mayhem. The tumor\ngrew and soon it began causing\nphysical deformations.");
			    fadeIn();
			}
			else if(storyArea.getText().startsWith("But p")){
			    storyArea.setText("The world was in ruins. The gorillas'\nfury spared nothing. Beloved monuments\nwerereduced to rubble. People waited\nin fear for their turn to be savagely\nkilled by the gorillas.");
			    fadeIn();
			}
			else if(storyArea.getText().startsWith("The")){
			    storyArea.setText("Humans lacked the ability to combat\nthe frightful gorillas and made\nall attempts to save themselves\nfrom a piteous fate. By casting\nout all those named \"Richard\" to\nappease the spirit of Harambe\nmany hoped to be spared.");
			    fadeIn();
			}
			else if(storyArea.getText().startsWith("Humans")){
			    storyArea.setText("But the gorillas were past all\ncomprehension. Their malignant tumor\nrobbed them of their cognitive\nprocesses. They existed only to\ndestroy. They had become gorilla\nzombies. Gorilla nazi zombies.");
			    fadeIn();
			}
			else{
			    continueStory();
			}
		    }
		    else{			
			storyArea.setForeground(new Color(0, 0, 0, (alpha-=1)));			
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
			storyArea.setForeground(new Color(0, 0, 0, (alpha+=1)));			
			storyArea.updateUI();
		    }
		}
	    });
	timerFadeIn.start();        
    }
    public void continueStory(){        			
		
    }
}
