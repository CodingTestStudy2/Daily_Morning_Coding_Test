/**
문자열의 길이 4, 6
*/

class Solution {
    public boolean solution(String s) {
        int s_cnt = s.length();
        
        if (s_cnt == 4 || s_cnt == 6) {
            for (var i=0; i<s_cnt; i++) {
                int a = (int) s.charAt(i);
                if (48 > a || a > 58) {
                    return false;
                }
            }
            return true;
        }
        
        return false;
    }
}