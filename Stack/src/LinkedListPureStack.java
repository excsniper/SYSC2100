
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
		topNode = new Node(element, topNode);
		size++;
	}

	@Override
	public Object pop()
	{
		Node temp = topNode;
		topNode = topNode.next;
		size--;
		return temp.elem;
	}

	@Override
	public Object peek()
	{		
		return topNode.elem;
	}
	
	public void clear()
	{
		topNode = null;
		size = 0;
	}
	
	public String toString()
	{
		String tempStr = "";
		Node tempNode = topNode;
		
		for (int i=0; i<size; i++)
		{
			tempStr += tempNode.elem + " ";
			tempNode = tempNode.next;
		}
		return tempStr;
	}
}
