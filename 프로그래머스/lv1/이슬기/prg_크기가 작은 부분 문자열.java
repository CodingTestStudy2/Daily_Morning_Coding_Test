/**
t, p 부분문자열
슬라이딩 윈도우
*/
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int n = t.length();
        int m = p.length();
        
        String s = t.substring(0, m);
        long num = Long.parseLong(s);
        
        if (num <= Long.parseLong(p)) answer++;
        
        for (var i=m; i<n; i++) {
            s += String.valueOf(t.charAt(i));
            s = s.substring(1, m+1);
            num = Long.parseLong(s);
            
            if (num <= Long.parseLong(p)) answer++;
        }
        
        return answer;
    }
}