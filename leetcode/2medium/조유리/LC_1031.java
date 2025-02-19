public class LC_1031 {
    class Solution {
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            int len = nums.length;
            int[] totalSum = new int[len+1];
            for(int i=1; i<len+1; i++){
                totalSum[i] = totalSum[i-1] + nums[i-1];
            }
            int ans = -1;
            for(int i = firstLen; i<=len; i++){
                int firstSum = totalSum[i] - totalSum[i-firstLen];
                int secondSum = Math.max(findMaxSum(totalSum, 1, i-firstLen, secondLen), findMaxSum(totalSum, i+1, len, secondLen));
                ans = Math.max(ans, firstSum+secondSum);
            }
            return ans;
        }
    
        public int findMaxSum(int[] totalSum, int start, int end, int len){
            int ans = -1;
            if(end-start+1 < len) return -1;
            for(int i=start+len-1; i<=end; i++){
                ans = Math.max(ans, totalSum[i] - totalSum[i-len]);
            }
            return ans;
        }
    
    }
}
