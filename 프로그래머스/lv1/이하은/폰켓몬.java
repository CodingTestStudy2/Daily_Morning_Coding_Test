/*
최대한 많은 종류의 폰켓몬을 포함해서 N/2 마리 선택
-> 이때 폰켓몬 종류의 개수 

4 -> 2 (1 2 3)
6 -> 3 (2 3 4) (2 3)
8 -> 4 (1 2 3 4 5 6 7 8)
*/
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // 중복 제거 
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        
        if(set.size() > nums.length / 2){
            answer = nums.length / 2;
        }else{
            answer = set.size(); 
        }
        
        return answer;
    }
}