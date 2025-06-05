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
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        for (int n : arr) {
            if (stack.peek() != n) stack.add(n);
        }
        int n = stack.size()-1;
        int[] ans = new int[n];
        for (int i=0; i<n; i++) ans[i] = stack.get(i+1);
        return ans;
    }
}

'''


