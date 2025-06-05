# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    -
2. 시간복잡도 :
    O(    )
3. 자료구조 :
    -
import java.util.*;

<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    public int solution(int[][] targets) {
        int ans = 0;
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);

        int prev = -1;
        for (int[] target : targets) {
            int s = target[0], e = target[1];

            if (prev < s) {
                ans++;
                prev = e - 1;
            }
        }

        return ans;
    }
}

'''



