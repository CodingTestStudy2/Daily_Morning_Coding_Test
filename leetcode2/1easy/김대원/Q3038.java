class Solution {
    public int maxOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (n == 2) return 1;

        int answer = 0;
        int result = 0;
        for (int i = 0; i < n / 2; i++) {
            if (result == 0) {
                result = nums[i * 2] + nums[i * 2 + 1];
                answer++;
                continue;
            }

            int sum = nums[i * 2] + nums[i * 2 + 1];
            if (result == sum) answer++;
            else break;
        }

        return answer;
    }
}
