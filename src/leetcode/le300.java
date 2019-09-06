package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class le300 {
//    递归
//    public int lengthOfLIS(int[] nums) {
//        return getLen(nums,Integer.MIN_VALUE,0);
//    }
//    public int getLen(int[] nums, int prev, int index){
//        if(index == nums.length) return 0;
//        int take = 0;
//        if(nums[index] > prev){
//            take = 1 + getLen(nums,nums[index],index+1);
//        }
//        int notake = 0;
//        notake = getLen(nums,prev,index+1);
//        return Math.max(take,notake);
//    }
//    非递归N2
//public int lengthOfLIS(int[] nums) {
//    int[] cell = new int[nums.length];
//    Arrays.fill(cell,1);
//    cell[0] = 1;
//    for(int i = 1; i < nums.length; i++){
//        for(int j = i; j >= 0; j--){
//            if(nums[j] < nums[i]) cell[i] = Math.max(cell[j]+1,cell[i]);
//        }
//    }
//    int max = 0;
//    for(int i:cell){
//        System.out.print(i+" ");
//        max = Math.max(i,max);
//    }
//    return max;
//}
public int lengthOfLIS(int[] nums) {
    int maxL = 0;
    int[] dp = new int[nums.length];
    for(int num : nums) {
        // 二分法查找, 也可以调用库函数如binary_search
        int lo = 0, hi = maxL;
        while(lo < hi) {
            int mid = lo+(hi-lo)/2;
            if(dp[mid] < num)
                lo = mid+1;
            else
                hi = mid;
        }
        dp[lo] = num;
        if(lo == maxL)
            maxL++;
    }
    return maxL;
}


    public static void main(String[] args) {
        new le300().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
    }
}
