package search;

public class SreachSubString {
    public static int violence(String txt, String pattern){
        int i, N = txt.length();
        int j, M = pattern.length();
        for(i = 0, j=0; i < N&&j < M;i++){
            if(txt.charAt(i) == pattern.charAt(j)) j++;
            else {
                i-=j;
                j = 0;
            }
        }
        if(j == M) return i-M;
        else return N;
    }

    public static void main(String[] args) {
        String txt = "dffsfefsaffedvs";
        System.out.println(violence(txt,"fsa"));
    }
}
