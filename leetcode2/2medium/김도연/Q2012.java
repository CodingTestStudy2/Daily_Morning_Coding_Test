package Leetcode.김도연;

public class Q2012  {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] rightMin = new int[n];
        rightMin[n-1] = nums[n-1];

        // 오른쪽 최소값 전처리
        for (int i = n - 2; i > 0; i--) {
            rightMin[i] = Math.min(rightMin[i+1], nums[i]);
        }

        int ans = 0;
        int leftMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            if (leftMax < nums[i] && nums[i] < rightMin[i + 1])
                ans += 2;
            else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1])
                ans += 1;

            leftMax = Math.max(leftMax, nums[i]);
        }
        return ans;
    }
}