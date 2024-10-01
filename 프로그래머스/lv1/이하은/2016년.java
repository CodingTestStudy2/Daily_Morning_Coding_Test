public class Solution {
    public String solution(int a, int b) {
        String[] daysOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 2016년은 윤년

        // 1월 1일부터 a월 b일까지 경과 일수 계산 
        int elapsedDays = b - 1; 
        for (int i = 0; i < a - 1; i++) {
            elapsedDays += daysInMonth[i];
        }

        // 1월 1일은 금요일이므로 5를 더함.
        int dayOfWeekIndex = (elapsedDays + 5) % 7;

        return daysOfWeek[dayOfWeekIndex];
    }
}
