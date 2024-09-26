/**
진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간
가장 짧은 구간이 여러 개면, 시작 번호가 더 작은 것으로 리턴 
N <= 10만 (N^2 불가) 
*/
import java.util.*;
import javafx.util.Pair;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        // Set으로 중복 제거 (종류 파악)
        Set<String> allTypes = new HashSet<>();
        for(String name: gems){
            allTypes.add(name);
        }
        
        ArrayList<Pair<Integer, Integer>> candidates = new ArrayList<>();
        
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        
        while(left < gems.length){
            if(right == gems.length - 1){
                left++;
                //System.out.println(left + " " + right);
            }
            
            Set<String> temp = new HashSet<>();
            for(int i = left; i <= right; i++){
                temp.add(gems[i]);
            }
            
            if(allTypes.size() == temp.size() && 
               minLen > right - left){
                minLen = right - left;
                
                answer[0] = left + 1;
                answer[1] = right + 1;
                
                System.out.println(answer[0] + " " + answer[1]);
            }
            
            if(right < gems.length - 1){
                right++; // 최대 n-1까지만 증가
            }
        }
        
        return answer;
    }
}