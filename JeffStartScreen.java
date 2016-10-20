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

public class JeffStartScreen extends JFrame{

    JLabel title;
    JButton character, activites, items, radio, backButton;
    JPanel leftPanel, centerPanel, rightPanel,  bottomPanel, titlePanel, mainPanel;
    ImageIcon image;
    Color color1, color2;

    //Characters from ArrayList
    ArrayList<Character> chars;

    public JeffStartScreen(ArrayList<Character> c){
        color1 = new Color(193, 189, 189);
        color2 = new Color(124, 197, 234);

        //getting characters from startscreen pass to this class
        this.chars = c;

        /*
            For the sake of testing: I have created set characters and add them to ArrayList<Characters>
            I would have to delete these for the actually working program.

            Remember: To go back to GameStart in ContinueStory method to uncomment!
         */
        Character charSteve = new Character("Steve", 3, 1, 0, 2, null, null);
        Character charLarry = new Character("Larry", 1, 2, 3, 0, null, null);
        Character charJoe = new Character("Joe", 0, 3, 2, 1, null, null);

        chars.add(charSteve);
        chars.add(charLarry);
        chars.add(charJoe);


        //initialize panels        
        rightPanel = new JPanel();
        centerPanel = new JPanel();        
        bottomPanel = new JPanel();

        titlePanel = new JPanel();
        mainPanel = new JPanel(new BorderLayout());


        //configures titlePanel/title
        title = new JLabel("HUNTARD: REVENGE OF HARAMBE");
        title.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 50));
        title.setForeground(Color.cyan);
        titlePanel.add(title);

        titlePanel.setBackground(color1);

        //configure buttons --character, activities, items
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

        radio = new JButton("Radio");
        radio.setPreferredSize(new Dimension(50, 50));
        radio.setForeground(Color.BLACK);
        radio.setRolloverEnabled(false);
        radio.addActionListener(new ButtonListener());        

	backButton = new JButton("Back");
	backButton.addActionListener(new ButtonListener());

        //add buttons to leftPanel
        leftPanel = new JPanel(new GridLayout(3, 1)); //3 rows, 1 column for characters, activities, items
        leftPanel.add(character);
        leftPanel.add(activites);
        leftPanel.add(items);
        leftPanel.setOpaque(false);

        //add radio button to right panel
        rightPanel.add(radio);
        rightPanel.setBackground(color1);

        //add daily decision panel        
        centerPanel.setOpaque(false);

        //add panels to main panel
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        //setup frame
        add(mainPanel);
        setSize(1200, 700);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(false);
        setVisible(true);
    }

    //Method to remove all panels
    public void removePanels(){
        mainPanel.removeAll();
        leftPanel.removeAll();
        titlePanel.removeAll();
        centerPanel.removeAll();        
    }

    class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            String cmd = evt.getActionCommand();
            if(cmd.equals("Character")){
		removePanels();                
                centerPanel.setLayout(new GridLayout(1, 3));
                chosenCharacters(chars);
                mainPanel.updateUI();
            }
	    else if(cmd.equals("Back")){
		paintMain();
	    }
	    
        }

    }

    //Character Buttons
    //Sorry, this might confuse you...
    JButton choseChar1, choseChar2, choseChar3;
    String chosenChar1, chosenChar2, chosenChar3;
    String infoChar1, infoChar2, infoChar3;

    public void chosenCharacters(ArrayList<Character> chars){
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

        //Need to add buttons
        choseChar1.addActionListener(new CharacterListener());
        choseChar2.addActionListener(new CharacterListener());
        choseChar3.addActionListener(new CharacterListener());

        choseChar1.setBackground(Color.GRAY);
        choseChar2.setBackground(Color.GRAY);
        choseChar3.setBackground(Color.GRAY);

        centerPanel.add(choseChar1);
        centerPanel.add(choseChar2);
        centerPanel.add(choseChar3);
	
	titlePanel.add(backButton);
	mainPanel.add(titlePanel, BorderLayout.NORTH);		      
        mainPanel.add(centerPanel, BorderLayout.CENTER);

    }

    //text are for character info
    JTextArea char1Text, char1SummaryText;

    class CharacterListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //Initailizing Text Area
            char1Text =  new JTextArea();
            char1SummaryText = new JTextArea();

            //Giving dimenison to text area
            char1Text.setPreferredSize(new Dimension(50, 50));
            char1SummaryText.setPreferredSize(new Dimension(150, 200));

            char1Text.setEditable(false);
            char1SummaryText.setEditable(false);

            //each text area are giving Font and size
            char1Text.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 25));
            char1SummaryText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));

            //setting background white, foreground black
            char1Text.setBackground(Color.white);
            char1SummaryText.setBackground(Color.white);

            char1Text.setForeground(Color.black);
            char1SummaryText.setForeground(Color.black);

            //setting text from ArrayList -- note that I have preset the characters in giving orders.
            //char1Text.setText(chars.get(0).toString());
            String cmd = e.getActionCommand();

            if(cmd.equals(chosenChar1)){
                centerPanel.removeAll();
                centerPanel.updateUI();

                char1Text.setText(infoChar1);
                char1SummaryText.setText(generateTalk(chosenChar1));

                JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, char1Text, char1SummaryText);
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

    public void paintMain(){
	mainPanel.removeAll();
	
	titlePanel.removeAll();
	titlePanel.add(title);
	leftPanel.removeAll();
	leftPanel.setLayout(new GridLayout(3,1));
	leftPanel.add(character);
	leftPanel.add(activites);
	leftPanel.add(items);
	leftPanel.setOpaque(false);

	centerPanel.removeAll();
	mainPanel.add(titlePanel, BorderLayout.NORTH);
	mainPanel.add(leftPanel, BorderLayout.WEST);
	mainPanel.add(rightPanel, BorderLayout.EAST);
	mainPanel.add(centerPanel, BorderLayout.CENTER);

	mainPanel.updateUI();
    }

    static JeffStartScreen frame;
    public static void main(String[] args){

        frame = new JeffStartScreen(new ArrayList<Character>());
    }

}
