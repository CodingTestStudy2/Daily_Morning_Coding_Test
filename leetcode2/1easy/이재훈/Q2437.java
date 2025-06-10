package Leetcode.이재훈;

/*
1. 아이디어 :
 - 시간 부분에서
 - ?? : 00 -> 총 24
 - 2? : 00 -> 첫번째만 있는 경우에는 두가지 케이스가 있다.
              - 두번째 자리가 3보다 클경우 첫번째 자리는 2가 될수 없다. 총 2개
              - 두번째 자리가 3이하일경우 첫번째 자리는 0,1,2 총 3개

 - ?2 : 00 -> 두번째만 있는 경우에는 두가지 케이스가 있다.
              - 첫번째 자리가 2일경우 두번째 자리는 0,1,2,3만 될수 있다. 총 4개
              - 첫번째 자리가 2보다 작은경우 두번째 자리는 0~9 까지 될수있다. 총 10개

2. 시간복잡도 :
O( 1 )
3. 자료구조/알고리즘 :
- /
 */

public class Q2437 {
    class Solution {
        public int countTime(String time) {
            // a string of length 5 called time
            // hh:mm
            // earliest 00:00, latest 23:59
            // ? should be replaced with a digit from 0 to 9
            // return answer, the number of valid clock time..

            char firstDigitForHour = time.charAt(0);
            char secondDigitForHour = time.charAt(1);
            char firstDigitForMin = time.charAt(3);
            char secondDigitForMin = time.charAt(4);


            int answer = 1;
            if(firstDigitForHour == '?' && secondDigitForHour == '?') {
                answer = 24;
            } else if(firstDigitForHour == '?') {
                if((secondDigitForHour-'0') <= 3) answer = 3; // 23 -> 0 1 2, 24 -> 0, 1
                else answer = 2;
            } else if(secondDigitForHour == '?') {
                if(firstDigitForHour == '2') answer = 4; // 0,1,2,3
                else answer = 10; //0 ~9
            }

            System.out.println(answer);
            if(firstDigitForMin == '?') answer *= 6;
            if(secondDigitForMin == '?') answer *= 10;

            return answer;
        }
    }
}