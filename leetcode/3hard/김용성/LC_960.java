import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.min;

public class LC_960 {
    class Solution {
        public static final int NUMBER_RANGE = 'z' + 1;

        public int minimumOperations(List<Integer> nums) {
            int[] dp = new int[NUMBER_RANGE + 1];
            Arrays.fill(dp, nums.size());

            for (int number : nums) {
                dp[number]--;
                for (int i = 1; i < 'z' - 'a' + 1; i++){
                    dp[i] = Math.min(dp[i], dp[i-1]);
                }
            }

            return dp[3];
        }
    }
}
