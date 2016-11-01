//The class for the characters that will be used in the game
public class Character{
    private String name;
    private int hp, thirst, strength, stealth, intelligence, psychology;
  
    //Constructor for each individual Object characters (we can add more, this is just a very basic default)
    public Character(String name, int strength, int stealth, int intelligence, int psychology){
	this.name = name;
	this.strength = strength;
	this.stealth = stealth;
	this.intelligence = intelligence;
	this.psychology = psychology;
	thirst = 100;
	hp = 100;
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
    public int getThirst(){
	return thirst;
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
    public void setThirst(int x){
	this.thirst = x;
    }

    //toString
    public String toString(){
	return name + "\n\nStrength: " + strength + "\nStealth: " + stealth + "\nIntelligence: " + intelligence + "\nPsychology: " + psychology +
            "\nThirst: " + getThirst() + "\nHunger: " + getHP();
    }
  
}
