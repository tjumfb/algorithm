package search;

public class Bsearch {
    public static int search(int[] a, int aim){
        if(a.length == 0) return -1;
        int lo = 0,hi = a.length-1;
        int mid = (lo+hi)/2;
        while (lo <= hi){
            if(a[mid] > aim){
                hi = mid - 1;
                mid = (lo+hi)/2;
            }else if(a[mid] < aim){
                lo = mid + 1;
                mid = (lo+hi)/2;
            }else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        System.out.println(search(a,7));
    }
}
