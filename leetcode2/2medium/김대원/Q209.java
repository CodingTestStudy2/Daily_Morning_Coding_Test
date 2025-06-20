class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;
        int p1 = 0;
        long sum = 0;
        for (int p2 = 0; p2 < nums.length; p2++) {
            sum += nums[p2];

            while (sum >= target) {
                answer = Math.min(answer, p2 - p1 + 1);
                sum -= nums[p1++];
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
