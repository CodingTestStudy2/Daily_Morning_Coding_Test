import java.util.*;
class Solution {
    static int hmax = Integer.MIN_VALUE;
    static int wmax = Integer.MIN_VALUE;
    
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i=0; i<sizes.length; i++){
            Arrays.sort(sizes[i]);
            hmax = Math.max(hmax,sizes[i][0]);
            wmax = Math.max(wmax,sizes[i][1]);
        }
        
        answer = hmax * wmax;
        
        return answer;
    }
}
