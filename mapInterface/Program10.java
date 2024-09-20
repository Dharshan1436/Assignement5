package assignment5.mapInterface;
import java.util.HashMap;
import java.util.ArrayList;

public class Program10 {

    public static ArrayList<Integer> findIntersection(int[] array1, int[] array2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> intersection = new ArrayList<>();

        for (int num : array1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int num : array2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                intersection.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        return intersection;
    }
    public static void main(String[] args) {
        int[] array1 = {1, 2, 2, 3, 4};
        int[] array2 = {2, 2, 4, 5};
        ArrayList<Integer> result = findIntersection(array1, array2);
        
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

}
