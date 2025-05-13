package Leetcode;

/*
1. 아이디어 :

- 받은 배열을 소팅하여 prefix 가 >0 때 체크

2. 시간복잡도 :
O( n log n)
3. 자료구조/알고리즘 :
- /
 */

public class Q1154 {
    class Solution {
        public int maxScore(int[] nums) {
            Integer[] arr = new Integer[nums.length];

            for(int i = 0; i< nums.length;i++) {
                arr[i] = nums[i];
            }

            Arrays.sort(arr, Collections.reverseOrder());

            long prefixSum = 0;
            int count = 0;

            for (int num : arr) {
                prefixSum += num;
                if (prefixSum > 0) count++;
                else break;
            }

            return count;
        }
    }
}