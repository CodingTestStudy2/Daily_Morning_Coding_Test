import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character,Integer>map=new HashMap<>();
        int idx=0;
        for(int i=0;i<skill.length();i++){
            map.put(skill.charAt(i),idx++);
        }
        for(int i=0;i<skill_trees.length;i++){
            idx=0;
            for(int j=0;j<skill_trees[i].length();j++){
                int value=map.getOrDefault(skill_trees[i].charAt(j),-1);
                if(value==-1){
                    continue;
                }
                if(value==idx){
                    idx++;
                }else{
                    idx=-1;
                    break;
                }
            }
            if(idx!=-1){
                answer++;
            }
        }
        return answer;
    }
}
