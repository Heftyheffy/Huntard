import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;

public class ItemScreen extends JFrame{
	JLabel title, tempLabel, tempIcon;
    JPanel midPanel, titlePanel, mainPanel, tempPanel;
    ImageIcon image1, image2;
    Color color1, color2; 
    ArrayList<Item> items;
    ArrayList<JPanel> panelList;
	
	public ItemScreen(ArrayList itemList){
		color1 = new Color(220,0,0);
		color2 = new Color(130,0,0);
		items = itemList;

	//initialize panels

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
		/*item1 = new JLabel("Glock");
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
			
	*/

	//add titlePanel to mainPanel
		mainPanel.add(titlePanel, BorderLayout.NORTH);
	
	//add items to midpanel
		for (Item anItem : items){
			tempPanel = new JPanel(new BorderLayout());
			tempLabel = new JLabel(anItem.getName());
			tempIcon = new JLabel(anItem.getSmallIcon());
			tempPanel.add(tempLabel, BorderLayout.NORTH);
			tempPanel.add(tempIcon, BorderLayout.CENTER);
			//tempPanel.add(description1, BorderLayout.SOUTH);
			panelList.add(tempPanel);
		}

		for (JPanel aPanel : panelList){
			midPanel.add(aPanel);
		}
	//add midPanel to mainPanel	
		mainPanel.add(midPanel, BorderLayout.CENTER);

	//setup frame
		add(mainPanel);
		setSize(1200, 700);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
}

	static ItemScreen frame;
    public static void main(String[] args){
    	
    	ImageIcon gunImage, mapImage;
    	Item gunItem, mapItem;

    	//set images
    	gunImage = new ImageIcon("gun1.png");
    	mapImage = new ImageIcon("mapIcon.png");
    	
    	//initialize items
    	gunItem = new Item("gun", gunImage);
    	mapItem = new Item("map", mapImage);
    	
    	ArrayList<Item> items = new ArrayList<Item>();
    	
    	items.add(gunItem);
    	items.add(mapItem);

		frame = new ItemScreen(items);
    }
}
