package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class le135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if(len == 0) return 0;
        if(len == 1) return 1;

        int res = 0;
        int[] left = new int[len];
        int[] right = new int[len];
        for(int i = 0; i < len; i++){
            left[i] = 1;
            right[i] = 1;
        }

        for(int i = 1; i < len; i++){
            if(ratings[i] > ratings[i-1]) left[i] = left[i-1]+1;
        }
        for(int i = len-2; i >= 0; i--){
            if(ratings[i] > ratings[i+1]) right[i] = right[i+1]+1;
        }
        for(int i = 0; i < len; i++){
//            System.out.println(left[i]+" "+right[i]+" "+ratings[i]);
            res += Math.max(left[i],right[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {29,51,87,87,72,12};
        System.out.println(new le135().candy(nums));
    }
}
