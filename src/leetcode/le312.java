package leetcode;

import java.util.LinkedList;

//暴力
//public class le312 {
//    int max = 0;
//    public int maxCoins(int[] nums) {
//        LinkedList<Integer> list = new LinkedList<>();
//        for(int i: nums) list.add(i);
//        maxCoins(list,0);
//        return max;
//    }
//    public void maxCoins(LinkedList<Integer> list, int sum) {
//        if(list.size() == 1){
//            if(max < list.getFirst() + sum){
//                max = list.getFirst() + sum;
//            }
//            return;
//        }
//
//        for(int i = 0; i < list.size(); i++){
//            LinkedList<Integer> temp = (LinkedList<Integer>) list.clone();
//            int add = sum,mul1=1, mul2 = 1;
//            if(i-1 >= 0) mul1 = temp.get(i-1);
//            if(i+1 < list.size()) mul2 = temp.get(i+1);
//            add += temp.get(i)*mul1*mul2;
//            temp.remove(i);
//            maxCoins(temp,add);
//        }
//    }
//}

// 回溯
//class 全排列 {
//    int[][] dp;
//    int ans;
//    int n;
//    public int helper(int[] nums,int i,int j) {
//        //边界条件
//        if (i>j) return 0;
//        if (dp[i][j] > 0 ) return dp[i][j];
//        for ( int k=i;k<=j;k++) {
//            int arr0 = (nums[i-1])*nums[k]*(nums[j+1]);
//            dp[i][j] = Math.max(dp[i][j],helper(nums,i,k-1)+helper(nums,k+1,j)+arr0);
//        }
//        return dp[i][j];
//    }
//    public int maxCoins(int[] nums) {
//        n = nums.length;
//        int[] num = new int[n+2];
//        num[0] = 1;
//        num[n+1] = 1;
//        for (int i=1;i<n+1;i++) {
//            num[i] = nums[i-1];
//        }
//        dp = new int[n+2][n+2];
//        ans = helper(num,1,n);
//        return ans;
//    }
//}

public class le312 {

    static public int maxCoins(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

       int len = nums.length;
       int[] nums2 = new int[len+2];
       int[][] matrix = new int[len][len];

       nums[0] = 1;
       nums2[len+1] = 1;
       for(int i = 1; i <= len; i++){
           nums2[i] = nums[i-1];
       }

       for(int i = 0; i < len; i++){
           matrix[i][i] = nums2[i];
       }

       for(int i = 0; i < len; i++){
           for(int j = i+1; j < len; j++){
               int max = 0;
               for(int k = i; k <= j; k++){
                    int left = (k-1>=i?  matrix[i][k-1]:0);
                    int right = (k+1<=j? matrix[k+1][j]:0);
                    max = Math.max(left+right+nums2[i]*nums2[j]*nums2[k],max);
               }
               matrix[i][j] = Math.max(matrix[i][j],max);
           }
       }
        return matrix[0][len-1];
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3,1,5,8}));
    }

}
