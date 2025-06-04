# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


'''
import java.util.*;
class Leetcode.이재훈.이재훈.Solution {
    static int time;
    static int damage;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        // x = heal, t = cont, y = additional_heal
        int cont = bandage[0], heal = bandage[1], additional_health = bandage[2];
        int curr_health = health;
        int prev_time = 0;
        
        for (int i=0; i<attacks.length; i++){
            time = attacks[i][0];
            damage = attacks[i][1];
            
            int time_lapse = time - prev_time-1;
            int additional_heal = ((time_lapse) / cont) * additional_health;
            curr_health = Math.min(health, curr_health + (time_lapse * heal) + additional_heal);
            curr_health -= damage;
            if (curr_health<=0) return -1;
            prev_time = time;
        }
        
        return curr_health;
    }
}'''