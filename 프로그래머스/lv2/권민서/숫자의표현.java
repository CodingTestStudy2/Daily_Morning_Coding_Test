import java.util.*;

class Solution {

    public int solution(int n) {

        int lt = 1;
        int rt = 1;
        int tmp = 0;
        int answer = 1;

        if(n < 3) return 1;

        while (lt < n) {

            if(tmp == n) {
                answer++;
            }
            if (tmp < n) {
                tmp += rt++;
                continue;
            }
            tmp -= lt++;
        }
        return answer;
    }
}
