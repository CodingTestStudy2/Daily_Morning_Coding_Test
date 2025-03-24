// 1. 아이디어 :
// 2. 시간복잡도 : O(N)
// 3. 자료구조/알고리즘 : dp..? 공식..?

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] originPrefix = new int[n];
        originPrefix[0] = nums[0];
        int originSum = nums[0];
        for (int i = 1; i < n; i++) {
            int currentSum = originPrefix[i - 1] + nums[i];
            if (currentSum < originPrefix[i - 1]) originPrefix[i] = nums[i];
            else originPrefix[i] = Math.max(originPrefix[i - 1] + nums[i], nums[i]);
        }
        int originMax = Arrays.stream(originPrefix).max().getAsInt();

        int[] subPrefix = new int[n * 2];
        subPrefix[0] = nums[0];
        int subSum = nums[0];
        for (int i = 1; i < n; i++) {
            int currentSum = subPrefix[i - 1] + nums[i];
            if (currentSum < subPrefix[i - 1]) subPrefix[i] = nums[i];
            else subPrefix[i] = Math.max(subPrefix[i - 1] + nums[i], nums[i]);
        }
        for (int i = n; i < n * 2; i++) {
            int currentSum = subPrefix[i - 1] + nums[i - n];
            if (currentSum < subPrefix[i - 1]) subPrefix[i] = nums[i - n];
            else subPrefix[i] = Math.max(subPrefix[i - 1] + nums[i - n], nums[i - n]);
        }

        int subMax = Arrays.stream(subPrefix).max().getAsInt();
        return Math.max(originMax, subMax);
    }
}