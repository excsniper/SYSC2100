
public class SearchArray<T>
{
	/**
	 * A tail-recursive search method with O(n) efficiency for internal use.
	 * row, col are the indices of the cell to be checked.
	 */
	private static <T extends Comparable<? super T>> boolean doSearch(T[][] data, T desiredItem, int row, int col)
	{	
		// base case: if we reach the edge if the array and the item still hasn't been found then it's not in the array
		if (row == data.length || col < 0)
			return false;
		
		// return true if the item is found in the current cell
		if (data[row][col].compareTo(desiredItem) == 0)
			return true;

		// if the current cell is less than the item, we can eliminate the whole row and move one row down
		if (data[row][col].compareTo(desiredItem) < 0)
			return doSearch(data, desiredItem, row+1, col);
		else // otherwise the cell must be greater than the item and we start looking one col left
			return doSearch(data, desiredItem, row, col-1);
	}
	
	/** 
	 * Finds an object in a 2D array where data in each row and in each column is sorted in increasing order.
	 * @param data a 2D array of Comparable objects
	 * @param desiredItem what we are searching for 
	 * @return true if the desired item is found in the array 
	*/
	public static <T extends Comparable<? super T>>	boolean search(T[][] data, T desiredItem)
	{
		// check if the item is less than the top left or greater than bottom right...
		if (data[0][0].compareTo(desiredItem) > 0 || data[data.length-1][data[0].length-1].compareTo(desiredItem) < 0)
			return false; // ...if so then we can conclude that the item isn't in the array
					
		return doSearch(data, desiredItem, 0, data[0].length-1); // run the recursive search method starting from the top right
	}
	
	/** 
	 * A brute-force, inefficient search used merely to check the correctness of our more efficient search. 
	 */
	public static <T extends Comparable<? super T>>	boolean bruteForceSearch(T[][] data, T desiredItem)
	{
		for(int r=0; r < data.length; r++)
		{
			for(int c=0; c < data[r].length; c++)
			{
				// check every row and col and only return true if item has been found
				if (data[r][c].compareTo(desiredItem) == 0)
					return true;
			}
		}
		
		// otherwise return false
		return false;
	}
}
