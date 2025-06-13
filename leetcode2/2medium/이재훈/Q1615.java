package 이재훈;

/*
1. 아이디어 :
- 각 도시가 몇 개의 도시와 연결되어 있는지 저장한다.
- 그리고 두 도시가 연결된 상태도 저장한다.
- 모든 도시들에 대해서 도시들간의 연결된 도시를 합하는데 만약 두 도시가 연결되어있으면 -1을 한다.
- 최대값을 반환한다.

2. 시간복잡도 :
O( n ^ 2)
3. 자료구조/알고리즘 :
- /
 */

public class Q1615 {
    class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            /// [[0,1],[0,3],[1,2],[1,3]]
            // 0 : 1, 3 (2개)
            // 1 : 0, 2, 3 (3개)
            // 2 : 1 (1개)
            // 3 : 0, 1 (2개)
            // 0 - 1 구간  (5개 -> 서로 연결되어 -1 = 4)
            // 전체를 돌면서 최대값을 구한다.

            // degree[i] : count how many roads each city is connected
            // use a boolean[][] matrix to track which cities are directly connected
            // for every pair of different cities(i,j):
            // - compute degree[i] + degree[j]
            // - subtract 1 if they are directly connected
            // return the maximum rank found


            int[] degree = new int[n];
            boolean[][] isConnected = new boolean[n][n];

            for(int[] road : roads) {
                int a = road[0];
                int b = road[1];

                degree[a]++;
                degree[b]++;
                isConnected[a][b]=true;
                isConnected[b][a]=true;
            }

            int maxNetRank = Integer.MIN_VALUE;

            for(int i = 0; i<n; i++) {
                for(int j = i+1; j<n;j++) {
                    int sum = degree[i] + degree[j];
                    if(isConnected[i][j]) sum -=1;
                    maxNetRank = Math.max(maxNetRank, sum);
                }
            }
            return maxNetRank;
        }
    }
}