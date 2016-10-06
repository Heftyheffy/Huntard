/*
    A resource is an attribute of the base that needs to be maintained if the
    player wishes to survive. The resources inclue things like food and water.
    There will be many scenarios in the game where a resource is either used or
    gained. When the game is started the resources will be attributed to the
    base.
*/

public class Resource{

    /*
        current amount of the resource
    */
    private int amount;

    /*
    When the game is atarted the player will get a random amount of each resource.
    The random number will be generated outside the object and passed as part of
    the constructor.
    */
    public Resource(int x)

    /*
        increase amount if resource is acquired
    */
    public void gainResource (int x)

    /*
        decrease amount when resource is used or lost
    */
    public void loseResource(int x)

    /*
        return amount of the resource available
    */
    public int getAmount(int x);

    /*
        set the amount of resource available
    */
    public void setAmount(int x);
}
