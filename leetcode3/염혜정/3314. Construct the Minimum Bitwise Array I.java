// O(n)

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] result = new int[nums.size()];
        for (int i = 0; i<nums.size(); i++) {
            int num = nums.get(i);
            if (num == 2) result[i] = -1;
            else {
                for (int k = 1; k<32; k++) {
                    if (((num >> k) & 1) == 0) {
                        result[i] = num ^ (1 << (k-1));
                        break;
                    }
                }
            }
        }
        return result;
    }
}
