import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import javax.swing.border.*;

public class ItemScreen{
    static JButton[] buttons;
    static JPanel rightPanel;
    static ImageIcon image1, image2;
    static Color color1, color2; 
    static Item[] allItems;
    static JTextArea infoArea;
	
    public static JPanel getItemScreen(JPanel panel, ArrayList<Item> itemList){
	GridLayout gl = new GridLayout(3,3);	
	gl.setHgap(40);
	gl.setVgap(2);
	panel.setLayout(gl);
	infoArea = new JTextArea();
	infoArea.setEditable(false);
	infoArea.setLineWrap(true);
	infoArea.setWrapStyleWord(true);
	infoArea.setFont(new Font(Font.SERIF, Font.BOLD, 20));
	infoArea.setPreferredSize(new Dimension(250, 400));
	infoArea.setBackground(Color.black);
	infoArea.setForeground(Color.red);
	infoArea.setOpaque(false);

	rightPanel = new JPanel();
	rightPanel.add(infoArea);
	rightPanel.setPreferredSize(new Dimension(300, 300));
	rightPanel.setBackground(Color.black);
	rightPanel.setOpaque(false);

	buttons = new JButton[9];
	allItems = new Item[9];
	allItems[0] = new Item("Food", null, new ImageIcon("food.png"));
	allItems[0].setDescription("It's food. Put it in your mouth and chew. It's necessary for survival.");
	
	allItems[1] = new Item("Water", null, new ImageIcon("water.png"));
	allItems[1].setDescription("A liquid. If you don't drink enough you'll die.");
	
	allItems[2] = new Item("Map", null, new ImageIcon("map.png"));
	allItems[2].setDescription("A map of the area. Use to hunt or scavenge in new locations.");
				   
	allItems[3] = new Item("Flashlight", null, new ImageIcon("flashlight.png"));
	allItems[3].setDescription("A flashlight. Use it to get more out of scavenging excursions.");

	allItems[4] = new Item("Radio", null, new ImageIcon("radio.png"));
	allItems[4].setDescription("A radio. Sometimes you need to hear what's going on around you. Not much music on it nowadays.");

	allItems[5] = new Item("Med Kit", null, new ImageIcon("medkit.png"));
	allItems[5].setDescription("A med kit. Use it if you start to die.");

	allItems[6] = new Item("Pistol", null, new ImageIcon("gun1.png"));
	allItems[6].setDescription("A powerful handgun. Use for self-protection and hunting nazi zombie gorillas.");

	allItems[7] = new Item("Shotgun", null, new ImageIcon("gun2.png"));
	allItems[7].setDescription("A powerful shotgun. Better than the handgun.");
	
	allItems[8] = new Item("Rifle", null, new ImageIcon("gun3.png"));
	allItems[8].setDescription("A powerful automatic rifle. This'll do.");

	for(int i = 0; i < 9; i++){
	    buttons[i] = new JButton(allItems[i].getBigIcon());
	    buttons[i].setEnabled(false);
	    buttons[i].addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent evt){
			JButton but = (JButton)evt.getSource();
			int index = -1;
			for(int i = 0; i < 9; i++){
			    if(buttons[i] == but){
				index = i;
				break;
			    }
			}						    
			infoArea.setText(allItems[index].getDescription());
		    }
		});

	    String name = allItems[i].getName();
	    for(int j = 0; j < itemList.size(); j++){
		if(name == itemList.get(j).getName()){
		    buttons[i].setEnabled(true);
		}
	    }
	    buttons[i].setOpaque(false);
	    buttons[i].setContentAreaFilled(false);
	    buttons[i].setFocusPainted(false);
	    panel.add(buttons[i]);
	}

	panel.setBorder(new EmptyBorder(20, 20, 20, 20));
	panel.updateUI();
	return rightPanel;	
    }
    
}
