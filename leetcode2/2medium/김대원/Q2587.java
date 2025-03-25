// 1. 아이디어 : 누적합을 생성하고 양수 판별
// 2. 시간복잡도 : O(log N)
// 3. 자료구조/알고리즘 : 누적합

class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[n - 1];
        int answer = 0;
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[n - i - 1];
            if (prefixSum[i] > 0) answer++;
        }

        return prefixSum[0] > 0 ? answer + 1 : answer;
    }
}