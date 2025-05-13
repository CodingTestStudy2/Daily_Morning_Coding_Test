package Leetcode;

/*
1. 아이디어 :


2. 시간복잡도 :
O( n)
3. 자료구조/알고리즘 :
- /
 */

public class Q2957 {
    class Solution {
        public int removeAlmostEqualCharacters(String word) {

            int res = 0;
            for(int i = 0; i < word.length()-1; i++) {
                //System.out.println(word.charAt(i) - word.charAt(i+1));
                if(Math.abs(word.charAt(i) - word.charAt(i+1)) <=1) {
                    res++;
                    i++;
                }
            }

            return res;
        }
    }
}