# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    public int solution(int[] q1, int[] q2) {
        Deque<Integer> queue1 = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>();

        long total = 0;
        long q1Total = 0;
        for (int i=0; i<q1.length; i++) {
            queue1.addLast(q1[i]);
            queue2.addLast(q2[i]);
            total += q1[i] + q2[i];
            q1Total += q1[i];
        }

        if (total % 2 != 0) return -1;

        long mid = total / 2;
        int ans = 0;
        for (int i=0; i<q1.length * 3; i++) {
            if (q1Total == mid) return ans;

            if (q1Total > mid) {
                int num = queue1.pollFirst();
                queue2.addLast(num);
                q1Total -= num;
            } else {
                int num = queue2.pollFirst();
                queue1.addLast(num);
                q1Total += num;
            }
            ans++;
        }

        return -1;

    }
}
'''



