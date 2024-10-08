import java.util.*;
class Solution {
    public String solution(int[] food) {

        StringBuilder food1 = new StringBuilder();
        
        for(int i=1; i<food.length; i++){
            int num = food[i]/2;
            System.out.println(num);
            for(int j=0; j<num; j++){
                food1.append(i);
            }
        }
        
        StringBuilder answer = new StringBuilder();
        answer.append(food1).append(0);
        String food2 = food1.reverse().toString();    
        answer.append(food2);
        
        return answer.toString();
    }
}
