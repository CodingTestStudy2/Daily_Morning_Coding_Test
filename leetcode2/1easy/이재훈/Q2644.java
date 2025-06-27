package Leetcode.이재훈;

/*
1. 아이디어 :

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

import java.util.ArrayList;
import java.util.List;

public class Q2644 {
    class Solution {
        public int maxDivScore(int[] nums, int[] divisors) {


            List<Integer> list = new ArrayList<>();
            int maxCount = -1;

            for(int i = 0; i<divisors.length; i++) {
                int count = 0;
                for(int j = 0; j<nums.length; j++) {
                    if(nums[j] % divisors[i] == 0) {
                        count++;
                    }
                }
                if(count > maxCount) {
                    maxCount = count;
                    list.clear();
                    list.add(divisors[i]);
                } else if(count == maxCount) {
                    list.add(divisors[i]);
                }
            }

            if(list.size() == 1) return list.get(0);

            int minValue = Integer.MAX_VALUE;

            for(int num : list) {
                minValue = Math.min(num,minValue);
            }
            return minValue;
        }
    }
}