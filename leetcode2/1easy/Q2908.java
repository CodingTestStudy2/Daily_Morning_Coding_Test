package Leetcode;

/*
1. 아이디어 :

 - 완전탐색으로 처리

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

public class Q2908 {
    class Solution {
        public int minimumSum(int[] nums) {

            int length = nums.length;

            int minValue = Integer.MAX_VALUE;
            int res = -1;

            for(int i = 0; i < length; i++) {
                for(int j = i+1; j<length; j++) {
                    for(int k = j+1; k<length; k++) {
                        if(nums[i] < nums[j]  && nums[j] > nums[k]) {
                            int sum = nums[i] + nums[j] + nums[k];
                            if(minValue > sum) {
                                // System.out.println("i : " + i + ", j : " + j + ", k : " + k);
                                res = nums[i] + nums[j] + nums[k];
                                minValue = sum;
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
}