import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total=(brown-4)/2;
        System.out.println(total);
        for(int i=1;i<=total/2;i++){
            if(i*(total-i)==yellow){
                return new int[]{total-i+2,i+2};
            }
        }
        return new int[]{0,0};
    }
}
