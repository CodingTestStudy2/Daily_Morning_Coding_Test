import java.util.*;;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            int idx=map.getOrDefault(s.charAt(i),-1);
            if(idx==-1){
                answer[i]=-1;
            }else{
                answer[i]=i-idx;
            }
            map.put(s.charAt(i),i);
        }
        return answer;
        
    }
}
