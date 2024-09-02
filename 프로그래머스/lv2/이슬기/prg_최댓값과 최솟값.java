/**
* 문자열 (최솟값) (최댓값)
*/
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int[] sArr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(sArr);
        
        String[] value = new String[]{String.valueOf(sArr[0]), String.valueOf(sArr[sArr.length-1])};
        answer = String.join(" ", value);
        
        return answer;
    }
}