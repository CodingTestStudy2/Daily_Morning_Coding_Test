import java.util.*;
class Solution {
    public String solution(int a, int b) {
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int days = 0;
        for (int i = 0; i < a - 1; i++) {
            days += month[i];
        }
        days += b - 1;
        
        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        return week[days % 7];
    }
}
