import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.event.*;

public class Decision{
    
    String text;
    String[] options, endings;
    boolean simple;    
    JTextArea area;
    Algorithm algo;
    int[] used = new int[50];
    Decision d[];
    JPanel panel, lPanel, rPanel, nPanel, sPanel, main;
    JLabel day;
    JComboBox cBox, iBox;
    JButton enter, okay;
    ArrayList<Character> chars;
    ArrayList<Item> items;
    Character c;
    int decisionNum = 2;
    
    public Decision(String text, boolean simple, String[] options, String[] endings, Algorithm algo){
	this.text = text;
	this.simple = simple;
	this.options = options;
	this.endings = endings;
	this.algo = algo;        
    }

    public void getDecision(JPanel p, ArrayList<Character> chars, ArrayList<Item> items){
	area = new JTextArea();
	panel = new JPanel(new BorderLayout());
	lPanel = new JPanel();
	rPanel = new JPanel();
	nPanel = new JPanel();
	sPanel = new JPanel();
	enter = new JButton("Enter");
	okay = new JButton("Okay");	    
	enter.addActionListener(new ButtonListener());
	okay.addActionListener(new ButtonListener());

	this.chars = chars;
	this.items = items;
	
	sPanel.setPreferredSize(new Dimension(100, 100));
	sPanel.setBackground(Color.black);

	nPanel.setPreferredSize(new Dimension(60, 60));
	nPanel.setBackground(Color.black);
	
	lPanel.setPreferredSize(new Dimension(100, 100));
	lPanel.setBackground(Color.black);
	
	rPanel.setPreferredSize(new Dimension(100, 100));
	rPanel.setBackground(Color.black);
	
	day = new JLabel("Day 1");
	day.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
	day.setForeground(Color.red);
	nPanel.add(day);	
	
	area.setText(d[decisionNum].text);
	if(d[decisionNum].simple){
	    cBox = new JComboBox(d[decisionNum].options);
	    cBox.setPreferredSize(new Dimension(200, 20));
	    sPanel.add(cBox);
	    sPanel.add(enter);
	    
	}
	else{
	    ImageIcon[] cBoxIcons = new ImageIcon[chars.size()];	    
	    for(int i=0; i < chars.size(); i++){
		//cBoxIcons[i] = chars.get(i).getIcon();
	    }
	    DefaultComboBoxModel<ImageIcon> icons = new DefaultComboBoxModel<ImageIcon>(cBoxIcons);
	    cBox = new JComboBox(icons);

	    ImageIcon[] iBoxIcons = new ImageIcon[items.size()];
	    for(int i=0; i <items.size(); i++){
		iBoxIcons[i] = items.get(i).getSmallIcon();
	    }
	    icons = new DefaultComboBoxModel<ImageIcon>(iBoxIcons);
	    iBox = new JComboBox(icons);

	    sPanel.add(cBox);
	    sPanel.add(enter);
	    sPanel.add(iBox);
	}
	area.setLineWrap(true);
	area.setWrapStyleWord(true);
	area.setBackground(Color.black);
	area.setForeground(Color.red);	
	area.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
	area.setEditable(false);
	panel.setBackground(Color.black);
	panel.setPreferredSize(new Dimension(600, 400));
	area.setPreferredSize(new Dimension(450, 300));
	p.removeAll();
	panel.add(lPanel, BorderLayout.EAST);
	panel.add(rPanel, BorderLayout.WEST);
	panel.add(nPanel, BorderLayout.NORTH);
	panel.add(area, BorderLayout.CENTER);
	panel.add(sPanel, BorderLayout.SOUTH);
	p.add(panel);
	p.setOpaque(false);	
    }

    public Decision[] generateDecisions(){
	d = new Decision[50];	
	//1,2,3,m,fl,r,f,w
	int[] itemInts = {2,3,4,0,0,0,-100,-1};
	//str, ste, int, psy, nums
	Algorithm rithm = new Algorithm(3, 1, 2, 0, itemInts);
	String[] e = {"The monks gladly accepted your tithe\n-1 Food", "The monks gladly accepted your tithe\n-1 Water", "The monks responded to your heresy with violence and you barely make it back alive\n-50 Health", "The monks proved more formidable than you initially thought but you were able to make it out with only a scratch\n-20 Health", "The monks have ran away in terror from your might and dropped some resources on their way out\n+2 Food and Water"};
	d[0] = new Decision("A roving band of monks of the new religious order proclaiming Harambe to be the gorilla jesus has appeared outside the shelter demanding tithe in the form of food and water. How should these people be dealt with?", false, null, e, rithm);
	
	itemInts = new int[]{3,2,1,0,3,0,-100,-1};
	rithm = new Algorithm(0, 3, 2, 1, itemInts);
	e = new String[]{"An enormous rat lunged out of the darkness at you! But luckily he went for your food and left you unscathed\n-1 Food", "An enormous rat lunged out of the darkness at you! But luckily he went for your food and left you unscathed\n-1 Water", "An enormous rat jumped out of the darkness and attacked you! The rat only left you alone after you played dead.\n-60 Health", "An enormous rat jumped out of the darkness and attacked you! Luckily you were able to scare it off before taking too much damage\n-10 Health", "Under the crawlspace you saw an enormous rat burrowing into the earth and luckily you were able to kill it. It looks delicious.\n+2 Food"};
	d[1] = new Decision("A sound can be heard coming from the crawlspace underneath the shelter. Who should go investigate?", false, null, e, rithm);

	String[] o = {"Yes", "No"};
	e = new String[]{"The rain turned out to have a high acidity and drinking it caused everyone to lose some health\n-20 All Health", "Water from the sky is gross anyways\n"};
	d[2] = new Decision("A torrential rain has started outside, should you go out and try to collect some to drink?", true, o, e, null);
	
	return d;
    }

    public void updatePanel(int num){
	sPanel.removeAll();
	int index;
	if(d[decisionNum].simple){
	    index = num;
	}
	else{
	    if(num < -100) index = 0;
	    else if(num < 0) index = 1;
	    else if(num < 17) index = 2;
	    else if(num < 32) index = 3;
	    else index = 4;	
	    area.setText(d[decisionNum].endings[index]);
	    sPanel.add(okay);
	    panel.updateUI();
	}
	String action = d[decisionNum].endings[index].substring(d[decisionNum].endings[index].indexOf("\n"));	
	String amount = action.substring(1,4);
	amount = amount.trim();
	action = action.substring(4);
	action = action.trim();
	int numAmount = Integer.valueOf(amount);
        if(action.equals("Health")){
	    c.setHP(c.getHP()+numAmount);	    
	}
	else if(action.equals("Food")){
	    Resource food = (Resource)items.get(0);
	    food.addAmount(numAmount);	    
	}
	else if(action.equals("Water")){
	    Resource water = (Resource) items.get(1);
	    water.addAmount(numAmount);	    
	}
	else if(action.equals("Food and Water")){
	    Resource food = (Resource)items.get(0);
	    Resource water = (Resource) items.get(1);
	    food.addAmount(numAmount);
	    water.addAmount(numAmount);	    
	}
    }

    class ButtonListener implements ActionListener{
	public void actionPerformed(ActionEvent evt){
	    String cmd = evt.getActionCommand();
	    if(cmd == "Enter"){
		if(d[decisionNum].simple){
		    updatePanel(cBox.getSelectedIndex());
		    
		}
		else{
		    c = chars.get(cBox.getSelectedIndex());
		    int num = d[decisionNum].algo.getNumber(c.getStrength(), c.getStealth(), c.getIntelligence(), c.getPsychology(), iBox.getSelectedItem());
		    System.out.println(num);
		    //updatePanel(num);
		}
	    }
	    
	    else{
		area.setText("");
		area.setOpaque(false);
		panel.removeAll();
		panel.setOpaque(false);
		panel.updateUI();
	    }
	    
	}
    }
}
