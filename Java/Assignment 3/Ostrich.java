
/**
 * Class with fields + methods for ostriches
 * Inherits from parent class Bird
 *
 * @author (Maria Henehan)
 * @version (22/11/2020)
 */
public class Ostrich extends Bird
{
    String name;
    String height;
    String legs;
    /**
     * Constructor for objects of class Ostrich
     */
    public Ostrich(String name)
    {
       super();
       this.name = name;
       height = "tall";
       flies = false;
       legs = "long + thin";
    }
    
    /**
     * toString method
     * puts all of the attributes of an Ostrich object into a string and returns the string 
     */
    @Override
    public String toString()
    {
        String strng ="";
        strng+= "Ostrich; ";
        strng+= "name: ";
        strng+= name;
        strng+= "; ";
        strng+= "colour: ";
        strng+= colour;
        strng+= "; ";
        strng+= "height: ";
        strng+= height;
        strng+= "; ";
        strng+= "legs: ";
        strng+= legs;
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
     * the ostrich class, and if it is, checks to see if they have the same name as all
     * other ostrich parameters are the same
     */
    @Override
    public boolean equals(Object obj){
        //TODO : You have to define an equals method for this class
        if(obj == null)
        {
            return false;
        }
        
        if(obj instanceof Ostrich)
        {
            Ostrich ostrich = (Ostrich)obj;
            if(this.name == ostrich.name)
            {
                return true;
            }
            
        }
        return false; //default equals
    }
    
    @Override
    public void eats()
    {
        System.out.println("I eat plants mainly.");
    }
    
    /**
     * overrides the move method to check if bird can fly before deciding which to use
     * I couldn't get it to work
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public void move(int distance)
    {
        System.out.printf("I cannot fly so I walk %d metres", distance);
    }
}
