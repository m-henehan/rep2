
/**
 * Abstract Fish parent class
 * Contains fields and methods for fish
 *
 * @author (Maria Henehan)
 * @version (22/11/2020)
 */
public abstract class Fish extends Animal
{
    boolean swims;
    boolean hasFins;
    boolean hasGills;
    /**
     * Constructor for objects of class Fish
     */
    public Fish()
    {
        super();
        swims = true;
        hasFins = true;
        hasGills = true;
        colour = "blue";
    }
    
    /**
     * overrides the move method to make it about swimming
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public void move(int distance)
    {
        if(swims = true)
        {
            System.out.printf("I swim %d metres \n", distance);
        }
        
        else
        {
            System.out.printf("I am a fish who can't swim, so I must be dead");
        }
    }
}
