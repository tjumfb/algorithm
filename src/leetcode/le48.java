package leetcode;

public class le48 {
    public int size;
    public void rotate(int[][] matrix) {
        size = matrix.length;
        if(size == 0) return;
        rotate(matrix,0,matrix.length);
    }
    public void rotate(int[][] matrix, int m, int len){
        if(len <= 1) return;
        for(int i = m; i < m+len-1; i++){
            int a = m,  b=i, t = matrix[a][b];
            while (true){
               int na = b;
               int nb = size-1-a;
               if(na == m && nb == i) break;

               int h = matrix[na][nb];
               matrix[na][nb] = t;
               t = h;

               a = na;
               b = nb;
            }
            matrix[m][i] = t;
        }

        rotate(matrix,m+1,len-2);
    }

    public static void main(String[] args) {
//        for(int i = 0; i < 5; i++){
//            for(int j = 0; j < 5; j++){
//                System.out.print(j+","+(4-i)+" ");
//            }
//            System.out.println();
//        }
        int[][] m = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
//        int[][] m = new int[][]{
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };
        new le48().rotate(m);

        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m.length; j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }
}
