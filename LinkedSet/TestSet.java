
/**
 * Write a description of class TestSet here.
 * 
 * @author David Yao 100861054
 * @version 1.0
 */
public class TestSet
{    
    public static void main(String arugs[])
    {
        LinkedSet<Integer> set1 = new LinkedSet<Integer>(10);
        LinkedSet<Integer> set2 = new LinkedSet<Integer>(10);
        
        //Adding numbers 1 2 3 into set1
        set1.add(1);
        set1.add(2);
        set1.add(3);
        
        //Adding numbers 2 3 4 into set1
        set2.add(2);
        set2.add(3);
        set2.add(4);
        
        System.out.print("set1: ");
        printSet(set1);
        System.out.print("set2: ");
        printSet(set2);
        
        System.out.print("\ntry to add 1 into set1... ");
        System.out.println(set1.add(1));
        
        System.out.print("\ntry to remove 4 from set1... ");
        System.out.println(set1.remove(4));
        
        System.out.print("\ntry to remove 1 from set1... ");
        System.out.println(set1.remove(1));
        System.out.print("set1: ");
        printSet(set1);
        
        System.out.print("\ntry to remove from set1... ");
        System.out.println(set1.remove());
        System.out.print("set1: ");
        printSet(set1);
        System.out.print("set1's current size is... ");
        System.out.println(set1.getCurrentSize());        
        System.out.print("is set1 empty... ");
        System.out.println(set1.isEmpty());       
        
        System.out.println("\ntry to clear set1... ");
        set1.clear();
        System.out.print("set1: ");
        printSet(set1);
        System.out.print("set1's current size is... ");
        System.out.println(set1.getCurrentSize());
        System.out.print("is set1 empty... ");
        System.out.println(set1.isEmpty()); 
        
        System.out.println("\nadd 1 3 back into set1... ");
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.print("set1: ");
        printSet(set1);  
        
        System.out.println("\ndoes set1 contain 1... ");
        System.out.println(set1.contains(1));
        
        
    }
    
    public static void printSet(LinkedSet set)
    {
        int setLength = set.getCurrentSize();
        Object[] array = new Object[setLength];
        array = set.toArray();
        
        for (int i=0; i<setLength; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
