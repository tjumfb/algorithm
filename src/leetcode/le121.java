package leetcode;

public class le121 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int cMin = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > cMin) max = Math.max(max,prices[i]-cMin);
            else cMin = prices[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{7,5,4,3,1};
        System.out.println(new le121().maxProfit(a));
    }
}
