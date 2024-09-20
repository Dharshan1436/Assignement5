package assignment5.setInterfaceAndClass;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Set;

public class Program6 {
    
    
    public static  boolean isSubset(Set<Integer> setA, Set<Integer> setB) {
        return setB.containsAll(setA);
    }

    public static void main(String[] args) {
       
        Set<Integer> hashSetA = new HashSet<>();
        hashSetA.add(1);
        hashSetA.add(2);
        hashSetA.add(3);

        Set<Integer> hashSetB = new HashSet<>();
        hashSetB.add(1);
        hashSetB.add(2);
        hashSetB.add(3);
        hashSetB.add(4);

        
        System.out.println("HashSet: Is SetA a subset of SetB? " + isSubset(hashSetA, hashSetB));

       
        Set<Integer> linkedHashSetA = new LinkedHashSet<>();
        linkedHashSetA.add(1);
        linkedHashSetA.add(2);
        linkedHashSetA.add(3);

        Set<Integer> linkedHashSetB = new LinkedHashSet<>();
        linkedHashSetB.add(1);
        linkedHashSetB.add(2);
        linkedHashSetB.add(3);
        linkedHashSetB.add(4);

        
        System.out.println("LinkedHashSet: Is SetA a subset of SetB? " + isSubset(linkedHashSetA, linkedHashSetB));

        
        Set<Integer> treeSetA = new TreeSet<>();
        treeSetA.add(1);
        treeSetA.add(2);
        treeSetA.add(3);

        Set<Integer> treeSetB = new TreeSet<>();
        treeSetB.add(1);
        treeSetB.add(2);
        treeSetB.add(3);
        treeSetB.add(4);

        
        System.out.println("TreeSet: Is SetA a subset of SetB? " + isSubset(treeSetA, treeSetB));
    }
}
