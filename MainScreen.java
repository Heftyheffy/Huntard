import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import javax.imageio.*;
import java.awt.image.*;

public class MainScreen extends JFrame{
    JLabel day;
    JButton chars, acts, items, radio;
    JPanel dailyPanel;
    
    public MainScreen(ArrayList<Character> c){	
	File file = new File("house.jpg");
	BufferedImage image = null;
	try{
	    image = ImageIO.read(file);
	}
	catch(Exception e){}	    
	setContentPane(new BackgroundImage(image));

	chars = new JButton("Character");
	acts = new JButton("Activities");
	items = new JButton("Items");
	radio = new JButton(new ImageIcon("radio.png"));

	setLocationRelativeTo(null);			     
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setResizable(false);
	setSize(1200, 700);
	setVisible(true);
    }

    public static void main(String[] args){
	MainScreen ms = new MainScreen(new ArrayList<Character>());
    }
}
