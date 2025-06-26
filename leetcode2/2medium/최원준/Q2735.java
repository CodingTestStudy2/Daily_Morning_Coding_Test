package Leetcode.최원준;

/*
1. 아이디어 :


2. 시간복잡도 :
O( )

3. 자료구조/알고리즘 :

 */

public class Q2735 {
    class Solution {
        public long minCost(int[] nums, int x) {
            int n = nums.length;
            int[] minVals = nums.clone();
            long ans = Long.MAX_VALUE;

            for (int change = 0; change < n; change++) {
                long totalCost = 0;
                for (int i=0; i<n; i++) {
                    int idx = (i + change) % n;
                    minVals[i] = Math.min(minVals[i], nums[idx]);
                    totalCost += minVals[i];
                }
                totalCost += (long)change * x;
                ans = Math.min(ans, totalCost);
            }
            return ans;
        }
    }
}
