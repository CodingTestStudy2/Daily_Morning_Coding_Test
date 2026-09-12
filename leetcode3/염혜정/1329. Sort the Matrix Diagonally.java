class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        // 1. 대각선별로 값 모으기 (key = row - col)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                map.computeIfAbsent(key, k -> new PriorityQueue<>()).offer(mat[i][j]);
            }
        }

        // 2. 정렬된 값 다시 채워넣기
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                mat[i][j] = map.get(key).poll();
            }
        }

        return mat;
    }
}
