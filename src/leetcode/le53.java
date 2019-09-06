package leetcode;

public class le53 {
//    常规遍历
//    public int maxSubArray(int[] nums) {
//        if(nums.length == 0) return 0;
//        if(nums.length == 1) return nums[0];
//
//        int max = Integer.MIN_VALUE;
//        int cur = 0;
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i] >= 0){
//                cur += nums[i];
//                if(cur > max) max = cur;
//            }
//            else if(nums[i] < 0){
//                if(cur + nums[i] > 0) {
//                    cur += nums[i];
//                }else {
//                    cur = 0;
//                }
//                if(nums[i] > max) max = nums[i];
//            }
//        }
//        return max;
//    }
    public int maxSubArray(int[] nums) {
        return maxSubArray(0,nums.length-1,nums);
    }
    public int maxSubArray(int lo, int hi, int[] nums){
        if(hi - lo == 0){
            return nums[hi];
        }
        if(hi < lo) return Integer.MIN_VALUE;

        int medium = (lo+hi)/2;
        int sum = nums[medium];
        int leftA = maxSubArray(lo,medium-1,nums);//左半部分数组最大值
        int rightA = maxSubArray(medium+1,hi,nums);//右半部分数组最大值

        //横跨，左右各取最大加上中间的
        int right = 0,left = 0,cur = 0;
        int i = medium-1;
        while (i >= lo){
            cur += nums[i];
            i--;
            if(cur > left) left = cur;
        }
        if(left > 0) sum+=left;

        cur = 0;
        int j = medium+1;
        while (j <= hi){
            cur += nums[j];
            j++;
            if(cur > right) right = cur;
        }
        if(right > 0) sum+=right;

        return Math.max(sum,Math.max(leftA,rightA));

    }

    public static void main(String[] args) {
       System.out.println(new le53().maxSubArray(new int[]{-2,1}));
    }
}
