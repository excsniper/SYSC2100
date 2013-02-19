
/**
 * The LinkedSet class for a set of linked elements.
 * 
 * @author David Yao 100861054
 * @version 1.0
 */
public class LinkedSet<T> implements SetInterface<T>
{
    //private Node firstNode;
    private Node lastNode;
    private Node temp;
    private int maxSize;
    private int length;

    /**
     * A private Node class for the linked set.
     */
    private class Node
    {
        public T elem;
        public Node next;
        
        public Node(T elem, Node next)
        {
            this.elem = elem;
            this.next = next;
        }
    }

    /**
     * Constructor for objects of class LinkedSet
     * Default maxSize = 10
     */
    public LinkedSet()
    {        
        length = 0;
        maxSize = 10;
    }

   /**
     * Constructor for objects of class LinkedSet
     * @param maxSize The max number of elements this set can hold
     */
    public LinkedSet(int maxSize)
    {        
        length = 0;
        this.maxSize = maxSize;
    }    
    
     /**
     * Adds a new entry to this set, avoiding duplicates. Increases the number
     * of entries by 1.
     * 
     * @param newEntry the object to be added as a new entry
     * @return true if the addition is successful, or false if the item already is in the set
     */
    public boolean add(T newEntry)
    {
        if (length == maxSize) 
            return false;
        
        if (contains(newEntry)) 
            return false;

        if (lastNode == null)
            lastNode = new Node(newEntry, null);

        else
            lastNode = new Node(newEntry, lastNode);           
            
        length++;
        return true;
    }

    /**
     * Removes a specific entry from this set. Decreases the number of entries
     * by 1.
     * 
     * @param anEntry the object to be removed
     * @return true if the removal was successful, or false if not
     */
    public boolean remove(T anEntry)
    {
        if (lastNode == null)
            return false;
        
        Node prevtemp = null;
        temp = lastNode;
        while (temp != null)
        {
            if (temp.elem == anEntry)
            {
                if (prevtemp != null)
                    prevtemp.next = temp.next;
                else
                    lastNode = temp.next;
                
                length--;
                return true;
            }
            prevtemp = temp;
            temp = temp.next;
        } 
        return false;
    }

    /**
     * Removes an unspecified entry from this set. Decreases the number of
     * entries by 1.
     * 
     * @return either the entry if the removal was successful, or null
     */
    public T remove()
    {
        if (lastNode == null)
            return null;        
        
        temp = lastNode;
        lastNode = lastNode.next;
        length--;
        return temp.elem;
    }

    /** Removes all entries from this set. */
    public void clear()
    {
        lastNode = null;
        length = 0;
    }

    /**
     * Tests whether this set contains a given entry.
     * 
     * @param anEntry the object that is the desired entry
     * @return true if the set contains anEntry, or false if not
     */
    public boolean contains(T anEntry)
    {
        temp = lastNode;
        while (temp != null)
        {
            if (temp.elem == anEntry)
                return true;
            temp = temp.next;
        }
        return false;
    }

    /**
     * Gets the size of this set.
     * 
     * @return the integer number of entries currently in the set
     */
    public int getCurrentSize()
    {
        return length;
    }

    /**
     * Sees whether this set is empty.
     * 
     * @return true if the set is empty, or false if not
     */
    public boolean isEmpty()
    {
        return length == 0;
    }

    /**
     * Sees whether this set is full.
     * 
     * @return true if the set is full, or false if not
     */
    public boolean isFull()
    {
        return length == maxSize;
    }

    /**
     * Retrieves all entries that are in this set.
     * 
     * @return a newly allocated array of all the entries in the set
     */
    public T[] toArray()
    {
        @SuppressWarnings({"unchecked"})
        T[] tempArray = (T[]) new Object[length];
        temp = lastNode;
        for (int i=0; i<length; i++)
        {
            tempArray[i] = temp.elem;
            temp = temp.next;
        }
        return tempArray;
    }
    
    /** 
     * merge the current set with a second set.
     * 
     * @param anotherSet the set to be merged with the current set 
     * @return union of the two sets
     */
     public SetInterface<T> union(SetInterface<T> anotherSet)
     {
        LinkedSet<T> tempSet = new LinkedSet<T>(length + anotherSet.getCurrentSize());
        LinkedSet<T> another = (LinkedSet<T>) anotherSet;
        
        temp = lastNode;
        while (temp != null)
        {
            tempSet.add(temp.elem);
            temp = temp.next;
        }
        
        temp = another.lastNode;
        while (temp != null)
        {
            tempSet.add(temp.elem);
            temp = temp.next;
        }
        return tempSet;
     }
     
    /** 
     * form the intersection of the current set with a second set.
     * 
     * @param anotherSet the set to intersect with the current set 
     * @return intersection of the two sets
     */
     public SetInterface<T> intersection(SetInterface<T> anotherSet)
     {
        SetInterface<T> tempSet = new LinkedSet<T>(length);   
        temp = lastNode;
        while (temp != null)
        {
            if (anotherSet.contains(temp.elem))
                tempSet.add(temp.elem);
            temp = temp.next;
        }
         return tempSet;
     }
    
    /** 
     * Perform a set difference.
     * 
     * @param anotherSet the set to be subtracted from the current set 
     * @return current set minus anotherSet
     */
     public SetInterface<T> difference(SetInterface<T> anotherSet)
     {
        SetInterface<T> tempSet = new LinkedSet<T>(length);   
        temp = lastNode;
        while (temp != null)
        {
            if (!anotherSet.contains(temp.elem))
                tempSet.add(temp.elem);
            temp = temp.next;
        }
         return tempSet;
     }
}
