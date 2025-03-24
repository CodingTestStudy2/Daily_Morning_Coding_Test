// 1. 아이디어 : 완전 탐색
// 2. 시간복잡도 : O(N^3)
// 3. 자료구조/알고리즘 : 완전 탐색

import java.util.*;

class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;

        long max = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    long result = ((long) nums[i] - nums[j]) * (long) nums[k];
                    max = Math.max(max, result);
                }
            }
        }

        return max;
    }
}