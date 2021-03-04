
/**
 * Class with fields + methods for all canaries
 * Inherits from parent class bird
 *
 * @author (Maria Henehan)
 * @version (22/11/2020)
 */
public class Canary extends Bird
{
    String name;
    /**
     * Constructor for objects of class Canary
     */
    public Canary(String name)
    {
        super();
        this.name = name;
        colour = "yellow";
    }
    
    @Override
    public void sing()
    {
        System.out.println("tweet tweet tweet");
    }
    
    /**
     * toString method
     * puts all of the attributes of a Canary object into a string and returns the string 
     */
    @Override
    public String toString()
    {
        String strng ="";
        strng+= "Canary; ";
        strng+= "name: ";
        strng+= name;
        strng+= "; ";
        strng+= "colour: ";
        strng+= colour;
        strng+= "; ";
        strng+= "has wings: ";
        strng+= hasWings();
        strng+= "; ";
        strng+= "has feathers: ";
        strng+= hasFeathers;
        strng+= "; ";
        strng+= "flies: ";
        strng+= flies;
        strng+= "\n";
        // TOD0 Your job is to include the fields and attributes inherited 
        //from Bird and Animal in the String representation
        return strng;
    }
    
    /**
     * equals method
     * checks that the object passed into the method is not null, is an instance of
     * the canary class, and if it is, checks to see if they have the same name as all
     * other canary parameters are the same
     */
    @Override
    public boolean equals(Object obj){
        //TODO : You have to define an equals method for this class
        if(obj == null)
        {
            return false;
        }
        
        if(obj instanceof Canary)
        {
            Canary canary = (Canary)obj;
            if(this.name == canary.name)
            {
                return true;
            }
            
        }
        return false; //default equals
    }
    
    @Override
    public void eats()
    {
        System.out.println("I eat seeds.");
    }
    
    @Override // good programming practice to use @Override to denote overridden methods
    public void move(int distance)
    {
        System.out.printf("I fly %d metres", distance);
    }
}
