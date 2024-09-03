import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        Map<String,Set<String>>report_people=new HashMap<>();
        Map<String,Set<String>>people=new HashMap<>();
        Map<String,Integer>mail=new HashMap<>();
        for(String id:id_list){
            people.put(id,new HashSet<>());
            report_people.put(id,new HashSet<>());
        }
        for(String report:reports){
            String[]r=report.split(" ");
            report_people.get(r[1]).add(r[0]);
            people.get(r[0]).add(r[1]);
        }
        List<String>upper_k=new ArrayList<>();
        for(String rp:report_people.keySet()){
            Integer cand=report_people.get(rp).size();
            if(cand>=k){
                upper_k.add(rp);
            }
        }
        for(String person:people.keySet()){
            for(String u:upper_k){
                if(people.get(person).contains(u)){
                    mail.put(person, mail.getOrDefault(person, 0) + 1);
                }
            }
        }
        int idx=0;
        int n=id_list.length;
        int[]answer=new int[n];
        for(int i=0;i<n;i++){
            answer[i] = mail.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}
