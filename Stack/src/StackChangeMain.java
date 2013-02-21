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
		public int next;
		
		public Level(int amount, int next)
		{
			this.amount = amount;
			this.next = next;
		}
		
		public String toString()
		{
			return "[" + amount + ", " + next + "]";
		}
	}
	
	private int getNext(int next)
	{
		if(next == 25)
			return 10;
		else
			return 5;
	}
	
	private int calcWays(int amount)
	{
		//stack of ints
		LinkedListPureStack mystack = new LinkedListPureStack();
		int sum = 0;
		
		mystack.push(new Level(amount, 25)); 	//start taking away 25 cents
		while(true)	
		{	
			if( ((Level) mystack.peek()).amount < 5)
			{
				//System.out.println("------------------------------");
				while( ((Level) mystack.peek()).next == 5)
				{
					mystack.pop();
					if (mystack.isEmpty())
						break;
				}

				if(!mystack.isEmpty())
					((Level) mystack.peek()).next = getNext( ((Level) mystack.peek()).next);
				else
					break;
			}
			
			Level tempLevel = (Level) mystack.peek();
			if(tempLevel.amount >= tempLevel.next)
			{
				mystack.push(new Level(tempLevel.amount-tempLevel.next, tempLevel.next));
				sum++;
			}
			else
			{
				tempLevel.next = getNext(tempLevel.next);
			}
			//System.out.println(mystack);	
			
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
