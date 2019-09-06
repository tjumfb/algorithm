package sort;

public class Insertion {
    static void sort(int[] a){
        int l = a.length;
        for(int i = 0; i < l; i++){
            int index = 0;
            for(; index < i; index++){
                if(a[index] > a[i])
                    break;
            }
            if(index != i){
                int t = a[i];
                for(int m = i; m > index; m--){
                    a[m] = a[m-1];
                }
                a[index] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2,1,21313,23435255,2,6,8,2,1,5,7,8,4141414};
        sort(a);
        for(int i:a){
            System.out.print(i+" ");
        }
    }
}
