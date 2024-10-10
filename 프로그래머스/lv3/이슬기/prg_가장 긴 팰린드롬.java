/**
abcdcba
abcdcb
abcdc
하나씩 검사하기
*/
class Solution
{
    public int solution(String s)
    {
        int n = s.length();
        int answer = 1;
        int mark = 0;
        
        while (true) {
            if (answer >= n - mark) break;
            
            for (var i=n-1; i>mark; i--) {
                boolean isPalindrome = true;
                int left = mark;
                for (int right = i; left <= right; left++, right--) {
                    if (s.charAt(left) != s.charAt(right)) {
                        isPalindrome = false;
                        break;
                    }
                }
                
                if (isPalindrome) {
                    answer = Math.max(i-mark+1, answer);
                    break;
                }
            }
            
            mark += 1;
        }

        return answer;
    }
}