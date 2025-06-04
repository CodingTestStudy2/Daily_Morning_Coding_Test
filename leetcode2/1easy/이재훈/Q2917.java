package Leetcode.이재훈;

/*
1. 아이디어 :
 - 받은 각 숫자를 binary num 으로 변경 후 카운트에다가 넣는다
 - 카운트에서 k보다 크거나 같으면 1 아님 0을 넣는다
 - 받은 스트링을 다시 int 로 변환한다.

2. 시간복잡도 :
O( n + m)
3. 자료구조/알고리즘 :
- / bit 연산
 */

public class Q2917 {
    class Solution {
        public int findKOr(int[] nums, int k) {
            // map : bit 3, bit 2, bit 1, bit 0
            int[] counts = new int[31]; // 2^^31 까지

            for(int num : nums) {
                String binary = Integer.toBinaryString(num);
                int size = binary.length();
                for(int i = 0; i < size;i++) {
                    // System.out.println(" binary.charAt(i) : " + binary.charAt(i));
                    // System.out.println("size - i - 1 : " + ((size - i) - 1));
                    counts[size - i - 1] += (binary.charAt(i) - '0');
                }
                // System.out.println();
            }
            StringBuilder sb = new StringBuilder();
            for(int i = counts.length-1; i>=0;i--) {
                sb.append(counts[i] >= k ? '1':'0');
            }

            return Integer.parseInt(sb.toString(), 2);
        }
    }
}

