/**
1 2 3
2 2 3
3 3 3
*/
import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int cnt = 0;
        
        for (var i=left; i<right+1; i++) {
            var x = (int) (i / n);
            var y = (int) (i % n);
            answer[cnt] = Math.max(x, y) + 1;
            cnt++;
        }
        
        return answer;
    }
}