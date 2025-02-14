public class LC_396 {
    class Solution {
        public int maxRotateFunction(int[] nums) {
            int len = nums.length;
            int totalSum = 0;
            int dp = 0;
            for(int i=0; i<len; i++){
                totalSum += nums[i];
                dp += nums[i]*i;
            }
            
            int ans = dp;
            int lastIdx = len-1;
            for(int i=1; i<len; i++){
                dp = dp + totalSum - nums[lastIdx]*len;
                ans = Math.max(ans, dp);
                lastIdx--;
            }
            return ans;
        }
    }
}
