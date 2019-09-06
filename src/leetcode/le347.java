package leetcode;


import java.util.*;

public class le347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums.length == 0) return null;
        if(k > nums.length) return null;
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -map.get(o1).compareTo(map.get(o2));
            }
        });

        for(int i:nums) {
            if(!priorityQueue.contains(i))
             priorityQueue.add(i);
        }
        for(int i = 0; i < k; i++) res.add(priorityQueue.poll());
        return res;
    }
}
