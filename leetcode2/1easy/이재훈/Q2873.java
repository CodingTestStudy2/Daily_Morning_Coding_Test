package Leetcode.이재훈;

/*
1. 아이디어 :

for 문 3개를 돌려서 값을 찾는다 brute force.

2. 시간복잡도 :
O( n**3 )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

public class Q2873 {
    class Solution {
        long maxValue = 0;

        for(int i = 0; i< nums.length-2 ;i++) {
            for(int j = i + 1; j <nums.length-1;j++) {
                for(int k = j + 1; k<nums.length; k++) {
                    long comp = ((long)nums[i] - (long)nums[j]) * (long)nums[k];

                    maxValue = Math.max(maxValue, comp);
                }
            }
        }
        return maxValue > 0 ? maxValue : 0;
    }
}