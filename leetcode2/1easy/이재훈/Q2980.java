package Leetcode.이재훈;

/*
1. 아이디어 :
 - 비트 연산으로 뒷자리가 0 인 즉 짝수의 카운트를 하고
 -  두개의 숫자를 비트 연산했을때 결과값이 이진수 푱현이 0 으로 끝나는지 확인
 - 짝수 2개로 할시 무조건 짝수로 나옴
2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

import java.util.Arrays;

public class Q2980 {
    class Solution {
        public boolean hasTrailingZeros(int[] nums) {

            int count = 0;
            for(int num : nums) {
                if((num & 1) == 0) { // find the even num
                    count++;
                    if(count>= 2) { // if there are more than two even nums, then return true;
                        return true;
                    }
                }
            }
            return false;
        }
    }
}