import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.lang.Integer.min;

public class LC_2826 {
    class Solution {
        public static final int NUMBER_RANGE = 3;
        public int minimumOperations(List<Integer> nums) {
            int[] dp = new int[NUMBER_RANGE + 1];
            Arrays.fill(dp, nums.size());

            for(int number : nums){
                dp[number]--;
                dp[2] = Math.min(dp[1],dp[2]);
                dp[3] = Math.min(dp[2],dp[3]);
            }

            return dp[3];
        }
    }
}
