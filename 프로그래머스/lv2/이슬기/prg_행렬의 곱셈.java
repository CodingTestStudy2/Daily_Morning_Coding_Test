/**
2 3 2
4 2 4
3 1 4

5 4 3
2 4 1
3 1 1

10+6+6 8+12+2
*/
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length; // 열
        int m = arr2[0].length; // 행
        int[][] answer = new int[n][m];
        
        for (var i=0; i<n; i++) {
            for (var j=0; j<m; j++) {
                for (var k=0; k<arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}