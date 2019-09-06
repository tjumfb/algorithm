import java.util.Arrays;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        int[] a1 = new int[N];
        int[] a2 = new int[N];
        String[] t1 = scanner.nextLine().split(" ");
        String[] t2 = scanner.nextLine().split(" ");
        for(int i = 0; i < N; i++){
            a1[i] = Integer.parseInt(t1[i]);
            a2[i] = Integer.parseInt(t2[i]);
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        int m = N-1, n = N-1;
        int score = 0;

        while (m >= 0 && n >= 0){
            if(a1[m] > a2[n]){
                score++;
                m--;
                n--;
            }
            else if(a1[m] == a2[n]){
                m--;
                n--;
            }else n--;
        }
        if(m >= 0) score -= (m+1);
        System.out.println(score);
    }
}
