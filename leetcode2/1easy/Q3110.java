package Leetcode;

/*
1. 아이디어 :

- 문제에 나와있는데로 식을 세워서 그대로 계산후 반환

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3110 {
    class Solution {
        public int scoreOfString(String s) {
            int ans = 0;
            for(int i = 0; i< s.length()-1; i++) {
                ans += Math.abs((int) s.charAt(i) - (int) s.charAt(i+1));
            }
            return ans;
        }
    }
}