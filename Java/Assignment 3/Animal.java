 
/**
 * parent class Animal (top of hierarchy, also abstract) 
 *
 * @author (Maria Henehan)
 * @version (22/11/2020)
 */
public abstract class Animal
{
    boolean hasSkin;
    boolean breathes;
    String colour;
    
    /**
     * Constructor for objects of class Animal
     */
    public Animal()
    {
        breathes = true; //all animals breathe
        hasSkin = true; //all animals have skin
        colour = "grey"; //default colour of animals is set to grey
    }

    /**
     * move method
     */
    public void move(int distance)
    {
        System.out.printf("I move %d metres \n", distance); 
    }    
    
    /**
     * eat method
     */
    public void eats()
    {
        System.out.println("I eat.");
    }
}
