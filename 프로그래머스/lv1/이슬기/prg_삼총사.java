/**
* {-2, 3, 0, 2, -5}
13C3 모든 경우의 수
*/
import java.util.*;

class Solution {
    int[] output = new int[3];
    int answer = 0;
    
    public int solution(int[] number) {
        combination(0, 0, number);
        
        return answer;
    }
    
    private void combination(int x, int start, int[] number) {
        if (x == 3) {
            if (Arrays.stream(output).sum() == 0) {
                answer += 1;
            }
            return;
        }
        
        for (var i=start; i<number.length; i++) {
            output[x] = number[i];
            combination(x+1, i+1, number);
        }
    }
}