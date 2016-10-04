/**
 * DailyDecisions: Each morning, day, will prompt the user a case of:
 *  1. Random events
 *      1a. Ration items(food/water)
 *
 *  Purpose: This will decided of whether the user has the ability to ration food properly,
 *      carefully select critical decisions about daily situations, there could be a chance of not having DailyDecision,
 *      depends on the random generator. The purpose of DailyDecision is rewarding/punishing the decisions of the player.
 *
 *
 *  Develop a solution:
 *      The solution could partake on creating this class solely for creating new decision for each day, still holding the basic
 *      grounds of each categories for the decisions(situation decisions, ration food decision, and improvement base situations).
 *      The "main method" of creating the situations and other methods of supporting the end result of what the "main method" have created.
 *
 *
 *  Pre-Conditions:
 *      1. Has to prompt during the day. No nightly decision - activities during the night are scavenging or hunting.
 *
 *  Post-Conditions:
 *      Depending on which outcome, good or bad, this class could either reward the player or punish.
 *      By following the output scale (1-10), 1-5 representing the worst outcomes would punish the player.
 *      5-10 would reward the player.
 *      Extremes from both ends of the scale has a low chance of being picked, so algorithmic factors would be involved
 *      in deciding the extreme outcomes.
 *
 *
 *
 *
 */
public class dailyDecision {

    public void makeDecision(){
        /*
            This method will create random events.
            Random generator will create a number between 1-3(4) which can be used towards a
            use-case to determine what the event will be.
            1. Situation decision
            2. Ration food decision
            3. Improvement upon base

            @pre: isDayTime()
            @post: decisionOutput()
         */
    }

    public static int decisionOutput(){
        /*
            For each event and by the wrong/right doing of the event, it will prompt the user a report card for
                each random event that occured. The scale is between 1-10(1 being the poorest, 10 being the greatest).
            This method will be need in goodOutput and badOutput methods.

            @pre: makeDecision()
            @post: goodOutput()
                    badOutput()
         */
    }

    public void goodOutput(int output){
        /*
            goodOutput will take decisionOutput as a parameter and use the number to reward the player.
            5 being the common item drop, 10 being the legendary item drop(the occurrence of legendary item drop will be significant low).
            A random number generator also be included in this method so will an algorithm that will take place determine the fairness of the random
            number generator.
         */
    }

    public void badOutput(int output){
        /*
            badOutput will take decisionOutput as a parameter and use the number to punish the player.
            1 being the worst punishment, 5 being the not so great punishment. With a punishment 1, handful of items will be taken from the character.
            5 only 1-2 items will be taken away from the character.
            A random number generator also be included in this method so will an algorithm that will take place determine the fairness of the random
            number generator.
         */
    }
}
