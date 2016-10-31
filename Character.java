import java.awt.*;
import javax.swing.*;

//The class for the characters that will be used in the game
public class Character{
    private String name;
    private int hp, stamina, strength, stealth, intelligence, psychology, mState, hunger, thirst;
    private ImageIcon full, icon;
  
    //Constructor for each individual Object characters (we can add more, this is just a very basic default)
    public Character(String name, int strength, int stealth, int intelligence, int psychology, ImageIcon full, ImageIcon icon){
	this.name = name;
	this.strength = strength;
	this.stealth = stealth;
	this.intelligence = intelligence;
	this.psychology = psychology;
	this.full = full;
	this.icon = icon;
	stamina = 100;
	hp = 100;
	mState = 100;
	hunger = 100;
	thirst = 100;
    }

    public int getmState(){
	return mState;
    }

    public int getHunger(){
	return hunger;
    }

    public int getThirst(){
	return thirst;
    }

    public void setmState(int a){
	mState = a;
    }

    public void setHunger(int a){
	hunger = a;
    }

    public void setThirst(int a){
	thirst = a;
    }
    
    //Method to return name of character
    public String getName(){
	return name;
    }
  
    //Method to return hp of character
    public int getHP(){
	return hp;
    }
  
    //Method to return stamina of character
    public int getStamina(){
	return stamina;
    }

    public int getStrength(){
	return strength;
    }

    public int getStealth(){
	return stealth;
    }

    public int getIntelligence(){
	return intelligence;
    }

    public int getPsychology(){
	return psychology;
    }
    
    //Method to set HP of character
    public void setHP(int x){
	this.hp = x; 
    }
  
    //Method to set stamina of character
    public void setStamina(int x){
	this.stamina = x;
    }

    public ImageIcon getIcon(){
	return icon;
    }

    public ImageIcon getFull(){
	return full;
    }    

    //toString
    public String toString(){
	return name + "\n\nStrength: " + strength + "\nStealth: " + stealth + "\nIntelligence: " + intelligence + "\nPsychology: " + psychology;
    }
  
}
