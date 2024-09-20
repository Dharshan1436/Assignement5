package assignment5.setInterfaceAndClass;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;


public class Program2 {

    public static LinkedHashSet<String> removeDuplicates(List<String> list) {
        return new LinkedHashSet<>(list);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("apple");
        list.add("orange");

        LinkedHashSet<String> result = removeDuplicates(list);

        System.out.println(result);
    }
}
