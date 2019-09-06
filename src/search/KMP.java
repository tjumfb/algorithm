package search;

public class KMP {
     int R = 256;
     int M;
     int[][] dfa;
    KMP(String pattern){
        M = pattern.length();
        dfa = new int[R][M];
        dfa[pattern.charAt(0)][0] = 1;
        for(int X = 0,j=1; j < M; j++){
            for(int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][X];
            dfa[pattern.charAt(j)][j] = j+1;
            X = dfa[pattern.charAt(j)][X];
        }
    }
     int serach(String txt){
        int j = 0, i = 0;
        for(; i < txt.length() && j < M; i++)
            j = dfa[txt.charAt(i)][j];
        if(j == M) return i-M;
        else return txt.length();
    }

    public static void main(String[] args) {
        String txt = "helloworldword";
        KMP kmp = new KMP("word");
        System.out.println(kmp.serach(txt));
    }
}
