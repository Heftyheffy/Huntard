/*
    An Item is a thing that will be inherited by all of the classes that will represent a physical object with various uses in the game.
    The Item class consists only of a string component name, a constructor that instantiates that, and a function to get the name.
    This is because the classes that inherit the class Item wil be all be very different and the only thing they have in common is
    the fact that they will all be an item and they will all have a name.
    There is no setName() function because the name of the item will not change once it has been instantiated
    The first line of all the constructors that inherit this class will be super(name) with name being the name of the item.
 */

import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;

public class Item {

    // this field will be the name of the item
    private String name;
    private ImageIcon smallIcon;
    private String description;


    //Constructor only accepting one parameter, because it all that the classes will inherit
    public Item(String theName, ImageIcon image1, ImageIcon image2){
        name = x;
    }

    //Getter method: retrieving the name of the item
    public String getName(){
        return name;
    }

    public void setDescription(String desc){
        description = desc;
    }

    public String getDescription(){
        return description;
    }

    public ImageIcon getSmallIcon(){
        return smallIcon;
    }

}
