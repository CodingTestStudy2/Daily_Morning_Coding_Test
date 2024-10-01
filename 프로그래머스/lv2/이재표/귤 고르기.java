import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer,Integer>type=new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            type.put(tangerine[i],type.getOrDefault(tangerine[i],0)+1);
        }
        Set<Integer> keys = type.keySet();
        List<Integer> keyList = new ArrayList<>(keys);
        keyList.sort((o1, o2) -> type.get(o2).compareTo(type.get(o1)));
        int answer = 0;
        for(Integer key:keyList){
            if(k<=0){
                break;
            }
            k-=type.get(key);
            answer++;
        }
        return answer;
    }
}
