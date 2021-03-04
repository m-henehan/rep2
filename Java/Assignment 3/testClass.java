
/**
 * Test class for the two tests
 *
 * @author (Maria Henehan)
 * @version (22/11/2020)
 */
public class testClass
{
    public static void main (String args[])
    {
       testClass test = new testClass();
       //test.test1();
       test.test2();
    }
    
    /**
     * test1 method
     * prints out an array of the toString() of each object 
     */
    public void test1()
    {
        Animal[] animals = new Animal[4];        
        animals[0] = new Canary("Liam");
        animals[1] = new Ostrich("Harry");
        animals[2] = new Shark("Louis");
        animals[3] = new Trout("Niall");
        
        for(int i=0; i<animals.length; i++)
        {
            System.out.println(animals[i]);
        }
    }
    
    /**
     * test2 method
     * uses nested for and if loops to check if two array entries are the same, then prints them and their place in the array out
     */
    public void test2()
    {
        Animal[] animals = new Animal[9];
        animals[0] = new Canary("Zayn");
        animals[1] = new Ostrich("Liam");
        animals[2] = new Shark("Liam");
        animals[3] = new Trout("Niall");
        animals[4] = new Canary("Zayn");
        animals[5] = new Ostrich("Harry");
        animals[6] = new Shark("Louis");
        animals[7] = new Shark("Louis");
        animals[8] = new Ostrich("Liam");
        int i = 0;
        int j = 0;
        
        for(i=0; i<animals.length; i++)
        {
            for(j = animals.length -1; j>=0; j--)
            {
                if(animals[i].equals(animals[j]) && i!=j)
                {
                    System.out.print(animals[i]);
                    System.out.printf("Place in animals array: %d \n", i);
                }
            }
        }
    }
}

