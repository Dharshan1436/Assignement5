package assignment5.ListInterface_Queue;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    @SuppressWarnings("unused")
	private final int capacity;
    private final Map<Integer, Integer> cache;
    
    @SuppressWarnings("serial")
	public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}

public class Program3 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); 
        lruCache.put(3, 3); 
        System.out.println(lruCache.get(2)); 
        lruCache.put(4, 4); 
        System.out.println(lruCache.get(1)); 
        System.out.println(lruCache.get(3)); 
        System.out.println(lruCache.get(4)); 
    }
}
