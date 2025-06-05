# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(n)
3. 자료구조 :


<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    public int solution(int[] a, int[] b) {
        int ans = 0;
        for (int i=0; i<a.length; i++) {
            ans += a[i] * b[i];
        }
        return ans;
    }
}
'''

def solution(a, b):
    return sum([a[i] * b[i] for i in range(len(a))])
