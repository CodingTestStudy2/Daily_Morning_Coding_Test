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
    public int solution(String s) {
        var stack = new Stack<>();
        for (Character c : s.toCharArray()){
            if (stack.isEmpty() || stack.peek() != c){
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty()? 1:0;
    }
}'''