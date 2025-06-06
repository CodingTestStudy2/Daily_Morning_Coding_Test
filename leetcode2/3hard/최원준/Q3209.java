package Leetcode;

/*
1. 아이디어 :
memoization을 사용하여 풀수있습니다.
이전의 결과를 저장하여 중복 계산을 피합니다.

2. 시간복잡도 :
O( n * n ) 이지만, AND 특성상 n logn이됨.

3. 자료구조/알고리즘 :
해시맵 / 브루트포스 + 메모이제이션
 */

import java.util.HashMap;
import java.util.Map;

public class Q3209 {
    class Solution {
        public long countSubarrays(int[] nums, int k) {
            long ans = 0;
            Map<Integer, Integer> prev = new HashMap<>();

            for (int num : nums) {
                Map<Integer, Integer> curr = new HashMap<>();
                curr.put(num, 1);

                for (var entry : prev.entrySet()) {
                    int key = entry.getKey(), val = entry.getValue();
                    int newKey = key & num;
                    curr.put(newKey, curr.getOrDefault(newKey, 0) + val);
                }
                ans += curr.getOrDefault(k, 0);
                prev = curr;
            }
            return ans;
        }
    }
}
