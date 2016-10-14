//creating user interface and for painting graphics and mimages
import java.awt.*;

//contains the collections framework, collection classes, event model
import java.util.*;

//provides for system input and output
import java.io.*;

//event generated from a user gesture
import javax.swing.*;

//classes and interfaces that deal with editable and noneditable text components
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

public class huntardMainScreen extends JFrame{

    JLabel title;
    JButton character, activites, items, radio;
    JPanel leftPanel, centerPanel, rightPanel, topPanel, bottomPanel, titlePanel, mainPanel;
    ImageIcon image;
    Color color1, color2;

    public huntardMainScreen(){
        color1 = new Color(193, 189, 189);
        color2 = new Color(124, 197, 234);

        File file = new File("../img/house.jpg");
        BufferedImage image = null;
        try{
            image = ImageIO.read(file);

        }
        catch(Exception e){
            System.out.println("error");
        }

        setContentPane(new BackgroundImage(image));

        //initialize panels
        leftPanel = new JPanel(new GridLayout(3, 1)); //3 rows, 1 column for characters, activities, items
        rightPanel = new JPanel();
        centerPanel = new JPanel();
        topPanel = new JPanel();
        bottomPanel = new JPanel();

        titlePanel = new JPanel();
        mainPanel = new JPanel(new BorderLayout());


        //configures titlePanel/title
        title = new JLabel("Main Screen");
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
        //radio.setBackground(Color.MAGENTA);
        radio.setForeground(Color.BLACK);
        radio.setRolloverEnabled(false);
        radio.addActionListener(new ButtonListener());


        //add buttons to leftPanel
        leftPanel.add(character);
        leftPanel.add(activites);
        leftPanel.add(items);
        leftPanel.setBackground(Color.white);

        rightPanel.add(radio);
        rightPanel.setBackground(color1);

        //add panels
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.EAST);

        //setup frame
        add(mainPanel);
        setSize(1200, 700);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(false);
        setVisible(true);
    }

    class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            String cmd = evt.getActionCommand();
            if(cmd == "Character"){
                mainPanel.removeAll();
                leftPanel.removeAll();
                leftPanel.setBackground(color1);
                centerPanel.setLayout(new GridLayout(1, 3));
                choosenCharacters();
                mainPanel.updateUI();
            }
        }

    }

    //Character Buttons
    JButton choseChar1, choseChar2, choseChar3;
    Characters charSteve, charLarry, charJoe;

    ArrayList<Characters> chars = new ArrayList<Characters>();



    public void choosenCharacters(){
        choseChar1 = new JButton("Steve");
        choseChar2 = new JButton("Larry");
        choseChar3 = new JButton("Joe");
        //Need to add buttons
        choseChar1.addActionListener(new CharacterListener());
        choseChar2.addActionListener(new CharacterListener());
        choseChar3.addActionListener(new CharacterListener());

        choseChar1.setBackground(Color.GRAY);
        choseChar2.setBackground(Color.GRAY);
        choseChar3.setBackground(Color.GRAY);

        charSteve = new Characters("Steve", 3, 1, 0, 2);
        charLarry = new Characters("Larry", 1, 2, 3, 0);
        charJoe = new Characters("Joe", 0, 3, 2, 1);

        //added to ArrayList
        chars.add(charSteve);
        chars.add(charLarry);
        chars.add(charJoe);

        centerPanel.add(choseChar1);
        centerPanel.add(choseChar2);
        centerPanel.add(choseChar3);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

    }

    //text are for character info
    JTextArea steveText, larryText, joeText, steveSummaryText;

    class CharacterListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //Initailizing Text Area
            steveText = new JTextArea();
            larryText = new JTextArea();
            joeText = new JTextArea();

            steveSummaryText = new JTextArea();


            //Giving dimenison to text area
            steveText.setPreferredSize(new Dimension(50, 50));
            larryText.setPreferredSize(new Dimension(150, 150));
            joeText.setPreferredSize(new Dimension(150, 150));

            steveSummaryText.setPreferredSize(new Dimension(150, 200));

            steveText.setEditable(false);
            larryText.setEditable(false);
            joeText.setEditable(false);

            steveSummaryText.setEditable(false);

            //each text area are giving Font and size
            steveText.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 25));
            larryText.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 25));
            joeText.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 25));

            steveSummaryText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));

            //setting background white, foreground black
            steveText.setBackground(Color.white);
            larryText.setBackground(Color.white);
            joeText.setBackground(Color.white);

            steveSummaryText.setBackground(Color.white);

            steveText.setForeground(Color.black);
            larryText.setForeground(Color.black);
            joeText.setForeground(Color.black);

            steveSummaryText.setForeground(Color.black);

            //setting text from ArrayList -- note that I have preset the characters in giving orders.
            steveText.setText(chars.get(0).toString());
            larryText.setText(chars.get(1).toString());
            joeText.setText(chars.get(2).toString());

            steveSummaryText.setText("This is Steve. There will be something to generator different quotes \nfor him ");
            String cmd = e.getActionCommand();
            if(cmd.equals(chars.get(0).getName())){
                centerPanel.removeAll();
                centerPanel.updateUI();

                JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, steveText, steveSummaryText);
                mainPanel.add(splitPane, BorderLayout.CENTER);







            }
        }

    }


    public static void main(String[] args){

        huntardMainScreen frame = new huntardMainScreen();
    }

}
