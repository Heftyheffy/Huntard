/**
 * Created by heffykim on 10/10/16.
 */


public class characters {
    //Each character will have name, stamina, hp
    private String name;
    private int stamina = 100;
    private int hp = 100;

    //Attributes
    private int charStr;
    private int charStl;
    private int charPsy;
    private int charInt;


    public characters(String x){
        name = x;
    }

    //Constructor for each individual Object characters (we can add more, this is just a very basic default)
    public characters(String charName,int strength,int charHP,int stealth,int psych,int intel){
        name = charName;
        charStr = strength;
        hp = charHP;
        charStl = stealth;
        charPsy = psych;
        charInt = intel;
    }

    //Method to return name of character
    public String getName(){
        return name;
    }

    //Method to return the HP of character
    public int getHP(){
        return hp;
    }

    //Method to return the stamina of character
    public int getStamina(){
        return stamina;
    }

    //Method to return the strength of character
    public int getStrength(){
        return charStr;
    }

    //Method to return the psychology of character
    public int getPsychology(){
        return charPsy;
    }

    //Method to return the intelligence of character
    public int getIntelligence(){
        return charInt;
    }

    //Method to return the stealth of character
    public int getStealth(){
        return charStl;
    }

    //Method to set hit points to x
    public void setHP(int x){
        hp = x;
    }

    //Method to set strength points to x
    public void setStrength(int x){
        charStr = x;
    }

    //Method to set pyschology points to x
    public void setPsychology(int x){
        charPsy = x;
    }

    //Method to set intelligence points to x
    public void setIntelligence(int x){
        charInt = x;
    }

    //Method to set stealth points to x
    public void setStealth(int x){
        charStl = x;
    }









}
