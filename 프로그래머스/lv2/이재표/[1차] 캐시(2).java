import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        Set<String>set=new HashSet<>();
        Deque<String>dq=new LinkedList<>();
        int idx=0;
        int n=cities.length;
        int answer=0;
        if(cacheSize==0){
            return 5*n;
        }
        for(int i=0;i<n;i++){
            cities[i] = cities[i].toLowerCase();
            if(set.contains(cities[i])){
                    answer+=1;
                    dq.remove(cities[i]);
                    dq.addLast(cities[i]);
            }else{
                answer+=5;
                if(set.size()>=cacheSize){
                    set.remove(dq.poll());
                }
                set.add(cities[i]);
                dq.addLast(cities[i]);
            }
        }
        return answer;
    }
}
