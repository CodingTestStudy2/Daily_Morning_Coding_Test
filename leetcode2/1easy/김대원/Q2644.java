class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int score = Integer.MIN_VALUE;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < divisors.length; i++) {
            int divisor = divisors[i];
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % divisor == 0) cnt++;
            }

            if (cnt > score || (cnt == score && divisor < answer)) {
                score = Math.max(score, cnt);
                answer = divisor;
            }
        }

        return answer;
    }
}