
/**
 * Abstract parent class Bird
 * contains fields + methods for all birds
 *
 * @author (Maria Henehan)
 * @version (22/11/2020)
 */
public abstract class Bird extends Animal
{
    boolean hasFeathers;
    boolean hasWings;
    boolean flies;
    /**
     * Constructor for objects of class Bird
     */
    public Bird()
    {
        super();
        hasFeathers = true;
        hasWings = true;
        flies = true;
        colour = "black";
    }
    
    /**
     * basic sing method
     */
    public void sing()
    {
        System.out.println("tra la la la");
    }
    
    /**
     * overrides the move method to make it about flying or walking, checks if bird can fly before deciding which to use
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public abstract void move(int distance);

    /**
     * 'getter' method for the hasWings field
     */
    public boolean hasWings()
    {
        return hasWings;
    }
    
    /**
     * 'getter' method for the hasFeathers field
     */
    public boolean hasFeathers()
    {
        return hasFeathers;
    }
}
