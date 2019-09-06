package leetcode;

public class le200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    res++;
                    clean(grid,i,j);
                }
            }
        }
        return res;
    }
    public void clean(char[][] grid,int i, int j){
        if(i == grid.length || j == grid[0].length || i < 0 || j < 0) return;
        if(grid[i][j] == '0') return;
        grid[i][j] = '0';
        clean(grid,i+1,j);
        clean(grid,i,j+1);
        clean(grid,i-1,j);
        clean(grid,i,j-1);
    }

    public static void main(String[] args) {
        char[][] grid =
                {
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','1','1','1','0'},
                        {'1','1','1','1','0'},
                };
        System.out.println(new le200().numIslands(grid));
    }
}
