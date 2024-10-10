/**
headgear : 1
eyewear : 1
2 * 2 - 1
*/
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothMap = new HashMap<>();
        
        for (String[] cloth : clothes) {
            clothMap.put(cloth[1], clothMap.getOrDefault(cloth[1], 0) + 1);
        }
        
        int answer = 1;
        
        for (int count : clothMap.values()) {
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}