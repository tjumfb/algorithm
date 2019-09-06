package leetcode;

import java.util.Stack;

public class le221 {
//    单调栈思路
//    public int largestRectangleArea(int[][] ints,int col) {
//        int max_area = 0;
//        Stack<Integer> stack = new Stack<>();
//        stack.push(-1);
//        for(int i = 0; i < ints.length; i++){
//            while (stack.peek()!= -1 && ints[i][col] <= ints[stack.peek()][col]){
//                int h = ints[stack.pop()][col];
//                int l = i-stack.peek()-1;
//                int t = Math.min(h,l);
//                max_area = Math.max(max_area,t*t);
//            }
//            stack.push(i);
//        }
//        while (stack.peek() != -1){
//            int k = stack.pop();
//            int h = ints[k][col];
//            int l = ints.length-stack.peek()-1;
//            int t = Math.min(h,l);
//            max_area = Math.max(max_area,t*t);
//        }
//        return max_area;
//    }
//    public int maximalSquare(char[][] matrix) {
//        if(matrix.length == 0) return 0;
//        int row = matrix.length;
//        int col = matrix[0].length;
//
//        int max = 0;
//        int[][] m = new int[row][col];
//
//        for(int i = 0; i < row; i++){
//            int temp = 0;
//            for(int j = col-1; j >= 0; j--){
//                if(matrix[i][j] == '1'){
//                    temp++;
//                    m[i][j] = temp;
//                }else temp = 0;
//            }
//        }
//
//        for(int[] i:m){
//            for(int j:i){
//                System.out.print(j+" ");
//            }
//            System.out.println();
//        }
//
//        for(int i = 0; i < col; i++){
//            max = Math.max(largestRectangleArea(m,i),max);
//        }
//        return max;
//    }
//    动态规划
//    public int maximalSquare(char[][] matrix) {
//    int row = matrix.length;
//    if(row == 0) return 0;
//    int col = matrix[0].length;
//    int max = 0;
//    int[][] size = new int[row+1][col+1];
//
//    for(int i = 1; i <= row; i++){
//        for(int j = 1; j <= col; j++){
//            if(matrix[i-1][j-1] == '1') {
//                size[i][j] = Math.min(size[i - 1][j], size[i][j - 1]);
//                size[i][j] = Math.min(size[i][j], size[i - 1][j - 1]) + 1;
//                max = Math.max(max, size[i][j] * size[i][j]);
//            }
//        }
//    }

//    return max;
//    }
//  空间优化的DP
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }


    public static void main(String[] args) {
        char[][] m = new char[][]{
                {'1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','0','0','0'},
                {'0','1','1','1','1','0','0','0'}};
        System.out.println(new le221().maximalSquare(m));
    }
}
