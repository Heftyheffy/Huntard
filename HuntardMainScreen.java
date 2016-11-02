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
    //Variables for night and day
    //If player selecting hunting/scav, they could only choose it after compleltion of daily decision
    //After daily decision, it becomes night time
    //Adding day, when dailydecision isn't completed, cannot click on activities button (setEnabled(False))
    //when dailyDecions is completed, can talk to others and can go on hunting and scavneging.
    int dayNum = 1;


        /*
            I will be using Item.java file, this file only has the basics such as
                item name, item description and smallIcon
            USING: Github version of items
                When program runs, the program will give random number of resources and also the program
                    will give the player a pistol, map

         */
        //Creating an ArrayList for Items to be stored
    listItem = new ArrayList<Item>();
        //Adding the items that will be giving to the player
    Random rand = new Random();
        
	listItem.add(new Resource("Food", null, new ImageIcon("foodIcon.png"), rand.nextInt(4)+1));
    listItem.add(new Resource("Water", null, new ImageIcon("waterIcon.png"), rand.nextInt(4)+1));
    listItem.add(new Item("Map", null, new ImageIcon("mapIcon.png")));
	listItem.add(new Item("Pistol", null, new ImageIcon("gunIcon1.png")));
	
        //initialize panels
    leftPanel = new JPanel();
    rightPanel = new JPanel();
    centerPanel = new JPanel();
    topPanel = new JPanel();
    bottomPanel = new JPanel();

    titlePanel = new JPanel();
    mainPanel = new JPanel(new BorderLayout());

	character = new JButton("Character");
        character.setPreferredSize(new Dimension(100, 100));
        character.setBackground(Color.GRAY);
        character.setForeground(Color.BLACK);
        character.setRolloverEnabled(false);
        character.addActionListener(new ButtonListener());

	activites = new JButton("Activities");
        activites.setPreferredSize(new Dimension(100, 100));
        activites.setBackground(Color.GRAY);
        activites.setForeground(Color.BLACK);
        activites.setRolloverEnabled(false);
        activites.addActionListener(new ButtonListener());

	items = new JButton("Items");
        items.setPreferredSize(new Dimension(100, 100));
        items.setBackground(Color.GRAY);
        items.setForeground(Color.BLACK);
        items.setRolloverEnabled(false);
        items.addActionListener(new ButtonListener());

	radio = new JButton(new ImageIcon("radioIcon.png"));                
        radio.setRolloverEnabled(false);
        radio.addActionListener(new ButtonListener());

        setUpMainScreen();

        //setup frame
        add(mainPanel);
        setSize(1200, 700);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(false);
        setVisible(true);
    }
        
    //Setting up main screen method
    public void setUpMainScreen(){

        title = new JLabel("Day " + dayNum);
        title.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 50));
        title.setForeground(Color.red);
        titlePanel.add(title);

        titlePanel.setOpaque(false);

        //add buttons to leftPanel
	GridLayout gl = new GridLayout(3, 1);
	gl.setVgap(30);
        leftPanel = new JPanel(gl); //3 rows, 1 column for characters, activities, items
        leftPanel.add(character);
        leftPanel.add(activites);
        leftPanel.add(items);
        leftPanel.setOpaque(false);	

        //add radio button to right panel
        rightPanel.add(radio);
        rightPanel.setOpaque(false);

        //add daily decision panel
        Decision d = new Decision(null, false, null, null, null);
	d.generateDecisions();
	d.getDecision(centerPanel, chars, listItem);
        centerPanel.setOpaque(false);

        //add panels to main panel
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);	
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
            if(cmd.equals("Character")){
                removeAllPanels();
                leftPanel.setBackground(color1);
                centerPanel.setLayout(new GridLayout(1, 3));
                choosenCharacters(chars);
                mainPanel.updateUI();
		
            } else if(cmd.equals("Items")){
                removeAllPanels();
                centerPanel.setBackground(color1);
                //Insert what Robert is working on here....

            } else if(cmd.equals("Back")){
                removeAllPanels();
                setUpMainScreen();
                titlePanel.updateUI();
                mainPanel.updateUI();

            } else if(cmd.equals("Give Water") || cmd.equals("Give Food")){
                //check if player has resources to use
                //cannot use resource if resource is 0
                //if player health is 100, then cannot give more hp
                //if player thrist is 100, then cannot give more thirst
                if(itemList.get(1).getAmount() >= 0){
                    if(cmd.equals("Give Water")){
                        if(listItem.get(0).getAmount() >= 0 && listItem.get(0).getAmount() < 100){
                            listItem.get(0).addAmount(20);
                        }else {
                            //System.out.println("Cannot give water");
                            warningText.setText("Cannot give water");
                        }
                    }else if (cmd.equals("Give Food")){
                        if(listItem.get(1).getAmount() >= 0 && listItem.getAmount() < 100){
                            listItem.get(1).addAmount(20);
                        }else {
                            //System.out.println("Cannot give food");
                            warningText.setText(("Cannot give food"));
                        }
                    }
                }else {
                    System.out.println("Error giving food or water");
                }

            } else if(cmd.equals("Decisions")){
                //Day will increase because the character has choosen "Decision"
                //Decision needs to be complete inorder to advance to night
                day++;
            }
        }

    }

    //Character Buttons
    //Sorry, this might confuse you...
    JButton choseChar1, choseChar2, choseChar3;
    String chosenChar1, chosenChar2, chosenChar3;
    String infoChar1, infoChar2, infoChar3;

    public void choosenCharacters(ArrayList<Character> chars){
        chosenChar1 = chars.get(0).getName();
        chosenChar2 = chars.get(1).getName();
        chosenChar3 = chars.get(2).getName();

        //Retreiving toString from characters
        infoChar1 = chars.get(0).toString();
        infoChar2 = chars.get(1).toString();
        infoChar3 = chars.get(2).toString();

        //the button name will have selected characters from user picked
        choseChar1 = new JButton(chosenChar1);
        choseChar2 = new JButton(chosenChar2);
        choseChar3 = new JButton(chosenChar3);

        //Back button
        backButton = new JButton("Back");

        //Need to add buttons
        choseChar1.addActionListener(new CharacterListener());
        choseChar2.addActionListener(new CharacterListener());
        choseChar3.addActionListener(new CharacterListener());

        //Need to add back button action listener
        backButton.addActionListener(new ButtonListener());

        choseChar1.setBackground(Color.GRAY);
        choseChar2.setBackground(Color.GRAY);
        choseChar3.setBackground(Color.GRAY);

        backButton.setBackground(Color.WHITE);

        centerPanel.add(choseChar1);
        centerPanel.add(choseChar2);
        centerPanel.add(choseChar3);

        topPanel.add(backButton);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(topPanel, BorderLayout.NORTH);

    }

    //text are for character info
    JTextArea char1Text, char1SummaryText;

    //Resource string
    JTextArea resoureText;

    //Warning string
    JTextArea warningText;

    class CharacterListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //Food and water button
            waterButton = new JButton("Give Water");
            foodButton = new JButton("Give Food");

            //Adding food and water button listeners
            waterButton.addActionListener(new ButtonListener());
            foodButton.addActionListener(new ButtonListener());

            //Setting button-background to white
            waterButton.setBackground(Color.WHITE);
            foodButton.setBackground(Color.WHITE);

            //Initailizing Text Area
            char1Text =  new JTextArea();
            char1SummaryText = new JTextArea();

            //initializing Text area for Resource
            resoureText = new JTextArea();

            //Initializing text are for warning
            warningText = new JTextArea();

            //Giving dimenison to text area
            char1Text.setPreferredSize(new Dimension(50, 50));
            char1SummaryText.setPreferredSize(new Dimension(150, 200));

            resoureText.setPreferredSize(new Dimension(50, 50));
            warningText.setPreferredSize(new Dimension(25, 25));

            char1Text.setEditable(false);
            char1SummaryText.setEditable(false);

            resoureText.setEditable(false);
            warningText.setEditable(false);

            //each text area are giving Font and size
            char1Text.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 25));
            char1SummaryText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));

            resoureText.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 25));
            warningText.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 15));

            //setting background white, foreground black
            char1Text.setBackground(Color.white);
            char1SummaryText.setBackground(Color.white);

            resoureText.setBackground(Color.WHITE);
            warningText.setBackground(Color.WHITE);

            char1Text.setForeground(Color.black);
            char1SummaryText.setForeground(Color.black);

            resoureText.setForeground(Color.BLACK);
            warningText.setForeground(Color.RED);

            //setting text from ArrayList -- note that I have preset the characters in giving orders.
            //char1Text.setText(chars.get(0).toString());
            String cmd = e.getActionCommand();

            if(cmd.equals(chosenChar1)){
                //clearing the centerPanel
                centerPanel.removeAll();
                centerPanel.updateUI();
                //selecting toString and adding food & water button
                char1Text.setText(infoChar1);
                //Select toString from Resource
                resoureText.setText(source.toString());

                //What its going to be displayed when character is selected
                centerPanel.add(char1Text);
                centerPanel.add(waterButton);
                centerPanel.add(foodButton);
                centerPanel.add(resoureText);
                centerPanel.add(warningText);

                //generate random text from generateTalk method
                char1SummaryText.setText(generateTalk(chosenChar1));

                JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, centerPanel, char1SummaryText);
                mainPanel.add(splitPane, BorderLayout.CENTER);
            } else if(cmd.equals(chosenChar2)){
                centerPanel.removeAll();
                centerPanel.updateUI();

                char1Text.setText(infoChar2);
                char1SummaryText.setText(generateTalk(chosenChar2));

                JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, char1Text, char1SummaryText);
                mainPanel.add(splitPane, BorderLayout.CENTER);
            } else if(cmd.equals(chosenChar3)){
                centerPanel.removeAll();
                centerPanel.updateUI();

                char1Text.setText(infoChar3);
                char1SummaryText.setText(generateTalk(chosenChar3));

                JSplitPane splitePane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, char1Text, char1SummaryText);
                mainPanel.add(splitePane, BorderLayout.CENTER);
            } else {
                System.out.println("Error selecting a character");
            }
        }

    }



    Random randNumber = new Random();
    public String generateTalk(String chars){
       String speech;

        if(chars.equals("Steve")){

            int xNumber = randNumber.nextInt(3);

            switch (xNumber){
                case 0: speech = "Eerrgh, I feel bad killing Harambe. I should not have done it.\nBut I had to..."; break;
                case 1: speech = "hey hey hye it's time to make some craz\nzzzz money are ya ready? Booom there it goes"; break;
                case 2: speech = ("we have died of dysentery"); break;
                case 3: speech = ("I have started this mess...\n It was my fault. And all the cake is gone. Don't you care?"); break;
                default: speech = ("I wonder if you can even get this error?"); break;

            }
            return speech;

        } else if(chars.equals("Larry")){
            int number = randNumber.nextInt(3);

            switch (number){
                case 0: speech = ("Hey STEVE, wake me up when you need me!"); break;
                case 1: speech = ("Please do not be humored by my texts...."); break;
                case 2: speech = ("I need to do a line ASAP"); break;
                case 3: speech = ("Please help us, we are in need. Please!"); break;
                default: speech = ("This is larry breaking point"); break;

            }
            return speech;
        } else if(chars.equals("Joe")){
            int number = randNumber.nextInt(3);
            switch (number){
                case 0: speech =("Like... Geezh, so many aggressive. ummn, apes?"); break;
                case 1: speech =("Steveeee, i do not know man. \nThere are so many of usesless items. Oh hey, what does this do?"); break;
                case 2: speech =("I wonder how everyone in this settlement is doing?\nHope they are not getting my food that Scooby made"); break;
                case 3: speech =("I am joe. I am a wilderness explorer. "); break;
                default: speech =("I really hope no one is really reading this shit."); break;
            }
            return speech;
        } else if(chars.equals("Joanne")){
            int number = randNumber.nextInt(3);
            switch (number){
                case 1: speech = ("They ripped me off from Future-Drama, I am not Joanne.\nAnd my mental fortitude is great!"); break;
                case 2: speech = ("I have been on this place for a long time.\nI have fought Gorillas."); break;
                case 3: speech = ("*awwwwwahhh* oh nevermind"); break;
                case 4: speech = ("Hey, what are you doing there? Aren't you suppose to be in the closet?"); break;
                default: speech = ("I am hoping this else-if statement would break"); break;
            }
            return speech;
        } else {
                System.out.println("Error in generateTalk");
            }
        return "";
    }


    public static void main(String[] args){

        HuntardMainScreen frame = new HuntardMainScreen(new ArrayList<Character>());
    }

    }
