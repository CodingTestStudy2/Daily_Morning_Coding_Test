# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

class Leetcode.이재훈.이재훈.Solution {
    boolean solution(String s) {
        int p = 0, y = 0;
        for (char c : s.toCharArray()) {
            char lower = Character.toLowerCase(c);
            if (lower == 'p') p++;
            else if (lower == 'y') y++;
        }
        return p == y;
    }
}
'''



