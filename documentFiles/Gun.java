/*
A gun will be used to hunt and can be used in daily situations to get specify certain actions. Different guns have different strength
which will be used in an the hunting mini game to kill prey at different rates and will be used in daily situations by an algorithm
to determine success of decisions. Durability will be decreased after every use and every gun will have the same starting value
for durability which will be set in the constructor. It will also always decrease by the same amount after every use.
 */

public class Gun extends Item{
    /*
      Every gun will have a name, strength, and durability field
     */
    int strength, durability;    
    /*
      The constructor will call super(name) and set the durability to a value that will be the same between all guns
     */
    public Gun(name, strength){...}
    /*
      This function gets the strength of the gun
     */
    public int getStrength(){...}
    /*
      This function gets the durability of the gun
     */
    public int getDurability(){...}
    /*
      This function decreases the durability by a constant factor whenever it is used
     */
    public void decreaseDurability(){...}
}
