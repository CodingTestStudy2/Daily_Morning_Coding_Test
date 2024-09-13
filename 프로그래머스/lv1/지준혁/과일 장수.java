/*
아이디어: 정렬
시간복잡도: O(nlogn)
자료구조:
*/
import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int n = score.length;
        int ans = 0;
        for (int i = n; i >= 0; i -= m) {
            if (i - m < 0) break;
            ans += score[i - m] * m;
        }
        return ans;
    }
}
