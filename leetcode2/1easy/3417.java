package Leetcode;

/*
1. 아이디어 :

- 왼쪽 으로 쭉 가고 내려가서 오른쪽 가는식으로 해서 하나 건너띄어서 데이터를 수집 후 리턴

2. 시간복잡도 :
O( n * m )
3. 자료구조/알고리즘 :
- / 완전 탐색
 */

public class Q1154 {
    class Solution {
        public List<Integer> zigzagTraversal(int[][] grid) {

            int rowLength = grid.length;
            int colLength = grid[0].length;
            List<Integer> ls = new ArrayList<>();

            for(int i = 0; i < rowLength; i++) {
                if(i % 2 == 0) {
                    // left to right
                    for(int j = 0; j<colLength; j++) {
                        if(j % 2 == 0) {
                            ls.add(grid[i][j]);
                        }
                    }
                } else {
                    // right to left
                    for(int j = colLength -1; j>=0; j--) {
                        if(j % 2 != 0) {
                            ls.add(grid[i][j]);
                        }
                    }
                }
            }
            return ls;
        }
    }
}