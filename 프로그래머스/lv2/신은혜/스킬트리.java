import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<skill.length(); i++)
            map.put(skill.charAt(i),i);
        
        int result = 0;
        for(String s : skill_trees){
            boolean flag = true;
            int index=0;
            for(int i=0; i<s.length(); i++){
                int now = map.getOrDefault(s.charAt(i),-1);
                if(now!=-1){
                    if(now!=index){
                        flag=false;
                        break;
                    }
                    index++;
                }
            }
            if(flag) result++;  
        }
        return result;
    }
}