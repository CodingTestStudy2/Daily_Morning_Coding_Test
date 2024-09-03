import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        for(int i=triangle.length-2; i>=0; i--){
            for(int j=0; j<triangle[i].length; j++){
                int left = triangle[i+1][j];
                int right = triangle[i+1][j+1];
                triangle[i][j] += Math.max(left, right);
            }
        }
        answer = triangle[0][0];
        return answer;
    }
}
