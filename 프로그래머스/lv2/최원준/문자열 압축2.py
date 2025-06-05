# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    -
2. 시간복잡도 :
    O(  N * N  )
3. 자료구조 :
    -
import java.util.*;
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    public int compress(String s, int n) {
        List<String> parts = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        int count = 1;
        String last = s.substring(0, Math.min(s.length(), n));
        for (int i=n; i<s.length(); i+=n) {
            String part = s.substring(i, Math.min(s.length(), i+n));
            if (last.equals(part)) {
                count++;
            } else {
                if(count>=2) {
                    sb.append(count + last);
                } else {
                    sb.append(last);
                }

                last = part;
                count=1;
            }
        }
        if (count >= 2) {
            sb.append(count+last);
        } else {
            sb.append(last);
        }

        return sb.length();
    }
    public int solution(String s) {
        int ans = s.length();
        for (int i=1; i<s.length(); i++) {
            ans = Math.min(ans, compress(s, i));
        }
        return ans;
    }
}
'''



