class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;

        // Check if reshape is possible
        if (m * n != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];

        int row = 0;
        int col = 0;

        // Traverse original matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                result[row][col] = mat[i][j];

                col++;

                // Move to next row
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }

        return result;
    }
}