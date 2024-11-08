import java.util.*;
class Solution {
    public String[] solution(String[] records) {
        Queue<String[]>q=new LinkedList<>();
        Map<String,String>map=new HashMap<>();
        for(int i=0;i<records.length;i++){
            String[]record=records[i].split(" ");
            String command=record[0];
            String id=record[1];
            if(command.equals("Enter")){
                map.put(id,record[2]);    
                q.offer(new String[]{id,command});
            }else if(command.equals("Change")){
                map.put(id,record[2]);
            }else{
                q.offer(new String[]{id,command});
            }
        }
        String[]answer=new String[q.size()];
        int idx=0;
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()){
            String[]current=q.poll();
            String id=current[0];
            String command=current[1];
            sb.setLength(0);
            if(command.equals("Enter")){
                sb.append(map.get(id)).append("님이 들어왔습니다.");
            }else{
                sb.append(map.get(id)).append("님이 나갔습니다.");
            }
            answer[idx++]=sb.toString();
        }
        return answer;
    }
}
