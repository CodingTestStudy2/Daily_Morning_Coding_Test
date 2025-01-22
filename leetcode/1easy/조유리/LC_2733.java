import java.util.Arrays;

public class LC_2733 {
    public int findNonMinOrMax(int[] nums) {
        Arrays.sort(nums);
        int ans = nums.length > 2 ? nums[1] : -1;
        return ans;
    }
}