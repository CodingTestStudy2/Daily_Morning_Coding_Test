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
    boolean solution(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)){
                if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
'''
