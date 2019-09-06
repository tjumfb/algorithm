package leetcode;

import java.util.HashMap;

public class le560 {
    public int subarraySum(int[] nums, int k) {
        if(nums.length == 0) return 0;

        int res = 0;
        int[] dp = new int[nums.length+1];
        for(int i =1; i < dp.length; i++){
            dp[i] = dp[i-1]+nums[i-1];
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 1; i < dp.length; i++){
            if(map.containsKey(dp[i]-k)){
                res += map.get(dp[i]-k);
            }
            map.put(dp[i],map.getOrDefault(dp[i],0)+1);
        }

        return res;
    }
}
