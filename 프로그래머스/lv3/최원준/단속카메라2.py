# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''

'''
import java.util.*;

class Leetcode.이재훈.Solution {
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