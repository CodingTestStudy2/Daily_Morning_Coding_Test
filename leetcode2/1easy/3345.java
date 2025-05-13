package Leetcode;

/*
1. 아이디어 :

- n 의 값의 digit의 값 곱하기가 t로 나눠지면 그 num를 return
- num 을 계속 증가하면서 확인

2. 시간복잡도 :
O( n  )
3. 자료구조/알고리즘 :
- / 완전 탐색
 */

public class Q3345 {
    class Solution {
        public int smallestNumber(int n, int t) {
            int num = n;
            while(true) {
                String s = num + "";
                int sum = 1;
                for(char c : s.toCharArray()) {
                    sum *= c - '0';
                }

                if(sum % t == 0) return num;
                num++;
            }

        }
    }
}