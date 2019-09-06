package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class le128 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int maxLen = 0;
        HashSet<Integer> hash = new HashSet<>();

        for(int i : nums){
            hash.add(i);
        }

        for(int i : nums){
            if(!hash.contains(i-1)){
                int len = 0;
                while (hash.contains(i++)){
                    len++;
                }
                maxLen = Math.max(len,maxLen);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new le128().longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
