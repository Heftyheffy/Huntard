/*
Overview: 

The MINI_GAME class serves as the parent class for SCAVENGING_GAME and HUNTING_GAME.  Each sub class inherits the methods and fiends
from the parent, but then it performs its respective mission.
At the end of each night the player choses whether
to hunt or to scavenge for resources. In the HUNTING_GAME, the player kills prey at different rates and receives rewards accoridingly.
In the SCAVENGING_GAME, the player finds resources useful for survival.

Preconditions:
Player able to hunt or to scavenge
Player contains stats, a map; a flashlight; and a gun.

Postconditions:
Player either hunted or scavenged;
Player either received rewards or punishments;
*/

public class MINI_GAME extends HUNTING_GAME{
    /*    FIELD VALUES:
      Every Player will have stats passed as a field;
      Every Player will have items passed as a field;
      Every Player will have time passed as a field;
      Every Player will enemy info passed as field;
    */
     public int stat1;
     public int stat2;
     public int stat3;
     public int item1;
     public int item2;
     public int item3;
     public int play_time;
     public int enemy1;
     public int enemy2;
     public int enemy3;
     
     //MINI_GAME uses above fields as constructor for the children
     public player_info (int start_stat1, int start_stat2, int start_stat3,
                         int start_item1, int start_item2, int start_item3,
                         int start_enemy1, int start_enemy2, int start_enemy3,
                         int start_play_time){
         stat1 = start_stat1;
         stat2 = start_stat2;
         stat3 = start_stat3;
         item1 = start_item1;
         item2 = start_item2;
         item3 = start_item3;
         play_time = start_play_time;
         enemy1 = start_enemy1;
         enemy2 = start_enemy2;
         enemy3 = start_enemy3;
     }
         
     
    
      
      /*     METHODS: */
      public void start_game();         // starts the mini game
      public void end_game();           //ends the mini game
      public void alert_player();       // issues various alerts (for example: time left; items won; or other reward/ punishment)
      public void upload_player_data(); // uploads and updates player data
      public void upload_item;          // uploads and updates the items
     

    public show_item(int item1, int item2, int item3);
    /*
      This function shows items
     */

    public update_item(int item1, int item2, int item3);
    /*
      This function updates items
     */
    
    public show_map();
    /*
      This function shows the map
     */
     
     public use_item();
     /*
      This function uses an item
     */
        
     public attack();
     /*
      This function attacks player
     */
}    	
    public class Scavenging_Game extends MINI_GAME{
    // Scavenging_Game subclass needs the following fields
    // flashlight: items
    // gun: items
    
    //Scavenging_Game subclass has one constructor
    public Scavening_Game (int start_stat1, int start_stat2, int start_stat3,
                           int start_item1, int start_item2, int start_item3,
                           int start_play_time){
        super (start_stat1, start_stat2, start_stat3,
               start_item1, start_item2, start_item3,
               start_play_time);
    }
        
   //Scavenging_Game uses these methods
    public show_items();    // show player items
    public upgrade_items(); // upgrade players items
    public show_map();      // show map
    public degrade_items;   // items degrades based upon use
    } //ends Scavengin_Game class
    
    public class Hunting_Game extends MINI_GAME{
    // Hunting_Game subclass needs the following fields
    //  gun: items
    
    //Hunting_Game subclass has one constructor
    public Hunting_Game (int start_stat1, int start_stat2, int start_stat3,
                         int start_item1, int start_item2, int start_item3,
                         int start_enemy1, int start_enemy2, int start_enemy3,
                         int start_play_time) 
                           ){
        super (start_stat1, start_stat2, start_stat3,
               start_item1, start_item2, start_item3,
               start_enemy1, start_enemy2, start_enemy3,
               start_play_time);
    } //ends Hunting_Game class
        
    //Hunting_Game subclass uses these methods
    public use_items();      // use items
    public update_items();   // update items
    public show_map();       // show map
    public attack();         // attack
    
    }
    

