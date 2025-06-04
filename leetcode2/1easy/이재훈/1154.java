package Leetcode.이재훈;

/*
1. 아이디어 :

- 받은 date을 year, month, day로 쪼갠다.
- year로 leap year인지 확인
- month를 days로 바꾼다
- 마지막 받은 day와 합쳐서 반환

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

public class Q1154 {
    class Solution {
        public int dayOfYear(String date) {
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(5, 7));
            int day = Integer.parseInt(date.substring(8));
            boolean isLeapYear = false;

            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) isLeapYear = true;
            int res = 0;
            for (int i = 1; i < month; i++) {
                res += getDays(i, isLeapYear);
            }
            return res + day;
        }

        public int getDays(int month, boolean isLeapYear) {
            int days = 0;
            switch (month) {
                case 1:
                    days = 31;
                    break;
                case 2:
                    days = 28;
                    break;
                case 3:
                    days = 31;
                    break;
                case 4:
                    days = 30;
                    break;
                case 5:
                    days = 31;
                    break;
                case 6:
                    days = 30;
                    break;
                case 7:
                    days = 31;
                    break;
                case (8):
                    days = 31;
                    break;
                case (9):
                    days = 30;
                    break;
                case (10):
                    days = 31;
                    break;
                case (11):
                    days = 30;
                    break;
                case (12):
                    days = 31;
                    break;
                default:
                    break;
            }
            if (month == 2 && isLeapYear) days += 1;
            return days;

        }
    }
}