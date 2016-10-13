/*
A gun will be used to hunt and can be used in daily situations to get specify certain actions. Different guns have different strength
which will be used in an the hunting mini game to kill prey at different rates and will be used in daily situations by an algorithm
to determine success of decisions. Durability will be decreased after every use and every gun will have the same starting value
for durability which will be set in the constructor. It will also always decrease by the same amount after every use.
 */

public class Gun{
    /*
      Every gun will have a name, strength, and durability field
     */
    String name;
    int power;
    int durability;
    /*
      The constructor will call super(name) and set the durability to a value that will be the same between all guns
     */
    public Gun(String name, int power, int durability){
    	this.name = name;
    	this.power = power;
    	this.durability = durability;
    }
    /*
      This function gets the strength of the gun
     */
    public int getStrength(){
    	return power;
    }
    /*
      This function gets the durability of the gun
     */
    public int getDurability(){
    	return durability;
    }
    /*
      This function decreases the durability by a constant factor whenever it is used
     */
    public void decreaseDurability(){
    	durability = durability - 1;
    }
    public String getName(){
    	return name;
    }
    public boolean canFire(){
        if(durability>0)
            return true;
        return false;
    }
}
/*I havent put any functions have to deal with ammo because the way durability will work would make managing ammo ridiculous. As is currently all guns will have ammo but break after
they have exhausted all of their uses as described in the original comment at the top. Since guns are acutally going to be used in the minigames I think the best way to manage them 
will be tying them to key-presses. For example the play will be told the instructions for the game by a pop up window and his 'ammo' (durability)  and hp will be displayed somewhere 
onscreen. After the pop up goes away the hot-key would activate and each time the player takes a shot the decreaseDurability() function is called simulating a loss of ammo. Of course 
when they reach 0 ammo the gun is out of durability an the player can no longer use it. Please let me know if there are any changes you would like to see to this file.*/
