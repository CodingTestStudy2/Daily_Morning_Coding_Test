/*
n진법에 맞춰서 0부터 1씩 증가시키면서
어떤 숫자를 말해야 하는지 구하기 (개수가 t*m이 될 때까지)
그 숫자 중에 p번째 차례에 말해야 하는 숫자 문자열 리턴 

2진법 0/1/10/11/100/101/110/111/...
3진법 0/1/2/10/11/12/20/21/22/100/...
...
16진법 
*/
import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int now = 0;
        
        // 문자열의 길이가 t*m이 될 때까지
        // 문자열에 숫자 추가하기
        while(sb.toString().length() < t*m) {
            // 10진수 -> n진수
            sb.append(Integer.toString(now, n));
            now++;
        }
        
        String total = sb.substring(0, t*m).toUpperCase();
        String answer = "";
        
        // m명 중에 p번째 차례에 맞게 부분 문자열 리턴
        for(int i = 0; i < t*m; i += m){
            int idx = i + (p-1);
            answer += total.charAt(idx);
        }
        
        return answer;
    }
}