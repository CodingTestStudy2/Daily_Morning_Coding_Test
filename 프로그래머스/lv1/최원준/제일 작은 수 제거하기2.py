# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Leetcode.이재훈.Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};
        int[] ans = new int[arr.length-1];
        int cmin = Integer.MAX_VALUE;
        for (int num : arr) cmin = Math.min(cmin, num);
        int ansIdx = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] != cmin) {
                ans[ansIdx++] = arr[i];
            }
        }
        return ans;
    }
}
'''


