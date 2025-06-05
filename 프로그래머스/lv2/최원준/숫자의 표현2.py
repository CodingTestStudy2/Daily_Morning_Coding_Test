# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''

'''
import java.util.*;
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    public int solution(int n) {
        int left = 1, right=1, total=1, ans=1;
        while (right < n){
            if (total == n) {
                ans++;
                total -= left;
                left++;
            } else if (total < n) {
                right++;
                total += right;
            } else if (total > n) {
                total -= left;
                left++;
            }
        }
        return ans;
    }
}'''