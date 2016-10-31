import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;

public class ItemScreen extends JFrame{
	JLabel title, item1, item2, item3, item4, item5, item6, gun, map, description1, description2, tempLabel, tempIcon;
    JPanel midPanel, titlePanel, mainPanel, item1Panel, item2Panel, tempPanel;
    ImageIcon image1, image2;
    Color color1, color2;  
	
	public ItemScreen(JPanel x){
		color1 = new Color(220,0,0);
		color2 = new Color(130,0,0);
		//itemList = theItems;

	//initialize panels
		item1Panel = new JPanel(new BorderLayout());
		item2Panel = new JPanel(new BorderLayout());
		midPanel = new JPanel(new GridLayout(2, 3));
		titlePanel = new JPanel();
		mainPanel = new JPanel(new BorderLayout());


	//configures titlePanel/title
		title = new JLabel("Items");
		title.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
		title.setForeground(Color.black);
		titlePanel.add(title);	
		titlePanel.setBackground(color1);

	//configures the containers for the items
		item1 = new JLabel("Glock");
		item1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
		item1.setForeground(Color.black);

		image1 = new ImageIcon("gun1.png");
		gun = new JLabel(image1);

		description1 = new JLabel("A powerful handgun.");
		description1.setFont(new Font(Font.MONOSPACED, Font.PLAIN ,20));

		item1Panel.add(item1, BorderLayout.NORTH);
		item1Panel.add(gun, BorderLayout.CENTER);
		item1Panel.add(description1, BorderLayout.SOUTH);

		item2 = new JLabel("Map");
		item2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
		item2.setForeground(Color.black);

		image2 = new ImageIcon("mapIcon.png");
		map = new JLabel(image2);

		description2 = new JLabel("A map of the surrounding area");
		description2.setFont(new Font(Font.MONOSPACED, Font.PLAIN ,20));

		item2Panel.add(item2, BorderLayout.NORTH);
		item2Panel.add(map, BorderLayout.CENTER);
		item2Panel.add(description2, BorderLayout.SOUTH);

		item3 = new JLabel("Item3");
		item3.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
		item3.setForeground(Color.black);

		item4 = new JLabel("Item4");
		item4.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
		item4.setForeground(Color.black);

		item5 = new JLabel("Item5");
		item5.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
		item5.setForeground(Color.black);

		item6 = new JLabel("Item6");
		item6.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
		item6.setForeground(Color.black);

	//add items to midPanel
		
		midPanel.add(item1Panel);
		midPanel.add(item2Panel);
		midPanel.add(item3);
		midPanel.add(item4);
		midPanel.add(item5);
		midPanel.add(item6);
		

	//add midPanel to mainPanel
		mainPanel.add(titlePanel, BorderLayout.NORTH);
		//createPanels()
		mainPanel.add(midPanel, BorderLayout.CENTER);

	//setup frame
		add(mainPanel);
		setSize(1200, 700);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

}
	/*public static void createPanels(){
		for (Item anItem : itemList) {
			tempLabel = new JLabel(anItem.name);
			tempIcon = new JLabel(anItem.icon);
			tempPanel.add(tempLayout, BorderLayout.NORTH);
			tempPanel.add(tempIcon, BorderLayout.CENTER);
			tempPanel.add(description1, BorderLayout.SOUTH);
			midPanel.add(tempPanel);
		}
	}*/
	

	static ItemScreen frame;
    public static void main(String[] args){
		/*
    	ImageIcon gunImage, mapImage;
    	gunImage = new ImageIcon("gun1.png");
    	gunItem = new Item("gun", gunImage);
    	mapImage = new ImageIcon("mapIcon.png");
    	mapItem = new Item("map", mapImage);
    	ArrayList<Item> items = new ArrayList<Item>();
    	items.add(gunItem);
    	items.add(mapItem);
    	for (Item i : items) {
    		System.out.println(i.name);
    	}
    	*/
		frame = new ItemScreen();
    }
}
