
/**
 * Class with fields and methods for Shark objects
 * Inherits from Fish parent class
 *
 * @author (Maria Henehan)
 * @version (22/11/2020)
 */
public class Shark extends Fish
{
    boolean bites;
    boolean dangerous;
    String name;
    /**
     * Constructor for objects of class Shark
     */
    public Shark(String name)
    {
        super();
        this.name = name;
        colour = "grey";
        bites = true;
        dangerous = true;
    }
    
    /**
     * toString method
     * puts all of the attributes of a Shark object into a string and returns the string 
     */
    @Override
    public String toString()
    {
        String strng ="";
        strng+= "Shark; ";
        strng+= "name: ";
        strng+= name;
        strng+= "; ";
        strng+= "colour: ";
        strng+= colour;
        strng+= "; ";
        strng+= "bites: ";
        strng+= bites;
        strng+= "; ";
        strng+= "is dangerous: ";
        strng+= dangerous;
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
     * the shark class, and if it is, checks to see if they have the same name as all
     * other shark parameters are the same
     */
    @Override
    public boolean equals(Object obj){
        //TODO : You have to define an equals method for this class
        if(obj == null)
        {
            return false;
        }
        
        if(obj instanceof Shark)
        {
            Shark shark = (Shark)obj;
            if(this.name == shark.name)
            {
                return true;
            }
            
        }
        return false; //default equals
    }
    
    @Override
    public void eats()
    {
        System.out.println("I eat smaller fish.");
    }
}
