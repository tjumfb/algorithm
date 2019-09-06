package sort;

public class MSD {
    static int R = 256;
    public static final int M = 1;
    public static int charAt(String s, int d){
        if(d < s.length()) return s.charAt(d);
        else return -1;
    }
    public static void sort(String[] s) {
        sort(s,0,s.length-1,0);
    }
    public static void insertSort(String[] s, int lo, int hi){
        for(int i = lo+1; i <= hi; i++){
            int j = lo;
            while (j < i && s[j].compareTo(s[i]) <= 0){
                j++;
            }
            if(j == i) continue;
            String temp = s[i];
            int index = j;

            for(int m = i; m > j; m--){
                s[m] = s[m-1];
            }
            s[j] = temp;
        }
    }
    public static void sort(String[] s, int lo, int hi, int d){
        if(lo + M >= hi){
            insertSort(s,lo,hi);
            return;
        }
        int N = hi-lo+1;
        int[] count = new int[R+2];
        for(int i = lo; i <= hi; i++){
            count[charAt(s[i],d)+2]++;
        }

        for(int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }

        String[] aux = new String[N];
        for(int i = lo; i <= hi; i++){
           String t = s[i];
           aux[count[charAt(s[i],d)+1]++] = t;
        }

        System.out.println(d+": "+lo+" "+hi);
        for(int i = lo; i <= hi; i++){
            System.out.println(s[i]);
            s[i] = aux[i-lo];
        }
        System.out.println();

        for(int i = 1; i < count.length; i++){
            sort(s,lo+count[i-1],lo+count[i]-1,d+1);
        }

    }

    public static void main(String[] args) {
        String[] s = new String[]{"efds","fgadv","dscvsfsf","sf","btef","cfsaca","scac","sdwsc","dcxwcad"};
//        insertSort(s,0,s.length-1);
        sort(s);
        for(String t:s) System.out.println(t);
    }
}
