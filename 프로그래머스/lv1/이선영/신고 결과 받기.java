import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> map = new HashMap<>();
        List<String>[] list = new ArrayList[id_list.length];
        
        for(int i=0; i<id_list.length; i++){
            list[i] = new ArrayList<>();
            map.put(id_list[i], i);
        }
        
        for(int i=0; i<report.length; i++){
            String[] rpt = report[i].split(" ");
            int sender = map.get(rpt[0]);
            int receiver = map.get(rpt[1]);
            
            if(!list[receiver].contains(rpt[0])){
                list[receiver].add(rpt[0]);
            }    
        }
        
        for(int i=0; i<id_list.length; i++){
            int idx = map.get(id_list[i]);// 사람 인덱스
            if(list[idx].size()>=k){
                for(String user : list[idx]){
                    
                    int userIdx = map.get(user);
                    answer[userIdx]++;
                }
            }
            
        }
        
        return answer;
    }
}
