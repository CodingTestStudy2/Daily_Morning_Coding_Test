class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int answer = 0;
        for (int i = 1; i < n; i++) {
            int result = Math.abs(prefixSum[n] - prefixSum[i] * 2);
            if (result % 2 == 0) answer++;
        }

        return answer;
    }
}