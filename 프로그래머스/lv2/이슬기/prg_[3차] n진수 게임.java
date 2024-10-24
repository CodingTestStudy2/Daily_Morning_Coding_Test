/**
* N진수 게임
0, 1, .... 9
0 1 10 11 100
*/
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuffer answer = new StringBuffer();
        String[] number = new String[t * m];
        int cnt = 0, idx = 0;
        
        while (true) {
            if (idx >= t * m) break;
            
            String a = Integer.toString(cnt, n);
            for (var i=0; i<a.length(); i++) {
                if (idx >= t * m) break;
                
                number[idx] = String.valueOf(a.charAt(i)).toUpperCase();
                idx++;
            }
            cnt++;
        }
        
        for (var i=0; i<t; i++) {
            answer.append(number[i * m + (p - 1)]);
        }
        
        return answer.toString();
    }
}