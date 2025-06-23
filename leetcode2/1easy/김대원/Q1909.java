class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int prev = nums[0];
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur <= prev) {
                if (i == 1) {
                    prev = cur;
                } else if (i > 1) {
                    if (i >= 2 && nums[i - 2] < cur) prev = cur;
                }
                cnt++;
            } else {
                prev = cur;
            }

            if (cnt == 2) return false;
        }

        return true;
    }
}
