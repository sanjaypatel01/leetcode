class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i=0; i < rows; i++) {
            for(int j=0; j < i; j++) {
                swap(matrix, i, j);
            }
        }
        for(int i=0; i < rows; i++) {
            reverse(matrix, i, cols);
        }
    }

    private void swap(int [][]matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    private void reverse(int [][]matrix, int row, int cols) {
        int start = 0;
        int end = cols - 1;
        while(start < end) {
            int temp = matrix[row][start];
            matrix[row][start] = matrix[row][end];
            matrix[row][end] = temp;
            start++;
            end--;
        }
    }
}