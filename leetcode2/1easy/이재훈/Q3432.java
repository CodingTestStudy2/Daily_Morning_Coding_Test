package Leetcode.이재훈;

/*
1. 아이디어 :

 - prefixsum으로 처리

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- / prefixsum
 */

public class Q3432 {
    class Solution {
        public int countPartitions(int[] nums) {

            int[] prefix = new int[nums.length+1];
            prefix[0] = 0;

            for(int i = 1;i <=nums.length;i++) {
                prefix[i] = prefix[i-1] + nums[i-1];
            }
            int count =0;
            for(int i = 1; i<nums.length;i++) {
                if(((prefix[i]-prefix[0]) - (prefix[nums.length]-prefix[i])) % 2 ==0) {
                    count++;
                }
            }
            return count;
        }
    }
}