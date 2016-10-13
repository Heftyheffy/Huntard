/**
 *  A MedKit is an item that will help players to heal during scavenging and hunting mini-games. It can only be used once per mini-game.
 *  Components such as bandage and alcohol will be needed to create a MedKit. They could be selected to create under the items tab.
 *  Using a MedKit will hinder a perfect score in a scavenging or hunting mini-game.
 *
 */
public class medKit extends items{

    public medKit(){
        /*
            Constructor checks to see if the character has a functional med-kit.
         */
    }

    public void checkRequirements(){
        /*
            This method will check to see if the character has bandage and alcohol in items.
            @pre: isCharacterSelect(), doesCharHaveItems()
            @post: charMakeMed(), !charMakeMed()
         */
    }

    public boolean isCharacterSelect(){
        /*
            This method will check and see if a character is selected. If it is not, then it will prompt a warning by
            using GUI. If a character is selected, then the next step will check to see if character has required items.
            @pre: isCharacterCreated()
            @post: checkRequirements()
         */
    }

    public int healthIncrease(){
        /*
            When med-kit is used by the character, Med-Kit will heal the character HP by 30 points.

            @pre: checkRequirements()
            @post: addHPtoChar()
         */
    }    
}
