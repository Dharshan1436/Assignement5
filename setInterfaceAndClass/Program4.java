package assignment5.setInterfaceAndClass;

import java.util.TreeSet;

public class Program4 {
    
    private static TreeSet<Integer> getUniqueElementsSorted(int[] input) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int data : input) {
            set.add(data); 
        }
        return set;
    }

    public static void main(String[] args) {
        int[] input = {7, 2, 9, 1, 2, 9}; 
        TreeSet<Integer> result = getUniqueElementsSorted(input);
        System.out.println("Unique elements sorted in ascending order: " + result);
    }
}
