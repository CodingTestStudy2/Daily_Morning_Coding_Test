class Solution {
  public int minimumSumSubarray(List<Integer> nums, int l, int r) {
    int n = nums.size();
    int[] prefixSum = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums.get(i - 1);
    }

    int answer = Integer.MAX_VALUE;
    for (int i = 0; i <= n - 1; i++) {
      for (int j = i; j <= n - 1; j++) {
        int len = j - i + 1;
        if (len >= l && len <= r && prefixSum[j + 1] - prefixSum[i] > 0) {
          answer = Math.min(answer, prefixSum[j + 1] - prefixSum[i]);
        }
      }
    }

    return answer == Integer.MAX_VALUE ? -1 : answer;
  }
}