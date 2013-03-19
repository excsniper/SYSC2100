
public class SearchArray<T>
{
	
	/**
	 * 
	 */
	private static <T extends Comparable<? super T>> boolean doSearch(T[][] data, T desiredItem, int row, int col)
	{		
		if (row == data.length || col < 0)
			return false;
		
		if (data[row][col].compareTo(desiredItem) == 0)
			return true;

		if (data[row][col].compareTo(desiredItem) < 0)
			return doSearch(data, desiredItem, row+1, col);
		else
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
		if (data[0][0].compareTo(desiredItem) > 0 || data[data.length-1][data[0].length-1].compareTo(desiredItem) < 0)
			return false;
					
		return doSearch(data, desiredItem, 0, data[0].length-1);
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
				if (data[r][c].compareTo(desiredItem) == 0)
					return true;
			}
		}
		
		return false;
	}
}
