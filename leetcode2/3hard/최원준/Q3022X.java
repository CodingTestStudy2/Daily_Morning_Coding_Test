package Leetcode;

/*
1. 아이디어 :

2. 시간복잡도 :

3. 자료구조/알고리즘 :
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q3022X {
    class Solution {
        int n;
        int maxLength = 0;
        public String[] convert(int[] nums) {
            String[] ans = new String[n];
            for (int i=0; i<n; i++) {
                int num = nums[i];
                String bin = Integer.toBinaryString(num);
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<maxLength-bin.length(); j++) sb.append("0");
                sb.append(bin);
                ans[i] = sb.toString();
            }
            return ans;
        }
        public int minOrAfterOperations(int[] nums, int k) {
            n = nums.length;
            for (int num : nums) {
                maxLength = Math.max(maxLength, Integer.toBinaryString(num).length());
            }
            String[] binNums = convert(nums);

            StringBuilder sb = new StringBuilder();
            for (int i=0; i<maxLength; i++) {
                int counter = 0;
                for (String binNum : binNums) {
                    if (binNum.charAt(i) == '1') counter++;
                }
                sb.append( counter <= k ? 0 : 1);
            }
            // System.out.println(sb.toString());
            return Integer.parseInt(sb.toString(), 2);

        /*
        0111
        0011
        1111
        1110
        0010
        1000

        0: 3번 O
        1: 2번 O
        2: 5번 X
        3: 3번 O
        결과: 0010 = 2

        011
        101
        011
        010
        111

        0: 2번 O
        1: 3번 X
        2: 4번 X
        결과: 011 = 3

        1010
        0111
        1010
        0011
        1001
        1110
        1001
        0100

        0: 적어도 5번 X
        1: 적어도 3번 X
        2: 적어도 5번 X
        3: 적어도 4번 X
        결과: 1111=15
        */
        }
    }
}
