# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    public long solution(long n) {
        ArrayList<Character> nums = new ArrayList<>();
        for (char num : String.valueOf(n).toCharArray()) {
            nums.add(num);
        }
        Collections.sort(nums, (a,b) -> b-a);
        StringBuilder sb = new StringBuilder();
        for (char num : nums) {
            sb.append(num);
        }
        return Long.parseLong(sb.toString());
    }
}
'''



