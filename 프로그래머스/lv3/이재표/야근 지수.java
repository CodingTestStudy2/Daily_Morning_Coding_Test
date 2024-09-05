import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int work : works) {
            map.put(work, map.getOrDefault(work, 0) + 1);
        }

        TreeSet<Integer> keys = new TreeSet<>(Collections.reverseOrder());
        keys.addAll(map.keySet());

        for (int i = 0; i < n; i++) {
            if (keys.isEmpty()){
              break;   
            } 

            int maxWork = keys.first(); 
            int count = map.get(maxWork);  

            if (maxWork == 0){
                break;
            } 
            map.put(maxWork, count - 1);

            if (count - 1 == 0) {
                map.remove(maxWork);
                keys.pollFirst(); 
            }

            map.put(maxWork - 1, map.getOrDefault(maxWork - 1, 0) + 1);
            keys.add(maxWork - 1);
        }
        for(Integer k:map.keySet()){
            int v= map.get(k);            
            answer+=(long)k*k*v;
        }
        return answer;
    }
}
