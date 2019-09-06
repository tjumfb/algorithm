package sort;

public class Quick {
    static void sort(int[] a, int lo, int hi){
        if(hi <= lo) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    static int partition(int[] a, int lo, int hi){
        int i = lo, j = hi + 1;
        int t = 0;
        while (true){
            while (a[lo] > a[++i]) if(i==hi) break;
            while (a[lo] < a[--j]) ;
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

    public static void main(String[] args) {
        int[] a = {7,2,1,56,124,464,1,5,6747,324,324,2335,3525,3324,42324,53252,2353,23532,3252,35325,3525,3532,3525};
        sort(a,0,a.length-1);
        for(int i : a){
            System.out.print(i + " ");
        }
    }

}
