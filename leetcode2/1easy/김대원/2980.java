class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                String result =  Integer.toString(nums[i] | nums[j], 2);
                if (result.charAt(result.length() - 1) == '0') return true;
            }
        }

        return false;
    }
}