// 1. 아이디어 : 윤년 판단
// 2. 시간복잡도 : O(N)
// 3. 자료구조/알고리즘 : 구현

class Solution {
    public int dayOfYear(String date) {
        int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] info = Arrays.stream(date.split("-")).mapToInt(Integer::parseInt).toArray();
        int year = info[0];
        int month = info[1];
        int day = info[2];

        if (month >= 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
            days[1] = 29;
        }

        int answer = day;
        for (int i = 0; i < month - 1; i++) answer += days[i];
        return answer;
    }
}