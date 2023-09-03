class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int dp[][] = new int[rows][cols];
        for(int []row : dp) Arrays.fill(row, -1);

        return minPath(rows-1, cols -1, grid, dp);
    }

    private int minPath(int row, int col, int [][]grid, int [][]dp) {
        if(row == 0 && col == 0) return grid[0][0];
        if(row < 0 || col < 0) return Integer.MAX_VALUE;
        if(dp[row][col] != -1) return dp[row][col];
        return dp[row][col] = grid[row][col] + Math.min(minPath(row-1, col, grid, dp), minPath(row, col-1, grid, dp));
    }
}