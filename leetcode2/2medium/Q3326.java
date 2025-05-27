/*
1. 아이디어 :
- 뒤에서 부터 cur <= prev 는 non-decreasing 이여서 스킵
- cur의 제일 큰 divisor 로 나눠주면서 prev까지 보다 작게 줄여준다.
- 하면서 divisor이 -1 이거나 1인 경우 -1로 처리
- cur을 나눈 값으로 수정한다.
- 마지막으로 나눈 operation 숫자를 반환한다.

2. 시간복잡도 :
O( n + m )
3. 자료구조/알고리즘 :
- / caching
 */

import java.util.*;

public class Q3326 {
    class Solution {
        Map<Integer, Integer> memo = new HashMap<>();
        public int minOperations(int[] nums) {

            int countOfOperations = 0;

            for(int i = nums.length - 2; i>=0; i--) {
                int cur = nums[i];
                int prev = nums[i+1];

                if(cur <= prev) continue;

                while(cur > prev) {
                    int divisor = findTheDivisor(cur);
                    if(divisor == -1 || divisor == 1) return -1;
                    cur /= divisor;

                    countOfOperations++;
                }

                nums[i] = cur; // updated with divided num
            }

            return countOfOperations;
        }

        public int findTheDivisor(int cur) {
            if(memo.containsKey(cur)) return memo.get(cur);
            for(int i = cur/2; i>=1; i--) {
                if(cur % i == 0) {
                    memo.put(cur, i);
                    return i;
                }
            }
            return -1;
        }
    }
}
