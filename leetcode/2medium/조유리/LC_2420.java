import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC_2420 {
    class Solution {
        public List<Integer> goodIndices(int[] nums, int k) {
            int n = nums.length;
            // 누적합
            int[] preInc = new int[n];
            int[] preDec = new int[n];
            for(int i=1; i<n; i++){
                // 연속하는 2개가 오름차순 인지 확인 (1: 오름차순, 0:오름차순 아님)
                int inc = nums[i] >= nums[i-1] ? 1 : 0;
                preInc[i] = preInc[i-1] + inc;

                // 연속하는 2개가 내림차순 인지 확인 (1: 내림차순, 0:내림차순 아님)
                int dec = nums[i] <= nums[i-1] ? 1 : 0;
                preDec[i] = preDec[i-1] + dec;
            }
            List<Integer> ans = new ArrayList<>();
            for(int i=k; i<n-k; i++){
                if(k==1){
                    ans.add(i); 
                } 
                else{
                    if(((preDec[i-1] - preDec[i-k]) == k-1) && ((preInc[i+k] - preInc[i+1]) == k-1)){
                        ans.add(i);
                    }
                }
            }
            Collections.sort(ans);
            return ans; 
        }
    }
}