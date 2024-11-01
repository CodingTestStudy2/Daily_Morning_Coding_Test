# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<int[]> stack = new Stack<>(); // index, value

        for (int i=0; i<n; i++){
            while (!stack.isEmpty() && stack.peek()[1] < numbers[i]) {
                ans[stack.pop()[0]] = numbers[i];
            }
            stack.add(new int[]{i, numbers[i]});
        }
        return ans;
    }
}

'''


