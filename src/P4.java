import java.util.Scanner;

public class P4 {
    static int score = 0;
    static int N;
    static int[] stones;
    static void dfs(int index){
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        stones = new int[N];
        for(int i = 0; i < N; i++){
            stones[i] = sc.nextInt();
            sc.nextLine();
        }
    }
}
