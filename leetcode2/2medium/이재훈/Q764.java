package 이재훈;

/*
1. 아이디어 :
- 각 맵에서 왼쪽 오른쪽 위 아래 값을 구한뒤에 최소값들 중에서 최대값을 가져오는 방식으로 풀음

2. 시간복잡도 :
O( n ** n )
3. 자료구조/알고리즘 :
- /
 */

public class Q764 {
    class Solution {
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            int[][] map = new int[n][n];

            for(int[] mine : mines ) {
                map[mine[0]][mine[1]] = 1;
            }

            int[][] left = new int[n][n];
            int[][] right = new int[n][n];
            int[][] up = new int[n][n];
            int[][] down = new int[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j<n; j++) {
                    if(map[i][j] == 0) {
                        left[i][j] = (j > 0 ? left[i][j-1] : 0) + 1;
                        up[i][j] = (i > 0 ? up[i-1][j] : 0) + 1;
                    }
                }
            }

            for(int i = n - 1; i >= 0; i--) {
                for(int j = n-1; j>=0; j--) {
                    if(map[i][j] == 0) {
                        right[i][j] = (j < n - 1 ? right[i][j+1] : 0) + 1;
                        down[i][j] = (i < n-1 ? down[i+1][j] : 0) + 1;
                    }
                }
            }
            int ans = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j<n; j++) {
                    int tem = Math.min(Math.min(left[i][j], right[i][j]), Math.min(up[i][j], down[i][j]));

                    ans = Math.max(ans, tem);
                }
            }

            return ans;
        }
    }
}
