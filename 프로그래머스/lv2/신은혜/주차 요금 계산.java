import java.util.*;

class Solution {
    static int[] answer = new int[10000];
    static void save(int[] fees, int number){
        if(answer[number]<=fees[0]) answer[number] = fees[1];
        else{
            int min;
            if((answer[number]-fees[0])%(double)fees[2]!=0) 
                min=(answer[number]-fees[0])/fees[2]+1;
            else min=(answer[number]-fees[0])/fees[2];
            answer[number]=fees[1]+min*fees[3];
        }
    }
    
    static int hourToMin(String time){
        String t[] = time.split(":");
        return Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);
    }
    
    public int[] solution(int[] fees, String[] records) {
        Map<String,Integer> in = new HashMap<>();
        Arrays.fill(answer,-1);
        
        for(String record : records){
            String time[] = record.split(" ");
            if(time[2].equals("IN"))
                in.put(time[1],hourToMin(time[0]));
            else{ // out
                int t = hourToMin(time[0])-in.get(time[1]);
                int number = Integer.parseInt(time[1]);
                if(answer[number]==-1) answer[number]=t;
                else answer[number]+=t;
                in.remove(time[1]);
            }
        }
        
        for(String s : in.keySet()){
            int t = hourToMin("23:59")-in.get(s);
            int number = Integer.parseInt(s);
            if(answer[number]==-1) answer[number]=t;
            else answer[number]+=t;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<answer.length; i++){
            if(answer[i]!=-1){
                save(fees,i);
                list.add(answer[i]);
            }
        }
        
        int result[] = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            result[i]=list.get(i);
        
        return result;
    }
}