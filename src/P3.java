import java.util.Scanner;

public class P3 {
    static int count = 0;
    static int M,N;
    static int[] height;
    static boolean[] available;
    static void dfs(int n, int num)
    {
        int i;
        if(n == N)
        {
            if(Math.abs(height[0] - height[num]) <= M)
            {
                count++;
            }
            return;
        } else {
            for(i = 0; i < N; i++)
            {
                if(available[i] && Math.abs(height[num] - height[i]) <= M)
                {
                    available[i] = false;
                    dfs(n + 1, i);
                    available[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        height = new int[N];
        available = new boolean[N];

        for(int i = 0; i < N; i++)
        {
            available[i] = true;
            String t = sc.nextLine();
            height[i] = Integer.parseInt(t);
        }
        available[0] = false;
        dfs(1,0);
        System.out.println(count);
    }
}
