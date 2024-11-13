/**
DP?
-> 방향이 주어짐
-> 2인 경우는 한쪽 방향

0 1 1
1 2 3
1 3 6
*/
class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] road = new int[m][n][2]; // 왼, 위에서 오던 차량 구분
        road[0][0][0] = 1;
        road[0][0][1] = 1;
        
        for (var i=0; i<m; i++) {
            for (var j=0; j<n; j++) {
                if (cityMap[i][j] == 1 || (i == 0 && j == 0)) continue; // 금지된 경로는 안됨
                
                if (i == 0) {
                    road[i][j][0] = road[i][j-1][0] % MOD; // 왼
                } else if (j == 0) {
                    road[i][j][1] = road[i-1][j][1] % MOD; // 위
                } else {
                    if (cityMap[i][j-1] == 2) {
                        road[i][j][0] = road[i][j-1][0] % MOD;
                    } else {
                        road[i][j][0] = (road[i][j-1][0] + road[i][j-1][1]) % MOD;
                    }
                    
                    if (cityMap[i-1][j] == 2) {
                        road[i][j][1] = road[i-1][j][1] % MOD;
                    } else {
                        road[i][j][1] = (road[i-1][j][0] + road[i-1][j][1]) % MOD;
                    }
                }
            }
        }
        
        //System.out.println(Arrays.deepToString(road));
        
        return (road[m-1][n-1][0] + road[m-1][n-1][1]) % MOD;
    }
}