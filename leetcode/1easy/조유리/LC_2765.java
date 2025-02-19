public class LC_2765 {
    class Solution {
        public int alternatingSubarray(int[] nums) {
            int len = nums.length;
            int ans = -1;
            int[] inc = new int[len]; 
            int[] dec = new int[len]; 
            inc[0] = 0; dec[0] = 1;
            for(int i=1; i<len; i++){
                if(nums[i] - nums[i-1] == 1){
                    inc[i] = dec[i-1] + 1;
                    dec[i] = 1;
                    ans = Math.max(ans, inc[i]);
                }
                else if(nums[i] - nums[i-1] == -1){
                    dec[i] = inc[i-1] + 1;
                    inc[i] = 0;
                    ans = Math.max(ans, dec[i]);
                }
                else{
                    inc[i] = 0;
                    dec[i] = 1;
                }
            }
            
            return ans == 1 ? -1 : ans;
        }
    }
}