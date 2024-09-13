import java.util.*;

class Solution {

    public int[] solution(int brown, int yellow) {
        List<Integer> yrow = new ArrayList<>();
        int[] answer = new int[2];


        for (int i = 1; i < yellow; i++) {
            if(yellow/i < i) break;
            if (yellow % i == 0) {
                yrow.add(yellow/i);
            }
        }

        if(yrow.isEmpty()) yrow.add(1);

        Collections.sort(yrow);

        for (Integer x : yrow) {
            int row = x;
            int col = yellow/x;
            int tmp = brown;

            tmp -= 2*x;
            col += 2;
            if (tmp % 2 == 0 && tmp / 2 == col) {
                answer[0] = row + 2;
                answer[1] = col;
            }
        }
        return answer;
    }
}
