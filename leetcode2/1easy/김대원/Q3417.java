// 1. 아이디어 : row를 판단
// 2. 시간복잡도 : O(N^2)
// 3. 자료구조/알고리즘 : 완전 탐색

class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> answer = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean isLast = false;
        for (int i = 0; i < n; i++) {
            int[] g = grid[i];
            if (i % 2 == 0) {
                for (int j = 0; j < m; j += 2) {
                    answer.add(g[j]);

                    if (j == m - 1) isLast = true;
                    else isLast = false;
                }
            } else {
                if (isLast) for (int j = m - 2; j >= 0; j -= 2) answer.add(g[j]);
                else for (int j = m - 1; j >= 0; j -= 2) answer.add(g[j]);
            }
        }

        return answer;
    }
}