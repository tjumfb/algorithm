package leetcode;



import java.util.Stack;

public class le84 {
//    暴力
//    public int largestRectangleArea(int[] heights) {
//    int max_area = 0;
//    int min_height;
//    for(int i = 0; i < heights.length; i++){
//        min_height = heights[i];
//        for(int j = i; j < heights.length; j++){
//            if(heights[j] < min_height) min_height = heights[j];
//            max_area = Math.max(max_area,min_height*(j-i+1));
//        }
//    }
//    return max_area;
//    }
//分治
//public int largestRectangleArea(int[] heights) {
//    return large(0,heights.length-1,heights);
//}
//public int large(int lo, int hi, int[] heights){
//    if(lo == hi) return heights[lo];
//    if(lo > hi) return 0;
//
//    int height = Integer.MAX_VALUE;
//    int area = 0;
//    int index = 0;
//    for(int i = lo; i <= hi; i++){
//        if(heights[i]<height) {
//            height = heights[i];
//            index = i;
//        }
//    }
//    area = Math.max(height*(hi-lo+1),large(lo,index-1,heights));
//    area = Math.max(area,large(index+1,hi,heights));
//    return area;
//}
    public int largestRectangleArea(int[] ints){
        int max_area = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < ints.length; i++) {
            while (stack.peek() != -1 && ints[i] <= ints[stack.peek()]) {
                int h = ints[stack.pop()];
                int l = i - stack.peek() - 1;
                max_area = Math.max(max_area, h * l);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int k = stack.pop();
            int h = ints[k];
            int l = ints.length - stack.peek() - 1;
            max_area = Math.max(max_area, h * l);
        }
        return max_area;
    }

    public static void main(String[] args) {
        System.out.println(new le84().largestRectangleArea(new int[]{3,1,3,2,2}));

    }




}
