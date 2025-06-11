package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

import java.util.PriorityQueue;

public class Q1632X {
    class Solution {
        public int[][] matrixRankTransform(int[][] matrix) {
        /*
        (500 + 500) * 정렬 * 500 * 500
        1000 * log1000 * 250000
        */
            int n = matrix.length, m = matrix[0].length;
            int[][] ans = new int[n][m];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]); // value, row, col
            for (int i=0; i<n; i++) for (int j=0; j<m; j++) {
                pq.add(new int[]{matrix[i][j], i, j});
            }

            int[][] rowCount = new int[n][2]; //해당 row의 채워져있는 마지막 랭크와 가장 작은 값
            int[][] colCount = new int[m][2]; //해당 row의 채워져있는 마지막 랭크와 가장 작은 값
            for (int i=0; i<n; i++) rowCount[i][1] = Integer.MIN_VALUE;
            for (int i=0; i<m; i++) colCount[i][1] = Integer.MIN_VALUE;

            while (!pq.isEmpty()) {
                int[] c = pq.poll();
                int val = c[0], row = c[1], col = c[2];
                int[] rowInfo = rowCount[row], colInfo = colCount[col];
                int rowCounts = rowInfo[0], rowMinVal = rowInfo[1];
                int colCounts = colInfo[0], colMinVal = colInfo[1];
                int rank = -1;
                if (val == rowMinVal && val == colMinVal) {
                    rank = Math.max(rowCounts, colCounts);
                } else if ( val == rowMinVal) {
                    rank = rowCounts;
                } else if ( val == colMinVal) {
                    rank = colCounts;
                } else {
                    rank = Math.max(rowCounts, colCounts)+1;
                }
                ans[row][col] = rank;

                rowCount[row][0] = rank;
                rowCount[row][1] = Math.max(rowCount[row][1], val);
                colCount[col][0] = rank;
                colCount[col][1] = Math.max(colCount[col][1], val);
            }
            return ans;
        /*
        rowCount = [1, -21], [1, -19], [1, -47], [2,   4]
        colCount = [2, -19], [3,   4], [0, -]

        -47, 2, 1 -> 1
        rowCount = [0,-] -> [1, -47]
        colCount = [0,-] -> [1, -47]
        -21, 0, 1 -> 2
        rowCount = [0,-] -> [1, -21]
        colCount = [1, -47] -> [2, -21]
        -19, 1, 0 -> 1
        rowCount = [0, -] -> [1, -19]
        colCount = [0, -] -> [1, -19]
        -19, 3, 0 -> 2
        rowCount = [0, -] -> [1, -19]
        colCount = [1, -19] -> [2, -19]
        4, 3, 1 -> 3
        rowCount = [1, -19] -> [2, 4]
        colCount = [2, -21] -> [3, 4]
        4, 1, 1 ->
        rowCount = [1, -19] -> [2, 4]
        colCount = [3,   4] -> [3, 4]

        */
        }
    }
}
