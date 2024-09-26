/**
진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간
가장 짧은 구간이 여러 개면, 시작 번호가 더 작은 것으로 리턴 
N <= 10만 (N^2 불가) 
*/
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        // Set으로 보석 종류 파악 
        HashSet<String> allTypes = new HashSet<>();
        for(String name: gems){
            allTypes.add(name);
        }
        
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        
        // 투포인터 범위에 따라, 보석 종류별 개수 갱신
        HashMap<String, Integer> hash = new HashMap<>();
        
        for(int right = 0; right < gems.length; right++){
            // right 범위 늘리기
            String rightGem = gems[right];
            hash.put(rightGem, hash.getOrDefault(rightGem, 0) + 1);
            
            // 모든 보석 종류를 담을 때마다 
            while(allTypes.size() == hash.size()){
                // 최소 범위 갱신 
                if(minLen > right - left){
                    minLen = right - left;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }
                
                // right 고정, left 늘리기 (전체 범위 감소)
                String leftGem = gems[left];
                Integer leftCnt = hash.get(leftGem);
                hash.put(leftGem, leftCnt - 1);
                
                if(hash.get(leftGem) == 0){
                    hash.remove(leftGem);
                }
                
                left++;
            }
        }
        
        return answer;
    }
}