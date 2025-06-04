package Leetcode.이재훈;

/*
1. 아이디어 :
 - 0 이랑 1이랑 그룹이 지어서 두개 그룹중 작은 값이 합을 계속 더해간다.

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

public class Q696 {
    class Solution {
        public int countBinarySubstrings(String s) {
            int type1 = 0;
            int type2 = 1;
            int count = 0;

            for(int i = 1; i<s.length();i++) {
                if(s.charAt(i-1) != s.charAt(i)) {
                    count += Math.min(type1, type2);
                    type1 = type2;
                    type2 = 0;
                }
                type2++;
            }

            count += Math.min(type1, type2);
            return count;
        }
    }
}

