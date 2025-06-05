# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    public boolean solution(int x) {
        int posTotal = 0;
        for (char c : String.valueOf(x).toCharArray()) {
            posTotal += Integer.parseInt(c+"");
        }
        return x%posTotal == 0;
    }
}
'''



