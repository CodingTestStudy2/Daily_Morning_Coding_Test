# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :


class Solution {
    public String solution(String s) {
        int mid = (int)Math.floor((float)s.length()/2);
        if (s.length()%2 == 0) return s.substring(mid-1, mid+1);
        return s.substring(mid, mid+1);
    }
}
'''


