package Leetcode.이재훈;

/*
1. 아이디어 :

 - 양쪽에서 1을 찾은 다음에 -1을 찾았을때 그 사이의 거리를 재서 최대값을 값으로 리턴

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

public class Q2511 {
    class Solution {
        public int captureForts(int[] forts) {

            int pos = -1;
            int maxFortsCaptured = 0;
            for(int i = 0; i<forts.length; i++) {
                if(forts[i] == 1) pos = i;

                if(pos != -1 && forts[i] == -1) {
                    maxFortsCaptured = Math.max(maxFortsCaptured, i - pos -1);
                    pos = -1;
                }
            }

            pos = -1;
            for(int i = forts.length-1;i >=0;i--) {
                if(forts[i] == 1) pos = i;

                if(pos != -1 && forts[i] == -1) {
                    maxFortsCaptured = Math.max(maxFortsCaptured, pos - i -1);
                    pos = -1;
                }
            }

            return maxFortsCaptured;
        }
    }
}