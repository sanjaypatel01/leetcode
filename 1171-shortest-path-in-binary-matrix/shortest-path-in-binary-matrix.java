class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(grid[0][0] != 0 || grid[rows-1][cols -1] != 0) return -1;

        boolean [][]visited = new boolean[rows][cols];
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int dist = 1;
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int k=0; k < n; k++) {
                int []point = queue.poll();
                int x = point[0];
                int y = point[1];
                if(x == (rows -1) && y == (cols -1)) return dist;
                for(int i=x-1; i <= x + 1; i++) {
                    for(int j=y-1; j <= y+1; j++) {
                        if((i >= 0 && i < rows && j >= 0 && j < cols) && !visited[i][j] && grid[i][j] == 0) {
                            queue.offer(new int[]{i, j});
                            visited[i][j] = true;
                        }
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}