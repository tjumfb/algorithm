package leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class le253 {
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
    public int minMeetingRooms(int[][] intervals) {
        // 按开始时间排序
        sort(intervals,0,intervals.length-1);
        // 存会议室开始时间
        ArrayList<Integer> start_time = new ArrayList<>();
        start_time.add(0);

        for(int i = 0; i < intervals.length; i++){
//          判断当前是否有会议室能接待intervals[i],优先挑结束时间晚的
            boolean available = false;
            for(int j = start_time.size()-1; j >= 0; j--){
                if(start_time.get(j) <= intervals[i][0]){
                    start_time.set(j,intervals[i][1]);
                    available = true;
                    break;
                }
            }
            if(!available){
                start_time.add(intervals[i][1]);
            }
            Collections.sort(start_time);
        }

        return start_time.size();
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {7,10},
                {2,4},
                {5,10}
        };
       System.out.println(new le253().minMeetingRooms(intervals));
    }
}
