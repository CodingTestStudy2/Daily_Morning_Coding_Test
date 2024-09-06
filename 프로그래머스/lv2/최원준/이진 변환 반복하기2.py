# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


'''
import java.util.*;
class Solution {
    String ones;
    int zeros;
    public int[] solution(String s) {
        int ops = 0;
        int totalZeros = 0;
        ones = s;
        zeros = 0;
        while (!ones.equals("1")) {
            int zeros = 0;
            int totalLength = ones.length();
            for (Character ch: ones.toCharArray()){
                if (ch == '0') {
                    zeros++;
                }
            }
            ones = Integer.toBinaryString(totalLength - zeros);
            ops++;
            totalZeros += zeros;
        }
        return new int[]{ops,totalZeros};
    }
}'''