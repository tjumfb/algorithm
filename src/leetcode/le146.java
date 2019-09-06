package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    private int capcity;
    private LinkedHashMap<Integer, Integer> hashMap;

    public LRUCache(int capacity) {
        hashMap = new LinkedHashMap(capacity,0.75f,true){
            @Override
            public boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return hashMap.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
       hashMap.put(key,value);
    }
}

