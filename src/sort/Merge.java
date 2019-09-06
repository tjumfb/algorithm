package sort;

import edu.princeton.cs.algs4.RandomSeq;
import edu.princeton.cs.algs4.StdOut;
import util.Timer;

import java.util.Random;

public class Merge {
    public static void mergeSort(int[] a){
        merge(a,0, a.length-1);
    }
    public static void merge(int[]a, int lo, int hi){
        if(hi <= lo+1) {
            if(a[hi] < a[lo]){
                int t = a[hi];
                a[hi] = a[lo];
                a[lo] = t;
            }
        }else {
            int mid = (hi+lo)/2;
            merge(a,lo,mid);
            merge(a, mid+1,hi);
            int[] t = new int[hi-lo+1];
            int i = lo, j = mid + 1, m = 0;//迭代
            while (i <= mid && j <= hi){
                if(a[i] > a[j]){
                    t[m++] = a[j++];
                }else {
                    t[m++] = a[i++];
                }
            }
            while (i<=mid){
                t[m++] = a[i++];
            }
            while (j<=hi){
                t[m++] = a[j++];
            }
            for(int k = lo; k <= hi; k++){
//                System.out.print(t[k-lo]);
                a[k] = t[k-lo];
            }
//            System.out.println();
        }
    }

    public static void main(String[] args) {
            int[] a = {1,2,3,2,1,4,21,3,123,21,4};
            Timer timer = new Timer();
            mergeSort(a);
            for(int j:a) System.out.print(a);
            System.out.println();
            System.out.println(timer.getTime());

    }
}
