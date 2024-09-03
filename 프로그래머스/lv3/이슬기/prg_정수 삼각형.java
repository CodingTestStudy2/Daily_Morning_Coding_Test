/**
* DP로 풀어야지
* [2, 7, 4, 4] 있으면 각각 [8], [8, 1], [1, 0], [0] 중 가장 큰 수 선택
*/
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        for (int i=0; i<triangle.length; i++) {
            for (int j=0; j<i+1; j++) {
                if (i==0 && j==0) continue;
                else if (j==0) {
                    triangle[i][j] += triangle[i-1][j];
                } else if (j==i) {
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }
        
        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
}