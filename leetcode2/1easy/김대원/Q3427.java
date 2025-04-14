class Solution {
    public int subarraySum(int[] nums) {
        int n = nums.length;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = Math.max(0, i - nums[i]); j <= i; j++) {
                answer += nums[j];
            }
            System.out.println(answer);
        }

        return answer;
    }
}