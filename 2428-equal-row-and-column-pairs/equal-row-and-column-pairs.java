class Solution {
    public int equalPairs(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Map<String, Integer> rowMap = new HashMap<>();
        Map<String, Integer> colMap = new HashMap<>();
        for(int []row: grid) {
            StringBuilder sb =new StringBuilder();
            for(int cell : row) sb.append(cell +",");
            rowMap.put(sb.toString(), rowMap.getOrDefault(sb.toString(), 0) + 1);
        }

        for(int i=0; i < rows; i++) {
            StringBuilder sb =new StringBuilder();
            for(int j=0; j < cols; j++) sb.append(grid[j][i] +",");
            colMap.put(sb.toString(), colMap.getOrDefault(sb.toString(), 0) + 1);
        }
        int total = 0;
        for(Map.Entry<String, Integer> entry : rowMap.entrySet()) {
            Integer count = colMap.get(entry.getKey());
            if(count != null) {
               total += entry.getValue() * count;
            }
        }
        return total;
    }
}