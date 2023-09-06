class Solution {
    public int findMaxFish(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        boolean visited[][] = new boolean[rows][cols];
        int [][]dirs = new int [][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int max = 0;
        for(int i=0; i < rows; i++){
            for(int j=0; j < cols; j++){
                if(!visited[i][j])
                    max = Math.max(max, dfs(i, j, rows, cols, grid, dirs, visited));
            }
        }
        return max;
    }
    
    private int dfs(int row, int col, int rows, int cols, int [][]grid, int [][]dirs, boolean [][]visited) {
        
        if(row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col] || grid[row][col] == 0) 
            return 0;
        
        visited[row][col] = true;
        int count = 0;
        for(int []dir : dirs) {
            count += dfs(row + dir[0], col + dir[1], rows, cols, grid, dirs, visited);
        }
        return grid[row][col] + count;
    }
}