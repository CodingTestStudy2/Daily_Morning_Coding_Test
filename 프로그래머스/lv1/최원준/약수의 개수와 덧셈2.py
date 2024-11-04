# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :


class Solution {
    public int solution(int left, int right) {
        int ans = 0;
        for (int i=left; i<=right; i++) ans += (int)Math.pow((int)Math.sqrt(i),2) == i? -i:i;
        return ans;
    }
}
'''


