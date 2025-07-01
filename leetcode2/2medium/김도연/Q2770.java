package Leetcode.김도연;

import java.util.Arrays;

public class Q2770 {
    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == -1) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) <= target)
                    dp[j] = Math.max(dp[j], dp[i] + 1);
            }
        }

        return dp[nums.length-1];
    }
}