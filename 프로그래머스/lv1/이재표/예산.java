import java.util.*;
class Solution {
    public int solution(int[] needs, int budget) {
        int answer = 0;
        Arrays.sort(needs);
        for(int need:needs){
            if(budget-need>=0){
                answer++;
                budget-=need;
                continue;
            }
            break;
        }
        return answer;
    }
}
