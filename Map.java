/*
The existence of a map is checked by the program to determine if certain actions can be taken. The only purpose
is to be checked if the character has a map to see if he/she can perform those actions, so it only has the fields
name and durability which is the same for every instance and will be decreased by a static number after every use
 */
public class Map{
    /*
      Every map will have the same durability
     */
    private int durability;
    /*
      constructor calls super(name) and sets durability value
     */
    public Map(name);
    /*
      gets durability
     */
    public getDurability();
    /*
      decreases the durability of the map by a specified value
     */
    public decreaseDurability();
}
