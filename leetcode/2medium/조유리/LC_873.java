import java.util.HashSet;
import java.util.Set;

public class LC_873 {
    class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            int ans = 0;
            Set<Integer> nums = new HashSet<>();
            for(int a : arr) nums.add(a);
            for(int i=0; i<arr.length; i++){
                for(int j=0; j<i; j++){
                    int cnt = 2;
                    int f1 = arr[j];
                    int f2 = arr[i];
                    while(nums.contains(f1+f2)){
                        cnt++;
                        int tmp = f2;
                        f2 = f2+f1;
                        f1 = tmp;
                    }
                    ans = Math.max(ans, cnt);
                }
            }
            return ans < 3 ? 0 : ans;
        }
    }
}