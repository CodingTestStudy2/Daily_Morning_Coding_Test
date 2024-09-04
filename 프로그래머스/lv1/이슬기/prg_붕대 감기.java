/**
* 1. 붕대 감는 시간 추가 -> x 체력 증가
* 2. 몬스터 공격 -> 체력 감소, 붕대 감는 시간 0
* 3. 붕대 감기 시간 >= t -> y 체력 증가
*/
import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = attacks[attacks.length-1][0];
        int t = 0;
        int hp = health; // 현재 체력
        int monsterStatus = 0; // 그다음 몬스터 공격 시간 상태
        int seqSuccessTime = 0; // 연속 성공 시간
        
        while (t++ < time){
            //System.out.println(hp);
            if (hp <= 0) {
                hp = -1;
                break;
            }
            if (attacks[monsterStatus][0] == t) {
                hp -= attacks[monsterStatus][1];
                seqSuccessTime = 0;
                monsterStatus++;
                continue;
            }
            
            // 최대 체력 고려해서, 만약 추가 회복량이 최대 체력보다 많으면 hp에 최대 체력 할당해주기
            hp = hp + bandage[1] <= health ? hp + bandage[1] : health;
            seqSuccessTime++;
            if (seqSuccessTime == bandage[0]) {
                hp = hp + bandage[2] <= health ? hp + bandage[2] : health;
                seqSuccessTime = 0;
            }
        }
        
        return hp > 0 ? hp : -1;
    }
}