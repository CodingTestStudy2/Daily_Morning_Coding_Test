// 시간 부족
class Solution
{
    public int solution(String s)
    {
        int st = 0;
        int en = s.length();
        
        int ans = 0;
        while (en > 0) {
            String str = s.substring(st, en);
            if (isPalinDrome(str.toCharArray())) {
                System.out.println(str);
                ans = str.length();
            }
            --en;
        }
        return ans;
    }
    boolean isPalinDrome(char[] s) {
        int l = 0;
        int r = s.length - 1;
        
        while (l <= r) {
            if (s[l] == s[r]) {
                ++l;
                --r;
            }
            else
                return false;
        }
        return true;
    }
}
