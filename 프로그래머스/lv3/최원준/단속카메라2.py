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
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        var idx = 0;
        var ans =0;
        while (idx < routes.length) {
            ans++;
            var camera = routes[idx++][1];
            while (idx < routes.length && camera >= routes[idx][0]) {
                idx++;
            }
        }
        
        return ans;
    }
}'''