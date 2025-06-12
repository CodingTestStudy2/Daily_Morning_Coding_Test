package Leetcode.이재훈;

/*
1. 아이디어 :
 - nums[i]의 각 digit의 합과 i가 같으면 바로 i 리턴
 - 아닌경우 -1

2. 시간복잡도 :
O( n * m)
3. 자료구조/알고리즘 :
- /
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Q3550 {
    class Solution {
        public int smallestIndex(int[] nums) {
            int n = nums.length;
            for(int i = 0; i< n;i++) {
                if(i == sumUpEachDigit(nums[i])) return i;
            }
            return -1;
        }

        public int sumUpEachDigit(int num) {
            if(num < 10) return num;
            int sum = 0;
            String strNum = num + "";
            for(int i = 0; i<strNum.length(); i++) {
                sum += strNum.charAt(i) - '0';
            }
            return sum;
        }
    }
}

