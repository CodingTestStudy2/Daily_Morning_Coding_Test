import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC_3238 {
    class Solution {
        public int winningPlayerCount(int n, int[][] pick) {
            Arrays.sort(pick, (a, b) -> {
                if(a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });

            Set<Integer> set = new HashSet<>();
            int prevPlayer = 0;
            int prevColor = -1;
            int cnt = 1;
            for(int[] p : pick){
                if(p[0] != prevPlayer){
                    cnt = 1;
                    prevColor = -1;
                }

                if(prevColor == p[1]){
                    cnt++;
                }
                else{
                    cnt = 1;
                }

                prevPlayer = p[0];
                prevColor = p[1];
                
                if(cnt > p[0]) set.add(p[0]);
            }
            return set.size();
        }
    }
}
