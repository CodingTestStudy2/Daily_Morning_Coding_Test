# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

class Solution {
    public long solution(int price, int money, int count) {
        long total = 0;
        for (int i=1; i<count+1; i++) total += price*i;
        return money - total > 0? 0: total-money;
    }
}

'''


