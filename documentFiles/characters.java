public class characters(){
  static String name = null;
  static int stamina = 0;
  static int hp = 0;
  
  //Constructor for each individual Object characters (we can add more, this is just a very basic default)
  public characters(String name, int stamina, int hp){
    name = "";
    stamina = 100;
    hp = 100;
  }
  
  //Method to return name of character
  public String getName(){
    return name;
  }
  
  //Method to return hp of character
  public String getHP(){
    return hp;
  }
  
  //Method to return stamina of character
  public String getStamina(){
    return stamina;
  }
  
  //Method to set name of character
  public void setName(String x){
    name = x;
  }
  //Method to set HP of character
  public void setHP(int x){
    hp = x; 
  }
  
  //Method to set stamina of character
  public void setStamina(int x){
    stamina = x;
  }
  
  
  
}
