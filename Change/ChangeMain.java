import java.util.Scanner;

/**
 * A recursive program to calculate the number of ways to form change.
 * 
 * @author David Yao 100861054
 * @version 1.0
 */
public class ChangeMain
{
    /**
     * A recurrsive function to calculata the number of differnt ways to form change.
     * 
     * @param n The amount to calculate change for
     * @param pf The previous factor aka parent factor
     * @return The number of ways to form change
     */
    static private int calcWays(int n, int pf)
    {
        // this is kind of like a factoring problem...
        
        // if the amount is less than 5 then there's only one way
        if (n < 5) return 1;
        
        // for any factor, the missing amount can be filled with pennies so it counts as one way
        int sum = 1;
        
        // the parent factor is there to prevent duplications from the permutation
        // only take away 25 if the amount is greater or equal to than 25
        if (n >= 25 && pf >= 25) 
            sum += calcWays(n-25, 25); // calculate the number of ways at this level by combinding the current number with the number from the level(s) below it
                                       // pass the current factor so the next round of recurrsion doesn't try to factor a number greater than the current factor
                                       // thus preventing duplications
                                       // same principles below
                                       
        if (n >= 10 && pf >= 10)
            sum += calcWays(n-10, 10);
            
        if (n >= 5 && pf >= 5) 
            sum += calcWays(n-5, 5);
        
        return sum;            
    }

    /**
     * The main method for the program
     */
    public static void main(String args[])
    {
        Scanner myscanner = new Scanner(System.in);
        
        // A loop for multiple queries
        while(true)
        {
            System.out.print("Enter a value to be calculated. To quit, enter 0: ");
            String input = myscanner.nextLine();
            if (input.equals("0")) break; // user wants to end the program
            
            System.out.print("Number of ways that " + input + " can be changed into coins is " + calcWays(Integer.parseInt(input), 25) + ".\n\n"); // output results.
        }
    }
}
