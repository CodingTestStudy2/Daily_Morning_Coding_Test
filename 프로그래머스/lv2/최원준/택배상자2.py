# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :


import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int front = 1;

        for (int toBeLoaded : order) {
            if (front <= toBeLoaded) {
                while (front < toBeLoaded) {
                    stack.push(front);
                    front++;
                }
                front++;
                ans++;
            } else {
                if (!stack.isEmpty() && stack.pop() == toBeLoaded){
                    ans++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
'''


