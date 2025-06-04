# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''

'''
class Leetcode.이재훈.이재훈.Solution {
    public int solution(int n) {
        int counts = Integer.bitCount(n);
        while (true) {
            n++;
            if (counts == Integer.bitCount(n)) {
                return n;
            }
        }
    }
}'''


