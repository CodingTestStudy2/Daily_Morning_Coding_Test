class Solution {
    public int minimumSum(int[] nums) {
        int answer = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int m1 = nums[i];
            for (int j = i + 1; j < n - 1; j++) {
                int m2 = nums[j];
                for (int k = j + 1; k < n; k++) {
                    int m3 = nums[k];
                    if (m1 < m2 && m3 < m2) {
                        answer= Math.min(answer, m1 + m2 + m3);
                    }
                }
            }
        }

        if (answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
}

// 8 6 1 5 3