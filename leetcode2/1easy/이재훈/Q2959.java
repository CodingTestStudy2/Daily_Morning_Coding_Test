package Leetcode.이재훈;

/*
1. 아이디어 :

 - 각 인덱스를 이진법으로 변환 후 k만큼의 1이 있는경우 해당 인덱스에 있는 수만큼 더해서 값 반환

2. 시간복잡도 :
O( n * m )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

import java.util.List;

public class Q2959 {
    class Solution {
        public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
            int sum = 0;
            for(int i = 0; i <nums.size(); i++) {
                int count = checkNumOfOnes(i);
                if(count == k) {
                    sum += nums.get(i);
                }
            }

            return sum;
        }

        public int checkNumOfOnes(int x) {
            String bi = Integer.toBinaryString(x);
            int count = 0;
            for(int i = 0; i< bi.length(); i++) {
                if(bi.charAt(i) == '1') count++;
            }
            return count;
        }
    }
}