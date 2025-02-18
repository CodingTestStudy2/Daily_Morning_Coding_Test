import java.util.HashSet;
import java.util.Set;

public class LC_1539 {
    class Solution {
        public int findKthPositive(int[] arr, int k) {
            Set<Integer> set = new HashSet<>();
            for(int num : arr){
                set.add(num);
            }
            int ans = 0;
            int num = 1;
            while(k > 0){
                if(!set.contains(num)){
                    ans = num;
                    k--;
                }
                num++;
            }
            return ans;
        }
    }
}
