public class LC_121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int days = prices.length;
            int[] max = new int[days];
            max[days-1] = prices[days-1];
            for(int i=days-2; i>=0; i--){
                max[i] = Math.max(max[i+1], prices[i]);
            }
            int ans = 0;
            for(int i=0; i<days; i++){
                ans = Math.max(ans, max[i]-prices[i]);
            }
            return ans;
        }
    }
}