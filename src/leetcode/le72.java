package leetcode;

public class le72 {
    static public int minDistance(String word1, String word2) {
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();

        int row = word1.length();
        int col = word2.length();
        int[][] matrix = new int[row+1][col+1];


        for(int i = 0; i <= col; i++){
            matrix[0][i] = i;
        }
        for(int i = 0; i <= row; i++){
            matrix[i][0] = i;
        }

        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) matrix[i][j] = matrix[i-1][j-1];
                else {
                    int cost = Math.min(matrix[i-1][j],matrix[i][j-1]);
                    matrix[i][j] = Math.min(cost,matrix[i-1][j-1]) + 1;
                }
            }
        }
        return matrix[row][col];
    }

    public static void main(String[] args) {
        System.out.print(minDistance("horse","ros"));
    }

}
