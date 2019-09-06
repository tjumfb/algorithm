package leetcode;

import com.sun.tools.hat.internal.util.Comparer;

import java.util.ArrayList;


public class le56 {
    void sort(int[][] a, int lo, int hi){
        if(hi <= lo) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    int partition(int[][] a, int lo, int hi){
        int i = lo, j = hi + 1;
        int[] t;
        while (true){
            while (a[lo][0] > a[++i][0]) if(i==hi) break;
            while (a[lo][0] < a[--j][0]) ;
            if(i >= j) break;
            t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        t = a[lo];
        a[lo] = a[j];
        a[j] = t;
        return j;
    }
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        sort(intervals,0,intervals.length-1);
        for(int i = 0; i < intervals.length; i++){
            if(intervals[i] == null) continue;
            for(int j = i+1; j < intervals.length; j++){
                if(intervals[j] == null) continue;
                if((       intervals[j][0] >= intervals[i][0] && intervals[j][0] <= intervals[i][1])
                        ||(intervals[j][1] >= intervals[i][0] && intervals[j][1] <= intervals[i][1])
                        ||(intervals[i][0] >= intervals[j][0] && intervals[i][0] <= intervals[j][1])
                        ||(intervals[i][1] >= intervals[j][0] && intervals[i][1] <= intervals[j][1])){
                    intervals[i][0] = Math.min(intervals[i][0],intervals[j][0]);
                    intervals[i][1] = Math.max(intervals[i][1],intervals[j][1]);
                    intervals[j] = null;
                }
            }
        }
        for(int i = 0; i < intervals.length; i++){
            if(intervals[i] != null) res.add(intervals[i]);
        }
        int[][] ret = new int[res.size()][];
        for(int i = 0; i < res.size(); i++){
            ret[i] = res.get(i);
        }
        return ret;
    }
    public static void main(String[] args) {
//        {{2,3},{4,5},{6,7},{8,9},{1,10}}
        int[][] intervals = new int[][] {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] res = new le56().merge(intervals);
        for(int[] i : res){
            for(int j:i) System.out.print(j+" ");
            System.out.println();
        }
    }
}

