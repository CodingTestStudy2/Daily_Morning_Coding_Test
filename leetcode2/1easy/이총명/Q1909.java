class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int count = 0;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i-1]) {
                count++;
                if(count > 1) return false;
            }

            if(i - 2 >= 0 && nums[i] <= nums[i-2]) {
                nums[i] = nums[i - 1];
            }
        }
        return true;
    }
}
