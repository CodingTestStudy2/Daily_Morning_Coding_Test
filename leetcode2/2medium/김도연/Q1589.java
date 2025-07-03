package Leetcode.김도연;

import java.util.Arrays;

public class Q1589 {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int MOD = 1_000_000_007;
        int n = nums.length;
        int[] count = new int[n];

        // 누적합
        for (int[] req: requests) {
            int start = req[0];
            int end = req[1];

            count[start]++;
            if (end + 1 < n)
                count[end+1]--;
        }

        for (int i = 1; i < n; i++)
            count[i] += count[i-1];

        Arrays.sort(count);
        Arrays.sort(nums);

        long result = 0L;
        for (int i = 0; i < n; i++)
            result = (result + (long)count[i] * nums[i]) % MOD;

        return (int) result;

    }
}