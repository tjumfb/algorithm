package sort;

public class LSD {
    //字符串从最低位排序
    public static void sort(String[] a, int W){
        int R = 256;
        int N = a.length;
        String[] aux = new String[N];

        for(int d = W-1; d >= 0; d--){
            int[] count = new int[R+1];

            for (String anA : a) {
                count[anA.charAt(d)+1]++;
            }
            for(int i = 1; i < count.length; i++){
                count[i] += count[i-1];
            }
            for (String s:a) {
                aux[count[s.charAt(d)]++] = s;
            }
            System.arraycopy(aux, 0, a, 0, N);
        }
    }

    public static void main(String[] args) {
        String[] a = new String[]{"3bcd","sdaf","2fa3","2423","4gad"};
        sort(a,4);
        for (String s: a) {
            System.out.println(s);
        }
    }
}
