package 이재훈;

/*
1. 아이디어 :


2. 시간복잡도 :
O( n)
3. 자료구조/알고리즘 :
- /
 */

import java.util.HashSet;
import java.util.Set;

public class Q822 {
    class Solution {
        public int flipgame(int[] fronts, int[] backs) {

            // 1 2 4 4 7
            // 1 3 4 1 3
            // (1,1), (4,4) -> cant not be a good Integer
            // (2,3,7) can be a good Integer;
            // 2 is the minimum possible good integer

            Set<Integer> impossibleSet = new HashSet<>();

            for (int i = 0; i < fronts.length; i++) {
                if (fronts[i] == backs[i]) {
                    impossibleSet.add(fronts[i]);
                }
            }

            int res = Integer.MAX_VALUE;

            for(int i = 0; i < fronts.length; i++) {
                if(!impossibleSet.contains(backs[i])) {
                    res = Math.min(res, backs[i]);
                }
                if(!impossibleSet.contains(fronts[i])) {
                    res = Math.min(res,fronts[i]);
                }
            }

            return res == Integer.MAX_VALUE ? 0 : res;
        }
    }
}