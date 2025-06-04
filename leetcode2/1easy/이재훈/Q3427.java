package Leetcode.이재훈;

/*
1. 아이디어 :

- prefixsum 기법을 이용하여 prefixSum[i] - prefixSum[start-1] 처리로 합계를 구하여 반환

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

public class Q3427 {
    class Solution {
        public int subarraySum(int[] nums) {

            int length = nums.length;
            int[] prefixSum = new int[length];

            prefixSum[0] = nums[0];

            for(int i = 1; i<length;i++) {
                prefixSum[i] = prefixSum[i-1] + nums[i];
            }
            // start .. i
            // 2 3 1
            // 2 5 6
            //     6-2

            int res = prefixSum[0];
            int start = 0;
            int temp = 0;

            for(int i = 1; i<length;i++) {
                start = Math.max(0, i - nums[i]);
                temp = start == 0 ? 0 : prefixSum[start-1];
                res+= prefixSum[i] - temp;
            }

            return res;
        }
    }
}