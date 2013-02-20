import java.util.*;

public class StackChangeMain 
{
	/**
	 * A method to calculate the amount of different ways to form change without recursion.
	 * However, it will use stacks.
	 * 
	 * @param amount the amount to be calculated
	 * @return number of ways
	 */
	
	private class Level
	{
		public int amount;
		public int pf;
		
		public Level(int amount, int pf)
		{
			this.amount = amount;
			this.pf = pf;
		}
		
		public String toString()
		{
			return "[" + amount + ", " + pf + "]";
		}
	}
	
	private int calcWays(int amount)
	{
		//stack of ints
		LinkedListPureStack mystack = new LinkedListPureStack();
		int sum = 0;		
		int currentBranch = 5;
		
		mystack.push(new Level(amount, 25));
		while(!mystack.isEmpty())	
		{
			Level tempLevel = (Level) mystack.peek();
			if (tempLevel.amount < 5)
				while(tempLevel.pf ==5)
					mystack.pop();		
			
			if (tempLevel.amount > 25 && ((Level) mystack.peek()).pf >= 25)
			{
				mystack.push(new Level(tempLevel.amount-25, 25));
				continue;
			}	
			if (tempLevel.amount > 10 && ((Level) mystack.peek()).pf >= 10)
			{
				mystack.push(new Level(tempLevel.amount-10, 10));
				continue;
			}
			if (tempLevel.amount > 5 && ((Level) mystack.peek()).pf >= 5)
			{
				mystack.push(new Level(tempLevel.amount-5, 5));
				continue;
			}

			
			System.out.println(mystack);
			
			sum++;	
			 
			
			
		}
		

		
		
		
		
		
	
		return sum + 1;                                                         
	}
	
	/**
	 * Main method for the assignment.
	 * The UI here is taken from assignment 1.
	 */
	public static void main(String[] args) 
	{
		StackChangeMain mymain = new StackChangeMain();
        Scanner myscanner = new Scanner(System.in);
        
        // A loop for multiple queries
        //while(true)
        {
            System.out.print("Enter a value to be calculated. To quit, enter 0: ");
            int input = myscanner.nextInt();
            //if (input == 0) break; // user wants to end the program
            
            System.out.print("Number of ways that " + input + " can be changed into coins is " + mymain.calcWays(input) + ".\n\n"); // output results.
        }
        
        //deallocate the scanner to suppress warning
        myscanner.close();
	}
}
