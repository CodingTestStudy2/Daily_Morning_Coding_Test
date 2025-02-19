public class LC2765 {
    public int alternatingSubarray(int[] nums) {
        int ret = -1;
        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            while (j + i < nums.length) {
                if (j % 2 == 0 && nums[i] == nums[i + j]) {
                } else if (j % 2 == 1 && nums[i] + 1 == nums[i + j]) {
                }
                else{
                    break;
                }
                j++;
            }
            if(j == 1) j = -1;
            ret = Math.max(ret, j);
        }
        return ret;
    }
}
