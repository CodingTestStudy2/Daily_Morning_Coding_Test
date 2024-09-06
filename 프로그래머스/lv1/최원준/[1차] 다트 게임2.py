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
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int idx = 0;
        
        String temp = "";
        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            if (Character.isDigit(ch)) {
                temp += ch;
            } else if (Character.isLetter(ch)) {
                int score = Integer.parseInt(temp);
                if (ch == 'S') {
                    scores[idx] = (int)Math.pow(score, 1);
                } else if (ch == 'D') {
                    scores[idx] = (int)Math.pow(score, 2);
                } else {
                    scores[idx] = (int)Math.pow(score, 3);
                }
                idx++;
                temp = "";
            } else if (ch == '*') {
                scores[idx-1] *= 2;
                if (idx > 1) {
                    scores[idx-2] *= 2;
                }
            } else if (ch == '#') {
                scores[idx-1] *= -1;
            }
            
        }
        // System.out.println(Arrays.toString(scores));
        int ans = 0;
        for (int score: scores) {
            ans += score;
        }
        return ans;
    } 
}'''