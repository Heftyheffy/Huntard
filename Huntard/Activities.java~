import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Activities{
    JButton hunt, scavenge, go;    
    JPanel leftPanel, panel;
    ArrayList<Character> chars;
    ArrayList<Item> items;
    boolean map;
    JPanel mainPanel;    

    public static JPanel staticGetActivities(JPanel panel, JPanel mainPanel, ArrayList<Character> chars, ArrayList<Item> items){
	Activities a = new Activities();	
	return a.getActivities(panel, mainPanel, chars, items);
    }

    public JPanel getActivities(JPanel panel, JPanel mainPanel, ArrayList<Character> chars, ArrayList<Item> items){
	panel = new JPanel();
	panel.setPreferredSize(new Dimension(500, 500));
	panel.setBackground(Color.black);
	panel.setOpaque(false);
	panel.setBorder(new EmptyBorder(110,0,0,0));
	this.mainPanel = mainPanel;
	this.chars = chars;
	this.items = items;

	centerPanel.add(panel);

	leftPanel = new JPanel();
	leftPanel.setOpaque(false);
	leftPanel.setPreferredSize(new Dimension(150, 150));

	hunt = new JButton("Hunt");
	hunt.addActionListener(new ButtonListener());
	hunt.setFocusPainted(false);
	hunt.setOpaque(false);
	hunt.setContentAreaFilled(false);	
        hunt.setForeground(Color.red);
        hunt.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
	hunt.setPreferredSize(new Dimension(150, 50));
	
	scavenge = new JButton("Scavenge");
	scavenge.addActionListener(new ButtonListener());
	scavenge.setFocusPainted(false);
	scavenge.setOpaque(false);
	scavenge.setContentAreaFilled(false);	
        scavenge.setForeground(Color.red);
        scavenge.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
	scavenge.setPreferredSize(new Dimension(150, 50));
	scavenge.setEnabled(false);
	map = false;
	
	for(int i=0; i < items.size(); i++){
	    if(items.get(i).getName().equals("Map")){
		scavenge.setEnabled(true);
		map = true;
		break;
	    }
	}
	
	leftPanel.add(hunt);
	leftPanel.add(scavenge);
	return leftPanel;
    }

    JComboBox cBox, iBox;
    JLabel townMap;
    
    class ButtonListener implements ActionListener{
	public void actionPerformed(ActionEvent evt){
	    String cmd = evt.getActionCommand();
	    if(cmd.equals("Go Hunt")){
		if(map){
		    mainPanel.removeAll();
		    townMap = new JLabel(new ImageIcon("townMap.png"));
		    panel.add(townMap);
		    mainPanel.add(panel);
		    mainPanel.updateUI();
		}
	    }
	    else if(cmd.equals("Go Scavenge")){
		if(map){

		}
	    }
	    else{
		panel.setOpaque(true);
		panel.removeAll();
		go = new JButton("Go " + cmd);
		go.addActionListener(this);
		ImageIcon[] cBoxIcons = new ImageIcon[chars.size()];	    
		for(int i=0; i < chars.size(); i++){
		    cBoxIcons[i] = chars.get(i).getIcon();
		}
		DefaultComboBoxModel<ImageIcon> icons = new DefaultComboBoxModel<ImageIcon>(cBoxIcons);
		cBox = new JComboBox(icons);

		ArrayList<ImageIcon> iBoxIconsList = new ArrayList<ImageIcon>();
		for(int i=3; i <items.size(); i++){
		    String name = items.get(i).getName();
		    if(cmd.equals("Hunt")){
			if(name.equals("Pistol") || name.equals("Shotgun") || name.equals("Rifle")){
			    iBoxIconsList.add(items.get(i).getSmallIcon());
			}
		    }
		    else{
			if(name.equals("Pistol") || name.equals("Shotgun") || name.equals("Rifle") || name.equals("Flashlight")){
			    iBoxIconsList.add(items.get(i).getSmallIcon());
			}
		    }
		}
		ImageIcon[] iBoxIcons = new ImageIcon[iBoxIconsList.size()];
		for(int i=0; i<iBoxIconsList.size(); i++){
		    iBoxIcons[i] = (ImageIcon)iBoxIconsList.get(i);
		}
		icons = new DefaultComboBoxModel<ImageIcon>(iBoxIcons);
		iBox = new JComboBox(icons);

		panel.add(cBox);
		panel.add(go);
		panel.add(iBox);
		panel.updateUI();
	    }
	}
    }
}
