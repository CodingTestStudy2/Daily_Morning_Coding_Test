import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String,Integer>parking=new HashMap<>();
        Map<String,Integer>carTotalTime=new HashMap<>();
        
        for(String record:records){
            String[]r=record.split(" ");
            String time=r[0];
            String car=r[1];
            String command=r[2];
            if(command.equals("IN")){
                parking.put(car,convertToMinute(time));
            }
            if(command.equals("OUT")){
                Integer t=parking.get(car);
                parking.remove(car);
                Integer minDiff=convertToMinute(time)-t;
                carTotalTime.put(car,carTotalTime.getOrDefault(car,0)+minDiff);
            }
        }
        
        for(String left:parking.keySet()){
            Integer t=parking.get(left);
            Integer minDiff=convertToMinute("23:59")-t;
            carTotalTime.put(left,carTotalTime.getOrDefault(left,0)+minDiff);
        }
        List<String>cars=new ArrayList<>(carTotalTime.keySet());
        Collections.sort(cars);
        int []answer=new int[cars.size()];
        for(int i=0;i<cars.size();i++){
            answer[i]=calculateFee(carTotalTime.get(cars.get(i)),fees);
        }
        return answer;
    }
    private int calculateFee(Integer time,int[]fees){
        int basicT=fees[0];
        int basicFee=fees[1];
        int unitT=fees[2];
        int unitFee=fees[3];
        
        if(time-basicT<=0){
            return basicFee;
        }
        time-=basicT;
        if(time%unitT!=0){
            time+=unitT;
        }
        return basicFee+(time/unitT*unitFee);
    }
    private int convertToMinute(String time){
        String[]t=time.split(":");
        return 60*Integer.parseInt(t[0])+Integer.parseInt(t[1]);
    }
}
