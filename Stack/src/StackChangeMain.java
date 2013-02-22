import java.util.*;

public class StackChangeMain 
{

	/**
	 * 
	 * A private class to keep track of the params at each levels 
	 *
	 */
	private class Level
	{
		public int amount;	//the amount to be calculated
		public int next;	//the type of coin to take away in the next level
		
		public Level(int amount, int next)
		{
			this.amount = amount;
			this.next = next;
		}
		
		//A toString method for debugging
		public String toString()
		{
			return "[" + amount + ", " + next + "]";
		}
	}
	
	//A private method to move on to the next coin
	private int getNext(int next)
	{
		if(next == 25)
			return 10;
		else
			return 5;
	}	
	
	/**
	 * A method to calculate the amount of different ways to form change without recursion.
	 * 
	 * WARNING: This method does not take into consideration that the Canadian government no longer accepts pennies in their currency
	 * 
	 * @param amount the amount to be calculated
	 * @return number of ways
	 */
	private int calcWays(int amount)
	{
		//stack of ints
		LinkedListPureStack mystack = new LinkedListPureStack();
		int sum = 0;	//keeps track of the number of ways
		
		mystack.push(new Level(amount, 25)); 	//start taking away 25 cents
		while(true)		//This loop will be 'broken' in the middle 
		{	
			if( ((Level) mystack.peek()).amount < 5)	//if the amount at the moment is less than a nickel (5 cents)
			{
				while( ((Level) mystack.peek()).next == 5)	//keep popping the stack until the next coin used for deduction
															//is no longer a nickel
				{
					mystack.pop();
					if (mystack.isEmpty())					//the loop is done when the stack is empty
						break;
				}

				if(!mystack.isEmpty())						//if the stack is not empty, change up the coins
					((Level) mystack.peek()).next = getNext( ((Level) mystack.peek()).next);
				else
					break;
			}
			
			Level tempLevel = (Level) mystack.peek();
			if(tempLevel.amount >= tempLevel.next)		//if the amount can be deducted by the coin...
			{
				mystack.push(new Level(tempLevel.amount-tempLevel.next, tempLevel.next)); 	//do so and push it in the stack.
				sum++;		//increase the counter for the number of ways.
			}
			else
			{
				tempLevel.next = getNext(tempLevel.next);	//if the amount cannot be deducted, change up the coin
			}
			//System.out.println(mystack);	USE TO DEBUG
			
		}
		
		return sum + 1;			//adding 1 to the sum accounts for the case where the change is made entirely out of pennies.
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
        while(true)
        {
            System.out.print("Enter a value to be calculated. To quit, enter 0: ");
            int input = myscanner.nextInt();
            if (input == 0) break; // user wants to end the program
            
            System.out.print("Number of ways that " + input + " can be changed into coins is " + mymain.calcWays(input) + ".\n\n"); // output results.
        }
        
        //deallocate the scanner to suppress warning
        myscanner.close();
	}
}
