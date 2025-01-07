import java.util.Arrays;

public class LC_462 {
    public int minMoves2(int[] nums) {
        // 중앙값 : 편차를 최소화
        Arrays.sort(nums);

        int median = nums[nums.length / 2];
        int ans = 0;
        for(int n :nums){
            ans += Math.abs(median - n);
        }
        return ans;
    }
}
