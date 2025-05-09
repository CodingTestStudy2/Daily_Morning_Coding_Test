class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int answer = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];

            if (num >= k) {
                answer = Math.min(answer, 1);
                return answer;
            }

            for (int j = i + 1; j < n; j++) {
                num = num | nums[j];
                if (num >= k) {
                    answer = Math.min(answer, j - i + 1);
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}