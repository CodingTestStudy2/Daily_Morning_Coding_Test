package Leetcode.이재훈;

/*
1. 아이디어 :
 -
2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

import java.util.Arrays;

public class Q645 {
    class Solution {
        public int[] findErrorNums(int[] nums) {
            Arrays.sort(nums);
            int dup = -1, missing = 1;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    dup = nums[i];
                }

                if(nums[i] > nums[i-1]+1) {
                    missing = nums[i-1]+1;
                }
            }

            // 마지막 숫자가 빠졌을 수도 있으므로 예외처리
            if (nums[nums.length - 1] != nums.length) {
                if (missing == 1) missing = nums[nums.length-1] +1;
            }

            return new int[]{dup, missing};
        }
    }
}