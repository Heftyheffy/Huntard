import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
/*
This will be the main class for huntard
 */
public class Huntard extends JFrame{
    JLabel title, gorilla;
    JButton start, load, options, exit;
    JPanel midPanel, lPanel, rPanel, titlePanel, mainPanel;
    ImageIcon image;    

    public Huntard(){	
	//initialize panels
	lPanel = new JPanel();
	rPanel = new JPanel();
	midPanel = new JPanel();
	titlePanel = new JPanel();
	mainPanel = new JPanel(new BorderLayout());

	//configures titlePanel/title	
	title = new JLabel("Huntard: The Revenge of Harambe");
	title.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
	title.setForeground(Color.black);	        
	titlePanel.add(title);	        
	
	titlePanel.setBackground(new Color(220,0,0));        

	//Configures look of the left gorilla button/panel
	image = new ImageIcon("gorillaL.png");
	gorilla = new JLabel(image);        
	gorilla.setBackground(new Color(220,0,0));
        lPanel.setBackground(new Color(220,0,0));	
	lPanel.add(gorilla);

	//Configures look of the right gorilla button/panel
	image = new ImageIcon("gorillaR.png");
	gorilla = new JLabel(image);        
	gorilla.setBackground(new Color(220,0,0));
        rPanel.setBackground(new Color(220,0,0));        
	rPanel.add(gorilla);

	//configures buttons
	start = new JButton("New Game");
	start.setPreferredSize(new Dimension(400, 100));
	start.setBackground(Color.black);
	start.setForeground(Color.white);
	start.setRolloverEnabled(false);
	start.addActionListener(new ButtonListener());
	
	load = new JButton("Load Game");
	load.setPreferredSize(new Dimension(400, 100));
	load.setBackground(Color.black);
	load.setForeground(Color.white);
	load.setRolloverEnabled(false);
	load.addActionListener(new ButtonListener());
	
	options = new JButton("Settings");
	options.setPreferredSize(new Dimension(400, 100));
	options.setBackground(Color.black);
	options.setForeground(Color.white);
	options.setRolloverEnabled(false);
	options.addActionListener(new ButtonListener());
	
	exit = new JButton("Exit Game");	
	exit.setPreferredSize(new Dimension(400, 100));
	exit.setBackground(Color.black);
	exit.setForeground(Color.white);
	exit.setRolloverEnabled(false);
	exit.addActionListener(new ButtonListener());

	//add buttons to midpanel
	midPanel.add(start);
	midPanel.add(load);
	midPanel.add(options);
	midPanel.add(exit);
	midPanel.setBackground(new Color(220,0,0));

	//add Panels
	mainPanel.add(titlePanel, BorderLayout.NORTH);
	mainPanel.add(lPanel, BorderLayout.WEST);
	mainPanel.add(rPanel, BorderLayout.EAST);
	mainPanel.add(midPanel, BorderLayout.CENTER);

	//setup frame
	add(mainPanel);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	setUndecorated(true);		
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);
    }

    class ButtonListener implements ActionListener{
	public void actionPerformed(ActionEvent evt){
	    String cmd = evt.getActionCommand(); //gets text of button
	    if(cmd == "New Game"){
	        mainPanel.removeAll();
		midPanel.removeAll();
		titlePanel.removeAll();
		titlePanel.setLayout(new GridLayout(1,4));
	        midPanel.setLayout(new GridLayout(1,4));
		getSelectScreen();
		mainPanel.updateUI();
	    }
	    else if(cmd == "Exit Game"){
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	    }
	}
    }

    //Character Buttons
    private JButton larry, steve, joanne, joe;
    //Character objects
    Character charSteve, charLarry, charJoanne, charJoe;
    //text area with character info
    JTextArea sArea, lArea, jnArea, jArea;

    //Sets up character selection screen
    public void getSelectScreen(){
	
	//assigns buttons appropriate pictures and color scheme
	steve = new JButton(new ImageIcon("steve.png"));
	steve.addActionListener(new CharacterListener());
	larry = new JButton(new ImageIcon("larry.png"));
	larry.addActionListener(new CharacterListener());
	joanne = new JButton(new ImageIcon("joanne.png"));
	joanne.addActionListener(new CharacterListener());
	joe = new JButton(new ImageIcon("joe.png"));
	joe.addActionListener(new CharacterListener());
	steve.setBackground(new Color(220,0,0));
	larry.setBackground(new Color(130,0,0));
	joanne.setBackground(new Color(130,0,0));
	joe.setBackground(new Color(220,0,0));

	//creates character objects (name, strength, stealth, intellignce, psychology)
	charSteve = new Character("Steve", 3, 1, 0, 2);
	charLarry = new Character("Larry", 1, 2, 3, 0);
	charJoanne = new Character("Joanne", 2, 0, 1, 3);
	charJoe = new Character("Joe", 0, 3, 2, 1);

	//puts character info in text box and puts it in titlePanel
	sArea = new JTextArea();
	lArea = new JTextArea();
	jnArea = new JTextArea();
	jArea = new JTextArea();
	sArea.setPreferredSize(new Dimension(150, 150));
	lArea.setPreferredSize(new Dimension(150, 150));
	jnArea.setPreferredSize(new Dimension(150, 150));
	jArea.setPreferredSize(new Dimension(150, 150));

	//text area font and color scheme
	sArea.setFont(new Font(Font.SERIF, Font.BOLD, 20));
	lArea.setFont(new Font(Font.SERIF, Font.BOLD, 20));
	jnArea.setFont(new Font(Font.SERIF, Font.BOLD, 20));
	jArea.setFont(new Font(Font.SERIF, Font.BOLD, 20));
	sArea.setBackground(Color.lightGray);
	lArea.setBackground(Color.lightGray);
	jnArea.setBackground(Color.lightGray);
	jArea.setBackground(Color.lightGray);
	sArea.setForeground(Color.black);
	lArea.setForeground(Color.black);
	jnArea.setForeground(Color.black);
	jArea.setForeground(Color.black);
	
	sArea.setText(charSteve.toString());        
	lArea.setText(charLarry.toString());	
	jnArea.setText(charJoanne.toString());	
	jArea.setText(charJoe.toString());
	titlePanel.add(sArea);
	titlePanel.add(lArea);
	titlePanel.add(jnArea);
	titlePanel.add(jArea);
	

	//adds buttons to panel
	midPanel.add(steve);
	midPanel.add(larry);
	midPanel.add(joanne);
	midPanel.add(joe);
	mainPanel.add(midPanel, BorderLayout.CENTER);
	mainPanel.add(titlePanel, BorderLayout.SOUTH);
    }

    class CharacterListener implements ActionListener{
	public void actionPerformed(ActionEvent evt){

	}
    }

    static Huntard frame;
    public static void main(String[] args){
	frame = new Huntard();
    }
}
