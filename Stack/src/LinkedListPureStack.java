
public class LinkedListPureStack implements PureStack
{
	
	private int size;
	private Node topNode;
	
	/**
     * A private Node class for the linked list.
     * This bit is salvaged from assignment 2.
     */
    private class Node
    {
        public Object elem;
        public Node next;
        
        public Node(Object elem, Node next)
        {
            this.elem = elem;
            this.next = next;
        }
    }
    
    public LinkedListPureStack()
    {
    	size = 0;
    }
    
	@Override
	public int size()
	{
		return size;
	}

	@Override
	public boolean isEmpty()
	{		
		return size == 0;
	}

	@Override
	public void push(Object element)
	{
		topNode = new Node(element, topNode);	//pushing by setting the new node as the top node and adding a link to the
												//previous top node
		size++;									//increasing the size counter
	}	

	@Override
	public Object pop()
	{
		Node temp = topNode;		//saving a reference to the top node before poping
		topNode = topNode.next;		//moving the top note ref down
		size--;						//decreasing the size counter
		return temp.elem;			//returning the element of the popped node; it will be freed at the end of this func block
	}

	@Override
	public Object peek()
	{		
		return topNode.elem;	
	}
	
	public void clear()
	{
		topNode = null;		//freeing the linked list by setting the only ref to it to null
		size = 0;
	}
	
	/**
	 * A toString for debugging
	 */	
	public String toString()
	{
		String tempStr = "";
		Node tempNode = topNode;
		
		for (int i=0; i<size; i++)			//print out all the nodes in the linked list stack with a loop
		{
			tempStr += tempNode.elem + " ";
			tempNode = tempNode.next;
		}
		return tempStr;
	}
}
