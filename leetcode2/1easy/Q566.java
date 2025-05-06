package Leetcode;

/*
1. 아이디어 :

 - r의 행렬과 c의 행렬로 기존데이터를 넣는다.
 - 만약 데이터수가 모자르면 기존 데이터를 반환한다.

2. 시간복잡도 :
O( n*m )
3. 자료구조/알고리즘 :
- /
 */

public class Q566 {
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            int row = 0, col = 0;
            int[][] res = new int[r][c];

            if(mat.length * mat[0].length != r * c) return mat;

            for(int i = 0; i<mat.length; i++) {
                for(int j= 0; j<mat[i].length;j++) {
                    res[row][col] = mat[i][j];
                    col++;
                    if(col == c) {
                        col = 0;
                        row++;
                    }
                }
            }
            return res;

        }
    }
}