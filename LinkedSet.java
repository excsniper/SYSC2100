import java.util.LinkedList;

/**
 * The LinkedSet class for a set of linked elements.
 * 
 * @author David Yao 100861054
 * @version 1.0
 */
public class LinkedSet<T> implements SetInterface<T>
{
    private LinkedList<T> mylist;

    /**
     * Constructor for objects of class LinkedSet
     */
    public LinkedSet()
    {        
        mylist = new LinkedList<T>();
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
        mylist.add(newEntry);
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
        return true;
    }

    /**
     * Removes an unspecified entry from this set. Decreases the number of
     * entries by 1.
     * 
     * @return either the entry if the removal was successful, or null
     */
    public T remove()
    {
        //return temp.elem;
        return null;
    }

    /** Removes all entries from this set. */
    public void clear()
    {

    }

    /**
     * Tests whether this set contains a given entry.
     * 
     * @param anEntry the object that is the desired entry
     * @return true if the set contains anEntry, or false if not
     */
    public boolean contains(T anEntry)
    {
        return true;
    }

    /**
     * Gets the size of this set.
     * 
     * @return the integer number of entries currently in the set
     */
    public int getCurrentSize()
    {
        return mylist.size();
    }

    /**
     * Sees whether this set is empty.
     * 
     * @return true if the set is empty, or false if not
     */
    public boolean isEmpty()
    {
        return true;
    }

    /**
     * Sees whether this set is full.
     * 
     * @return true if the set is full, or false if not
     */
    public boolean isFull()
    {
        return true;
    }

    /**
     * Retrieves all entries that are in this set.
     * 
     * @return a newly allocated array of all the entries in the set
     */
    public T[] toArray()
    {
        return null;
    }
    
    /** 
     * merge the current set with a second set.
     * 
     * @param anotherSet the set to be merged with the current set 
     * @return union of the two sets
     */
     public SetInterface<T> union(SetInterface<T> anotherSet)
     {
         return null;
     }
     
    /** 
     * form the intersection of the current set with a second set.
     * 
     * @param anotherSet the set to intersect with the current set 
     * @return intersection of the two sets
     */
     public SetInterface<T> intersection(SetInterface<T> anotherSet)
     {
         return null;
     }
    
    /** 
     * Perform a set difference.
     * 
     * @param anotherSet the set to be subtracted from the current set 
     * @return current set minus anotherSet
     */
     public SetInterface<T> difference(SetInterface<T> anotherSet)
     {
         return null;
     }
}
