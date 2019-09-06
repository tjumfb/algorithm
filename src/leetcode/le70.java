package leetcode;

import java.util.HashMap;

public class le70 {
//    记忆递归
//    HashMap<Integer,Integer> hashMap = new HashMap<>();
//    public int climbStairs(int n) {
//        return climbStairs(0,n);
//    }
//    public int climbStairs(int i, int n){
//        if(i > n) return 0;
//        if(i == n) return 1;
//
//        int a,b;
//        if(hashMap.get(i+1)!=null){
//            a = hashMap.get(i+1);
//        }else {
//            a = climbStairs(i+1,n);
//            hashMap.put(i+1,a);
//        }
//
//        if(hashMap.get(i+2)!=null){
//            b = hashMap.get(i+2);
//        }else {
//            b = climbStairs(i+2,n);
//            hashMap.put(i+2,b);
//        }
//
//        return a+b;
//    }
    public int climbStairs(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] d = new int[n+1];
        d[1] = 1;
        d[2] = 2;
        for(int i = 3; i <= n; i++){
            d[i] = d[i-1]+d[i-2];
        }
        return d[n];
    }
    public static void main(String[] args) {
    System.out.println();
    }
}
