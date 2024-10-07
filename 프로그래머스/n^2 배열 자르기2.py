# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    int[] ans;
    int idx;
    public int[] solution(int n, long left, long right) {
        idx = 0;
        ans = new int[(int)(right-left)+1];
        for (long i=left; i<=right; i++){
            long row = i / n;
            long col = i % n;
            ans[idx] = (int)Math.max(row, col)+1;
            idx++;
        }
        return ans;
    }
}

'''


