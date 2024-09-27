/*
가장 먼저 탈락하는 사람의 번호
그 사람이 자신의 몇 번째 차례에 탈락하는지
주어진 단어들로 탈락자가 생기지 않는다면, [0, 0]

한 글자인 단어는 인정되지 않습니다.
앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
이전에 등장했던 단어는 사용할 수 없습니다.
*/
import java.util.*;

class Solution {
    int[] answer = new int[2];
    
    public int[] solution(int n, String[] words) {
        HashMap<String, Boolean> map = new HashMap<>();
        
        int turn = 1;
        for(int i = 0; i < words.length; i++){
            // 길이 체크 
            if(words[i].length() == 1){
                saveAnswer(i % n + 1, turn);
                break;
            }
            
            // 첫 문자 체크 
            if(i > 0){
                char curFirstChar = words[i].charAt(0);
                char prevLastChar = words[i - 1].charAt(words[i - 1].length() - 1);
                
                if(curFirstChar != prevLastChar){
                    saveAnswer(i % n + 1, turn);
                    break;
                }
            }
            
            // 중복 여부 체크 
            if(map.containsKey(words[i])){
                saveAnswer(i % n + 1, turn);
                break;
            }else{
                map.put(words[i], true);
            }
            
            if(i % n == n - 1){
                turn++;
            }
        }
        
        return answer;
    }
    
    void saveAnswer(int personNum, int turn){
        answer[0] = personNum;
        answer[1] = turn;
    }
}