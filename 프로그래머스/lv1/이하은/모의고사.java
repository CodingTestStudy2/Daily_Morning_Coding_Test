import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = new int[3];
        for(int i = 0; i < answers.length; i++){ // 최대 1만 
            int ans = answers[i];
            if(a1[i % a1.length] == ans) scores[0]++;
            if(a2[i % a2.length] == ans) scores[1]++;
            if(a3[i % a3.length] == ans) scores[2]++;
        }
        
        int maxAns = Arrays.stream(scores).max().getAsInt(); 
        
        for(int i = 0; i < 3; i++){
            if(scores[i] >= maxAns){
                answer.add(i + 1);
            }
        }
        
        return answer;
    }
}