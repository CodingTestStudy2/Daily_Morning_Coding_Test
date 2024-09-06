import java.util.*;

class Solution {

    public int solution(String result) {

        char[] c = result.toCharArray();
        int lastPoint = 0;
        int currentPoint = 0;
        int answer = 0;

        for (int i = 0; i < c.length; i++) {

            if (c[i] == '1' && c[i + 1] == '0') {
                answer += lastPoint;
                lastPoint = currentPoint;
                currentPoint = 10;
                i++;
                continue;
            }

            if (c[i] >= '0' && c[i] <= '9') {
                answer += lastPoint;
                lastPoint = currentPoint;
                currentPoint = c[i] - '0';
                continue;
            }

            if (c[i] == 'S') {
                continue;
            } else if (c[i] == 'D') {
                currentPoint *= currentPoint;
                continue;
            } else if (c[i] == 'T') {
                currentPoint *= currentPoint * currentPoint;
                continue;
            }

            if (c[i] == '*') {
                lastPoint *= 2;
                currentPoint *= 2;
            } else if (c[i] == '#') {
                currentPoint *= -1;
            }

        }
        answer += lastPoint + currentPoint;
        return answer;
    }
}
