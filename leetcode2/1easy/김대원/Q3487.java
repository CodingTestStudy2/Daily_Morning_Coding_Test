class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        int[] prefix = new int[nums.length + 1];
        prefix[1] = nums[0];
        set.add(nums[0]);

        for (int i = 2; i <= nums.length; i++) {
            if (set.add(nums[i - 1])) {
                if (prefix[i - 1] < 0) prefix[i] = nums[i - 1];
                else prefix[i] = prefix[i - 1] + nums[i - 1];
            } else {
                prefix[i] = prefix[i - 1];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) max = Math.max(max, prefix[i]);
        return max;
    }
}