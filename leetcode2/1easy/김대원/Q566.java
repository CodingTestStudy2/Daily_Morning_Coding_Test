class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;

        if (n == r && n * m == c) return mat;

        if (r == 1) {
            int[][] reshape = new int[1][n * m];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    reshape[0][idx++] = mat[i][j];
                }
            }

            return reshape;
        } else {
            int[] tmp = new int[n * m];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tmp[idx++] = mat[i][j];
                }
            }

            if (tmp.length != r * c) return mat;

            int[][] reshape = new int[r][c];
            idx = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    reshape[i][j] = tmp[idx++];
                }
            }

            return reshape;
        }
    }
}