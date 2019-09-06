package leetcode;


import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

public class le322 {
//    笨法子
//    HashMap<Integer,Integer> res = new HashMap<>();
//    public int coinChange(int[] coins, int amount) {
//        Arrays.sort(coins);
//        for(int i: coins){
//            res.put(i,1);
//        }
//
//        int times = amount/coins[0];
//        for(int i = 0; i < times; i++){
//            HashMap<Integer,Integer> temp = new HashMap<>(res);
//            for(int m:res.keySet()){
//                for(int n:coins){
//                    int coin = m+n;
//                    if(!temp.containsKey(coin)) temp.put(coin,res.get(m)+1);
//                }
//            }
//        }
//        return res.getOrDefault(amount,-1);
//    }
//        记忆递归
//        public int coinChange(int[] coins, int amount) {
//            if(amount == 0) return 0;
//            int[] mem = new int[amount+1];
//            for(int i = 0; i < mem.length; i++) mem[i] = -2;
//
//            return helper(coins,amount,mem);
//        }
//        public int helper(int[] coins, int amount, int[] mem){
//            if(amount == 0) return 0;
//            if(mem[amount] != -2) return mem[amount];
//
//            int ans = Integer.MAX_VALUE;
//            for(int c:coins){
//                if(amount < c) continue;
//                int sub = helper(coins,amount-c,mem);
//                if(sub == -1) continue;
//                ans = Math.min(ans,sub+1);
//            }
//            mem[amount] = (ans == Integer.MAX_VALUE?-1:ans);
//            return mem[amount];
//        }

public int coinChange(int[] coins, int amount) {
    int[] count = new int[amount+1];
    for(int i = 0; i < count.length; i++) count[i] = amount+1;
    count[0] = 0;
    for(int i = 0; i <= amount; i++){
        for(int c:coins)
            if(c <= i)
                count[i] = Math.min(count[i-c]+1,count[i]);
    }
    return count[amount]==(amount+1)?-1:count[amount];
}

    public static void main(String[] args) {
//        System.out.println(new le322().coinChange(new int[]{1,2,5},11));
        File file = new File("/Users/mengfanbo/Documents/大二下/2018计算机网络/谢希仁答案");
        if(file.isDirectory()){
            for (File f:file.listFiles()) {
                String name = f.getAbsolutePath();
                name = name.replace("计算机网络(第5版)课后习题答案：","");
                System.out.println(name);
                File t = new File(name);
                System.out.println(f.renameTo(t));

            }
        }
    }

}
