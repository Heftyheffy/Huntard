/*
An Item is a thing that will be inherited by all of the classes that will represent a physical object with various uses in the game.
The Item class consists only of a string component name, a constructor that instantiates that, and a function to get the name.
This is because the classes that inherit the class Item wil be all be very different and the only thing they have in common is
the fact that they will all be an item and they will all have a name.
There is no setName() function because the name of the item will not change once it has been instantiated
The first line of all the constructors that inherit this class will be super(name) with name being the name of the item.
 */
public class Item{
    // this field will be the name of the item
    private string name;
    
    /*
      the public constructor will only accept one parameter of the name because that is all that the classes that inherit
      this class will have in common
     */
    public Item(string name){}    

    /*
      This method returns the name of the object
     */
    public string getName();


}
