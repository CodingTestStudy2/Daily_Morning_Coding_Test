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
    public long solution(int price, int money, int count) {
        long total = 0;
        for (int i=1; i<count+1; i++) total += price*i;
        return money - total > 0? 0: total-money;
    }
}

'''

def solution(price, money, count):
    return max(0, sum(price * (i + 1) for i in range(count)) - money)

