import java.util.*;
class Solution {
    public int solution(int[] topping) {
        Set<Integer>set=new HashSet<>();
        Map<Integer,Integer>map=new HashMap<>();
        int n=topping.length;
        int result=0;
        for(int i=0;i<n;i++){
            map.put(topping[i],map.getOrDefault(topping[i],0)+1);
        }
        for(int i=0;i<n;i++){
            int current=topping[i];
            set.add(current);
            int v=map.get(current);
            if(v-1==0){
                map.remove(current);
            }else{
                map.put(current,map.get(current)-1);
            }
            if(set.size()==map.keySet().size()){
                result++;
            }
        }
        
        return result;
    }
}
