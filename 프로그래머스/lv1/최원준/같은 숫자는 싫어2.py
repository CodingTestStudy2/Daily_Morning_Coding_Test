# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

class Leetcode.이재훈.Solution {
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


