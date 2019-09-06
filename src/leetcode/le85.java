package leetcode;


import java.util.Stack;

public class le85 {
    public int largestRectangleArea(int[][] ints,int row) {
        int max_area = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < ints[0].length; i++){
            while (stack.peek()!= -1 && ints[row][i] <= ints[row][stack.peek()]){
                int h = ints[row][stack.pop()];
                int l = i-stack.peek()-1;
                int t = Math.min(h,l);
                max_area = Math.max(max_area,t*t);
            }
            stack.push(i);
        }
        while (stack.peek() != -1){
            int k = stack.pop();
            int h = ints[row][k];
            int l = ints[0].length-stack.peek()-1;
            int t = Math.min(h,l);
            max_area = Math.max(max_area,t*t);
        }
        return max_area;
    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        int[][] m = new int[row][col];

        for(int i = 0; i < col; i++){
            int temp = 0;
            for(int j = 0; j < row; j++){
                if(matrix[j][i] == '1'){
                    temp++;
                    m[j][i] = temp;
                }else temp = 0;
            }
        }
//        for(int[] i:m){
//            for(int j:i){
//                System.out.print(j+" ");
//            }
//            System.out.println();
//        }

        for(int i = 0; i < row; i++){
            max = Math.max(max,largestRectangleArea(m,i));
        }

        return max;
    }

    public static void main(String[] args) {
        char[][] m = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(new le85().maximalRectangle(m));
    }
}
