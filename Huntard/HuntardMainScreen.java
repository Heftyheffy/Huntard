//creating user interface and for painting graphics and mimages
import java.awt.*;

//contains the collections framework, collection classes, event model
import java.util.*;

//provides for system input and output
import java.io.*;

//event generated from a user gesture
import javax.swing.*;

//classes and interfaces that deal with editable and noneditable text components
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import javax.swing.text.*;

//defines events and event listeners
import java.awt.event.*;

//ButtonListener
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.imageio.*;
import java.awt.image.*;
import javax.swing.border.*;

public class HuntardMainScreen extends JFrame{
    int dayNum = 1;

    JLabel title, mainPanel;
    JButton character, activites, items, radio, backButton, waterButton, foodButton;
    JPanel leftPanel, centerPanel, rightPanel, topPanel, bottomPanel, titlePanel;
    ImageIcon image;
    Color color1, color2;
    
    //Characters from ArrayList
    ArrayList<Character> chars;
    ArrayList<Item> listItem;
    Decision d;
    //Creating Resource for Food & Water and Resource extends Item
    //Meaning will have Item attributes
    int currCharIndex;

    public HuntardMainScreen(ArrayList<Character> c){
        color1 = new Color(193, 189, 189);
        color2 = new Color(124, 197, 234);

        //getting characters from startscreen pass to this class
        this.chars = c;

	//Create dummy object
	d = new Decision(null, false, null, null, null);
	d.generateDecisions();

        //Creating an ArrayList for Items to be stored
        listItem = new ArrayList<>();
        //Adding the items that will be giving to the player
	Random rand = new Random();

	listItem.add(new Resource("Food", new ImageIcon("foodIcon.png"), new ImageIcon("food.png"), rand.nextInt(3)+1 ));
	listItem.add(new Resource("Water", new ImageIcon("waterIcon.png"), new ImageIcon("water.png"), rand.nextInt(3)+1));
	listItem.add(new Resource("Medkit", new ImageIcon("medkitIcon.png"), new ImageIcon("medkit.png"), 1));
        listItem.add(new Item("Pistol", new ImageIcon("gunIcon1.png"), new ImageIcon("gun1.png")));
        listItem.add(new Item("Map", new ImageIcon("mapIcon.png"), new ImageIcon("map.png")));        

        //initialize panels
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        centerPanel = new JPanel();
        topPanel = new JPanel(new FlowLayout());
        bottomPanel = new JPanel();

        titlePanel = new JPanel(new BorderLayout());
        mainPanel = new JLabel(new ImageIcon("house2.jpg"));
	mainPanel.setLayout(new BorderLayout());

        character = new JButton("Character");
        character.setPreferredSize(new Dimension(150, 50));
        character.setOpaque(false);
	character.setContentAreaFilled(false);
	character.setFocusPainted(false);
        character.setForeground(Color.red);
        character.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        character.addActionListener(new ButtonListener());

        activites = new JButton("Activities");
        activites.setPreferredSize(new Dimension(150, 50));
        activites.setOpaque(false);
	activites.setContentAreaFilled(false);
	activites.setFocusPainted(false);
        activites.setForeground(Color.red);
        activites.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        activites.addActionListener(new ButtonListener());

        items = new JButton("Items");
        items.setPreferredSize(new Dimension(150, 50));
        items.setOpaque(false);
	items.setContentAreaFilled(false);
        items.setForeground(Color.red);
	items.setFocusPainted(false);
        items.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        items.addActionListener(new ButtonListener());

        radio = new JButton(new ImageIcon("radioIcon.png"));
        radio.setPreferredSize(new Dimension(50, 50));
	radio.setOpaque(false);
	radio.setFocusPainted(false);
	radio.setContentAreaFilled(false);
	radio.setBorderPainted(false);
        radio.addActionListener(new ButtonListener());

	title = new JLabel("Day " + dayNum);
        title.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 50));
        title.setForeground(Color.red);

	backButton = new JButton(new ImageIcon("backIcon.png"));
	backButton.setOpaque(false);
	backButton.setContentAreaFilled(false);
	backButton.setFocusPainted(false);
	backButton.addActionListener(new ButtonListener());
	backButton.setBorderPainted(false);

        setUpMainScreen();

        //setup frame
        add(mainPanel);
        setSize(1200, 700);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    //Setting up main screen method
    public void setUpMainScreen(){
	removeAllPanels();
	
        //add buttons to leftPanel
	centerPanel.setLayout(new FlowLayout());
	centerPanel.setBorder(new EmptyBorder(100, 100, 100, 100));
	
        //leftPanel.setLayout(new GridLayout(3, 1)); //3 rows, 1 column for characters, activities, items
	leftPanel.setPreferredSize(new Dimension(150,100));
        leftPanel.add(character);
        leftPanel.add(activites);
        leftPanel.add(items);
        leftPanel.setOpaque(false);

        //add radio button to right panel
	rightPanel.setPreferredSize(new Dimension(60,60));
        rightPanel.add(radio);
        rightPanel.setOpaque(false);

	activites.setEnabled(true);

        //add daily decision panel
	centerPanel.setOpaque(false);
	if(d.decisionNum == dayNum-1){
	    d.getDecision(centerPanel, chars, listItem);
	    activites.setEnabled(false);
	}
	else title.setText("Night " + dayNum);

	titlePanel.setLayout(new BorderLayout());
	titlePanel.add(title, BorderLayout.WEST);
        titlePanel.setOpaque(false);
	
        //add panels to main panel
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
	mainPanel.updateUI();
    }

    //Method to remove all panels
    public void removeAllPanels(){
        mainPanel.removeAll();
        leftPanel.removeAll();
        rightPanel.removeAll();
        centerPanel.removeAll();
        topPanel.removeAll();
        bottomPanel.removeAll();
        titlePanel.removeAll();
    }

    class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            String cmd = evt.getActionCommand();
	    JButton but = (JButton) evt.getSource();
	    ImageIcon icon = (ImageIcon) but.getIcon();
	    String desc = "";
	    if(icon != null){
		desc = icon.getDescription();
	    }
	    
            if(cmd.equals("Character")){
                charScreen();                
            }
	    else if(cmd.equals("Items")){
                removeAllPanels();
		rightPanel = ItemScreen.getItemScreen(centerPanel, listItem);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(rightPanel, BorderLayout.EAST);
		
		topPanel.setLayout(new BorderLayout());
		topPanel.setOpaque(false);
		topPanel.add(backButton, BorderLayout.WEST);

		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.updateUI();

            }
	    else if(cmd.equals("")){
                removeAllPanels();
                setUpMainScreen();
                mainPanel.updateUI();

            }
	    else if(cmd.equals("Activities")){
		removeAllPanels();        
		leftPanel = Activities.staticGetActivities(centerPanel, mainPanel, chars, listItem);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(leftPanel, BorderLayout.WEST);
		rightPanel.setPreferredSize(new Dimension(150, 150));
		bottomPanel.setPreferredSize(new Dimension(150, 150));
		bottomPanel.setOpaque(false);

		mainPanel.add(rightPanel, BorderLayout.EAST);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		topPanel.setLayout(new BorderLayout());
		topPanel.setOpaque(false);
		topPanel.add(backButton, BorderLayout.WEST);

		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.updateUI();
	    }
	    else if(desc.equals("waterIcon.png")){
		chars.get(currCharIndex).addThirst(30);
		if(chars.get(currCharIndex).getThirst() > 100){
		    chars.get(currCharIndex).setThirst(100);
		}
		Resource water = (Resource) listItem.get(1);
		water.addAmount(-1);
		waterButton.setText("x" + water.getAmount());
		if(water.getAmount() == 0){
		    waterButton.setEnabled(false);
		}
		mainPanel.updateUI();
            }
	    else if(desc.equals("foodIcon.png")){
	        chars.get(currCharIndex).addHunger(30);
		if(chars.get(currCharIndex).getHunger() > 100){
		    chars.get(currCharIndex).setHunger(100);
		}
		Resource food = (Resource) listItem.get(0);
		food.addAmount(-1);
		foodButton.setText("x"+ food.getAmount());
		if(food.getAmount() == 0){
		    foodButton.setEnabled(false);
		}
		mainPanel.updateUI();
	    }
        }

    }


    JButton[] charButs;

    public void charScreen(){
	removeAllPanels();

	charButs = new JButton[chars.size()];
        //the button name will have selected characters from user picked

	for(int i = 0; i < charButs.length; i++){
	    charButs[i] = new JButton(chars.get(i).getFull());
	    charButs[i].setFocusPainted(false);
	    charButs[i].setBackground(new Color(130, 0, 0));
	    charButs[i].addActionListener(new CharacterListener());
	    centerPanel.add(charButs[i]);
	}			               	       

	topPanel.setLayout(new BorderLayout());
	topPanel.setOpaque(false);
        topPanel.add(backButton, BorderLayout.WEST);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(topPanel, BorderLayout.NORTH);	
	mainPanel.updateUI();
    }


    JTextArea infoArea, textArea;
    JLabel charLabel;
    
    class CharacterListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
	    removeAllPanels();
            //Food and water button
	    Resource food = (Resource) listItem.get(0);
	    Resource water = (Resource) listItem.get(1);
	    
            waterButton = new JButton("x" + String.valueOf(water.getAmount()), new ImageIcon("waterIcon.png"));
	    if(water.getAmount() == 0) waterButton.setEnabled(false);
            foodButton = new JButton("x" + String.valueOf(food.getAmount()), new ImageIcon("foodIcon.png"));
	    if(food.getAmount() == 0) foodButton.setEnabled(false);
	    waterButton.setPreferredSize(foodButton.getPreferredSize());

	    infoArea = new JTextArea();
	    textArea = new JTextArea();

	    textArea.setEditable(false);
	    infoArea.setEditable(false);
	    
	    textArea.setBorder(new EmptyBorder(0, 20, 0, 0));

            //Adding food and water button listeners
            waterButton.addActionListener(new ButtonListener());
            foodButton.addActionListener(new ButtonListener());

            //Setting button-background to white
            waterButton.setBackground(Color.WHITE);
            foodButton.setBackground(Color.WHITE);

	    waterButton.setFocusPainted(false);
	    foodButton.setFocusPainted(false);
	    
            //setting text from ArrayList -- note that I have preset the characters in giving orders.

            JButton but = (JButton)e.getSource();
	    ImageIcon icon = (ImageIcon)but.getIcon();
	    String desc = icon.getDescription();

	    for(int i = 0; i<chars.size(); i++){
		if(chars.get(i).getFull().getDescription().equals(desc)){
		    currCharIndex = i;
		    break;
		}		
	    }
	    
	    topPanel.add(backButton, BorderLayout.WEST);
	    charLabel = new JLabel(chars.get(currCharIndex).getFull());
	    charLabel.setOpaque(false);
	    charLabel.setBorder(new EmptyBorder(50, 0, 0, 0));
	    leftPanel.add(charLabel);

	    infoArea.setText(chars.get(currCharIndex).toString());
	    infoArea.setFont(new Font(Font.SERIF, Font.BOLD, 25));
	    infoArea.setForeground(Color.red);
	    infoArea.setBackground(Color.black);	    

	    textArea.setText(generateTalk());
	    textArea.setFont(new Font(Font.SERIF, Font.BOLD, 25));
	    textArea.setForeground(Color.red);
	    textArea.setBackground(Color.black);
	    textArea.setLineWrap(true);	    
	    textArea.setWrapStyleWord(true);

	    centerPanel.setLayout(new BorderLayout());
	    centerPanel.add(infoArea, BorderLayout.WEST);
	    centerPanel.setBackground(Color.black);
	    titlePanel.setLayout(new FlowLayout());
	    centerPanel.add(textArea, BorderLayout.CENTER);
	    centerPanel.setOpaque(true);
	    titlePanel.add(waterButton);
	    titlePanel.add(foodButton);
	    leftPanel.setPreferredSize(new Dimension(220,220));
	    rightPanel.setPreferredSize(new Dimension(220,220));
	    bottomPanel.setPreferredSize(topPanel.getPreferredSize());
	    bottomPanel.setOpaque(false);
	    centerPanel.add(titlePanel, BorderLayout.SOUTH);
	    
	    mainPanel.add(leftPanel, BorderLayout.WEST);
	    mainPanel.add(centerPanel, BorderLayout.CENTER);
	    mainPanel.add(topPanel, BorderLayout.NORTH);
	    mainPanel.add(rightPanel, BorderLayout.EAST);
	    mainPanel.add(bottomPanel, BorderLayout.SOUTH);
	    mainPanel.updateUI();
        }

    }
    
    public String generateTalk(){	
	String speech = null;

	int lowest = -1, lowestNum;	
	int thirst = chars.get(currCharIndex).getThirst();
	int hunger = chars.get(currCharIndex).getHunger();
	int hp = chars.get(currCharIndex).getHP();
	int mState = chars.get(currCharIndex).getmState();

	if(thirst <= hunger && thirst <= hp && thirst <= mState){
	    lowest = 0;
	    lowestNum = thirst;
	}
	else if(hunger <= thirst && hunger <= hp && hunger <= mState){
	    lowest = 1;
	    lowestNum = hunger;
	}
	else if(hp <= thirst && hp <= hunger && hp <= mState){
	    lowest = 2;
	    lowestNum = hp;
	}
	else{
	    lowest = 3;
	    lowestNum = mState;
	}


	if(lowestNum < 50){
	    if(lowestNum > 40){
		switch(lowest){
		case 0: speech = "I'm starting to get pretty thirsty. Don't we have any water?";
		    break;
		case 1: speech = "My stomach is rumbling; I need to eat some food.";
		    break;
		case 2: speech = "I'm pretty hurt; I need to see a doctor or something.";
		    break;
		case 3: speech = "I can't believe we're in this situation. I don't think I can live like this for much longer.";
		}
		return speech;
	    }
	    else if(lowestNum > 30){
		switch(lowest){
		case 0: speech = "How am I supposed to live without water? I'm gonna die if I don't get some soon.";
		    break;
		case 1: speech = "I've never gone this long without food before. I didn't know I could feel so hungry.";
		    break;
		case 2: speech = "If I don't get medical attention I'm not going to last much longer.";
		    break;
		case 3: speech = "Why is all of this happening to me? I'm not a bad person.";
		}
		return speech;
	    }
	    else if(lowestNum > 20){
		switch(lowest){
		case 0: speech = "I can't move. Without water I can't move.";
		    break;
		case 1: speech = "Everytime I try to move my stomach cries in agony. I need food.";
		    break;
		case 2: speech = "I'm going to bleed out here. Why won't anyone help me?";
		    break;
		case 3: speech = "The walls are moving. They won't stop moving!";
		}
		return speech;
	    }
	    else if(lowestNum > 10){
		switch(lowest){
		case 0: speech = "Please, water. Please.";
		    break;
		case 1: speech = "My stomach can't take this anymore. I'm going to die.";
		    break;
		case 2: speech = "My wounds are festering, I won't last much longer. Find me help.";
		    break;
		case 3: speech = "Oh my god they're going to kill me. They're all going to kill me! They're going to crawl inside my mouth while I'm sleeping and murder me! I need to get out.";
		}
		return speech;
	    }
	    else{
		speech = "...";
		return speech;
	    }
	}
			      

	String name = chars.get(currCharIndex).getName();
	Random rand = new Random();
	int num = rand.nextInt(4);
	
        if(name.equals("Steve")){

            switch (num){
	    case 0: speech = "Eerrgh, I feel bad killing Harambe. I shouldn't have done it. But I had to...";
		break;
	    case 1: speech = "I wouldn't mind the zombie gorillas as much if they weren't nazis.";
		break;
	    case 2: speech = "I can't believe taking our Richards out didn't appease the spirit of Harambe.";
		break;
	    case 3: speech = "Constantly cowering in fear of death gets kinda boring.";
            }
            return speech;

        }
	else if(name.equals("Larry")){

            switch (num){
	    case 0: speech = "Hey Steve, wake me up when you need me!";
		break;
	    case 1: speech = "I knew the world would be destroyed by nazi zombie gorillas, but they told me I was on drugs. I was, but I still knew it.";
		break;
	    case 2: speech = "I need to do a line ASAP.";
		break;
	    case 3: speech = "Please help us, we are in need. Please!";
		break;

            }
            return speech;
        } else if(name.equals("Joe")){

            switch (num){
	    case 0: speech = "Like... Geez, so many aggressive, ummn, apes?";
		break;
	    case 1: speech ="Steveeee, I don't know man. There are so many of usesless items. Oh hey, what does this do?";
		break;
	    case 2: speech ="I wonder how everyone in this settlement is doing? I hope they're not stealing my scooby snacks...";
		break;
	    case 3: speech ="Zombie gorillas aren't that bad. But NAZI zombie gorillas? Really?";
		break;
            }
            return speech;
        } else if(name.equals("Joanne")){

            switch (num){
	    case 0: speech = "They ripped me off from Futurama, I am not Joanne. And my mental fortitude is great!";
		break;
	    case 1: speech = "We've been in this place for a long time. I need a bath.";
		break;
	    case 2: speech = "*awwwwwahhh* Oh, nevermind.";
		break;
	    case 3: speech = "Hey, what are you doing there? Aren't you suppose to be in the closet?";
            }
            return speech;
        }
	
        return null;
	
    }
    
    public static void outsideUpdate(){
	frame.setUpMainScreen();
    }

    static HuntardMainScreen frame;
    public static void startHMS(ArrayList<Character> c){
        frame = new HuntardMainScreen(c);
    }

    public static void main(String[] args){
	ArrayList<Character> c = new ArrayList<Character>();
	Character charSteve = new Character("Steve", 3, 1, 0, 2, new ImageIcon("steve.png"), new ImageIcon("sIcon.png"));
	Character charLarry = new Character("Larry", 1, 2, 3, 0, new ImageIcon("larry.png"), new ImageIcon("lIcon.png"));
	Character charJoanne = new Character("Joanne", 2, 0, 1, 3, new ImageIcon("joanne.png"), new ImageIcon("jnIcon.png"));

	c.add(charSteve);
	c.add(charLarry);
	c.add(charJoanne);
	startHMS(c);
    }

    static Character sentCharacter;

    public static void setSentCharacter(Character c){
	sentCharacter = c;
    }
    
    public static void sendResults(int intFood, int health){
        Resource food = (Resource) frame.listItem.get(0);
	food.addAmount(intFood);
	sentCharacter.setHP(health);
    }
}
