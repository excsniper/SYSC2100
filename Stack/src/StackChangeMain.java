import java.util.*;

public class StackChangeMain 
{

	/**
	 * Main method for the assignment.
	 * The UI here is taken from assignment 1.
	 */
	public static void main(String[] args) 
	{
		LinkedListPureStack mystack = new LinkedListPureStack();
        Scanner myscanner = new Scanner(System.in);
        
        // A loop for multiple queries
        while(true)
        {
            System.out.print("Enter a value to be calculated. To quit, enter 0: ");
            String input = myscanner.nextLine();
            if (input.equals("0")) break; // user wants to end the program
            
            //System.out.print("Number of ways that " + input + " can be changed into coins is " + calcWays(Integer.parseInt(input), 25) + ".\n\n"); // output results.
        }

	}

}
