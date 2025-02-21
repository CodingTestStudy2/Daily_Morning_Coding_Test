import java.util.ArrayList;
import java.util.List;

public class LC_1018 {
    class Solution {
        public List<Boolean> prefixesDivBy5(int[] nums) {
            // 나머지만 확인하면 된다.
            List<Boolean> ans = new ArrayList<>(); 
            int remain = 0;
            for(int n : nums){
                System.out.println(remain);
                remain = ((remain << 1 + n) % 5);
                ans.add(remain==0);
            }
            return ans;
        }
    }
}