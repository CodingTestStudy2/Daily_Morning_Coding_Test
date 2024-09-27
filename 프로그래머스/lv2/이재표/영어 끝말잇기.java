import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        int turn=0;
        int person=0;
        Map<String,Boolean>map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(map.keySet().size()%n==0){
                turn++;
            }
            person=(person+1);
            if(map.containsKey(words[i])){
                return new int[]{person,turn};
            }

            if(i!=0 && words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0)){
                return new int[]{person,turn};
            }

            if(words[i].length()==1){
                return new int[]{person,turn};
            }
            map.put(words[i],Boolean.TRUE);
            person=person%n;
        }
        return new int[]{0,0};
    }
}
