package Leetcode;

/*
1. 아이디어 :

- 분할정복으로 k보다 작은 알파뱃을 만날때 그 값을 기준으로 나눠서 처리한다.
- left, right 을 분열하면서 계산후 제일 큰것을 반환한다.

2. 시간복잡도 :
O( n  )
3. 자료구조/알고리즘 :
- / divide and conquer
 */

import java.util.*;

public class Q395 {
    class Solution {
        public int longestSubstring(String s, int k) {
            return helper(s,0,s.length(), k);
        }

        public int helper(String s, int start, int end, int k) {
            if(end - start < k) return 0;

            int[] count = new int[26];
            for(int i = start; i<end;i++) {
                count[s.charAt(i) - 'a']++;
            }

            for(int i = start; i<end;i++) {
                if(count[s.charAt(i) - 'a'] < k) {
                    int left =helper(s, start, i, k);
                    int right = helper(s, i+1, end, k);
                    return Math.max(left,right);
                }
            }
            return end - start;
        }
    }
}