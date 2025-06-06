# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

class Leetcode.이재훈.이재훈.Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

        if (nums[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String num : nums) sb.append(num);
        return sb.toString();
    }
}

'''



