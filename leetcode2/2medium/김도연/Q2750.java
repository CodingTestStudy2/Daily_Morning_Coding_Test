package Leetcode.김도연;

public class Q2750 {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int MOD = 1_000_000_007;
        int n = nums.length;
        int result = 1;
        int i = 0;

        // 처음 1 위치 찾기
        while (i < n && nums[i] == 0) {
            i++;
        }

        // 배열에 1이 없는 경우
        if (i == n)
            return 0;

        for (int j = i + 1; j < n; j++) {
            if (nums[j] == 1) {
                result = (int) ((long)result * (j-i) % MOD);
                i = j;
            }
        }

        return result;

    }
}
