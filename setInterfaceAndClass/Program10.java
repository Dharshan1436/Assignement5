package assignment5.setInterfaceAndClass;

import java.util.Iterator;
import java.util.TreeSet;

public class Program10 {

    private static void removeElements(TreeSet<Integer> set, int threshold) {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int x = iterator.next();
            if (x < threshold) {
                iterator.remove(); 
            }
        }
    }

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        int threshold = 3;
        
        System.out.println("Original set: " + set);
        removeElements(set, threshold);
        System.out.println("Modified set: " + set);
    }
}
