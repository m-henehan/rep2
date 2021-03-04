
/**
 * Class with fields and methods for objects of type Trout
 * Inherits from Fish parent class
 *
 * @author (Maria Henehan)
 * @version (22/11/2020)
 */
public class Trout extends Fish
{
    boolean edible;
    String layEggs;
    String name;
    /**
     * Constructor for objects of class Trout
     */
    public Trout(String name)
    {
        super();
        this.name = name;
        colour = "brown";
        edible = true;
        layEggs = "upriver";
    }
    
    /**
     * toString method
     * puts all of the attributes of a Trout object into a string and returns the string 
     */
    @Override
    public String toString()
    {
        String strng ="";
        strng+= "Trout; ";
        strng+= "name: ";
        strng+= name;
        strng+= "; ";
        strng+= "colour: ";
        strng+= colour;
        strng+= "; ";
        strng+= "edible: ";
        strng+= edible;
        strng+= "; ";
        strng+= "where it lays eggs: ";
        strng+= layEggs;
        strng+= "; ";
        strng+= "has fins: ";
        strng+= hasFins;
        strng+= "; ";
        strng+= "has gills: ";
        strng+= hasGills;
        strng+= "; ";
        strng+= "swims: ";
        strng+= swims;
        strng+= "\n";
        // TOD0 Your job is to include the fields and attributes inherited 
        //from Bird and Animal in the String representation
        return strng;
    }
    
    /**
     * equals method
     * checks that the object passed into the method is not null, is an instance of
     * the trout class, and if it is, checks to see if they have the same name as all
     * other trout parameters are the same
     */
    @Override
    public boolean equals(Object obj){
        //TODO : You have to define an equals method for this class
        if(obj == null)
        {
            return false;
        }
        
        if(obj instanceof Trout)
        {
            Trout trout = (Trout)obj;
            if(this.name == trout.name)
            {
                return true;
            }
            
        }
        return false; //default equals
    }
    
    @Override
    public void eats()
    {
        System.out.println("I eat insects.");
    }
}
