import java.util.*;

class Solution {
    static int sum=0;
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map= new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0)+1);
        }
        
        Iterator<String> it = map.keySet().iterator();
        
        while(it.hasNext()){
            String next= it.next();
            answer *= (map.get(next)+1);
        }
        
        return answer-1;
    }
    
}
