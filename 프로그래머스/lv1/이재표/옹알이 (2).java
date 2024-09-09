import java.util.*;
class Solution {
    String[] baseWords = {"aya", "ye", "woo", "ma"};    
    int answer = 0;
    
    public int solution(String[] babbling) {
        for (String babble : babbling) {
            permutation(babble, -1); 
        }
        return answer;
    }
    
    public void permutation(String babble, int prevIndex) {
        if (babble.length() == 0) {  
            answer++;
            return;
        }
        
        for (int i = 0; i < baseWords.length; i++) {
            if (i == prevIndex) {  
                continue;
            }
            
            int len = baseWords[i].length();
            if (babble.length() >= len && babble.substring(0, len).equals(baseWords[i])) {
                permutation(babble.substring(len), i); 
            }
        }
    }
}
