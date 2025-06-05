# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    새로운 병 = (병 / a * b) + (병 % a);
2. 시간복잡도 :
    O(n)
3. 자료구조 :
    -

<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    public int solution(int a, int b, int n) {
        int ans = 0;
        while (n >= a){
            int exchange = (n / a) * b;
            ans += exchange;
            n = exchange + n % a;
        }
        return ans;
    }
}

'''


