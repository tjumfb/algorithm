package leetcode;

import search.Bsearch;
import sort.Merge;

import java.util.HashSet;

public class le1 {
    static void nlgNfind(int[] a, int aim){
        Merge.mergeSort(a);
        for(int i = 0; i < a.length; i++)
        {
            int j = Bsearch.search(a, aim-a[i]);
            if(j > i){
                System.out.println(i+" "+j);
            }
        }
    }
    static boolean find(int[] array, int x) {
        HashSet<Integer> s = new HashSet<Integer>();

        for(int i = 0; i < array.length; i++) {
            if (s.contains(array[i]) || s.contains(x-array[i])) {
                return true;
            }
            s.add(array[i]);
            s.add(x-array[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2,4,1,2,45,6,3,24,2};
//        nlgNfind(a,69);
    }
}
