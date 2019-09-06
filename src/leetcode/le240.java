package leetcode;

public class le240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0) return false;
        int col = matrix[0].length;
        if(col == 0) return false;

        int j = col - 1, i = 0;
        while (i < row && j >= 0){
            if(matrix[i][j] < target) i++;
            else if(matrix[i][j] > target) j--;
            else return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(new le240().searchMatrix(matrix,18));


    }
}
