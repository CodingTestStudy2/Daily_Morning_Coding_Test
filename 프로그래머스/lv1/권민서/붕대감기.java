import java.util.*;
class Solution {

    public int solution(int[] band, int health, int[][] attacks) {
        int k = attacks.length;
        int answer = health;
        int cnt = 0;
        int idx = 0;

        for (int i = 1; i <= attacks[k - 1][0]; i++) { //1 ~11까지

            if (i == attacks[idx][0]) {  // 공격시간이 되면
                answer -= attacks[idx++][1];
                cnt = 0;  // 연속 성공 횟수 초기화
                if(answer <= 0) return -1;  // 0이하가 되면 그 즉시 죽음
            }
            else{
                answer += band[1];
                if(answer >= health) answer = health;  // 더해준 후의 값이 health 값보다 크면 health 값으로 초기화
                cnt++;
                // 연속성공수가 다 채워졌을 떄
                if (cnt == band[0]) {
                    answer += band[2];
                    if(answer >= health) answer = health;
                    cnt = 0;
                }
            }
        }

        return answer;
    }

}