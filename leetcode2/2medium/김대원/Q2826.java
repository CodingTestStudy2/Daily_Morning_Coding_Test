class Solution {
    public int minimumOperations(List<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int fix = nums.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (fix >= nums.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
        }

        return n - Arrays.stream(dp).max().getAsInt();
    }
}

// 2 1 3 2 1
// (1, 2, 1), (2, 3, 2)