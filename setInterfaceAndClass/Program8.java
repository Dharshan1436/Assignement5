package assignment5.setInterfaceAndClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Program8 {

    public static Set<Integer> intersection(List<Set<Integer>> sets) {
        if (sets == null || sets.isEmpty()) {
            return new HashSet<>(); 
        }

       
        Set<Integer> result = new HashSet<>(sets.get(0));


        for (int i = 1; i < sets.size(); i++) {
            result.retainAll(sets.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(5);
        Set<Integer> set2 = new HashSet<>();
        
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
       
        Set<Integer> set3 = new HashSet<>();
        set3.add(3);
        set3.add(4);
        set3.add(5);
        set3.add(5);
        List<Set<Integer>> sets =new  ArrayList<Set<Integer>>();
        sets.add(set1);
        sets.add(set2);
        sets.add(set3);
        Set<Integer> intersection = intersection(sets);

        System.out.println("Intersection: " + intersection); 
    }
}
