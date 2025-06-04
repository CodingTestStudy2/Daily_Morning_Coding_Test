package Leetcode.이재훈;

/*
1. 아이디어 :
 -
2. 시간복잡도 :
O( n^2 )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

public class Q2760 {
    class Solution {
        public int longestAlternatingSubarray(int[] nums, int threshold) {

            int maxLength = 0;
            int length =0;

            for(int i= 0; i<nums.length; i++) {
                if(nums[i] % 2 == 0 && nums[i] <= threshold) {
                    length = 1;
                    maxLength = Math.max(maxLength,length);
                    for(int j = i+1; j<nums.length;j++ ) {
                        if(nums[j] % 2 == nums[j-1] % 2 || nums[j] > threshold) break;
                        // System.out.println("nums[j] : " + nums[j]);
                        // System.out.println("j : " + j);
                        // System.out.println("i : " + i);
                        length = j- i + 1;
                        maxLength = Math.max(maxLength,length);
                    }
                    //System.out.println();
                }
            }
            return maxLength;
        }
    }
}