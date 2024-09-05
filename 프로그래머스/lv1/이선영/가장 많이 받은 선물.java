import java.util.*;

class Solution {
   
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[] result= new int[friends.length]; //result:다음달에 선물 받는 수, cnt[주는 사람][받는 사람]
        int[] score = new int[friends.length];
        int[][] cnt = new int[friends.length][friends.length];
        Map<String, Integer> map = new HashMap<>();
        
        // 이름 인덱싱
        for(int i=0; i<friends.length; i++){
            map.put(friends[i],i);
        }
        
        //주고받은 선물 기록
        for(int i=0; i<gifts.length; i++){
            String[] person = gifts[i].split(" ");
            int sender = map.get(person[0]);
            int receiver = map.get(person[1]);
            cnt[sender][receiver]++;
        }
        
        // 선물 지수 계산
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i != j) {
                    score[i] += cnt[i][j] - cnt[j][i];
                }
            }
        }
        
        // 다음 달 선물 계산
        for (int i = 0; i < friends.length; i++) {
            for (int j = i+1; j < friends.length; j++) {
                if (i != j) {
                    if (cnt[i][j] > cnt[j][i]) {
                        result[i]++;
                    } else if (cnt[i][j] < cnt[j][i]) {
                        result[j]++;
                    } else { 
                        if (score[i] > score[j]) {
                            result[i]++;
                        } else if (score[i] < score[j]) {
                            result[j]++;
                        }
                    }
                }
            }
        }
        
        
        for(int i=0; i<friends.length; i++){
            answer= Math.max(answer, result[i]);
        }

        return answer;
    }
    
    
}
