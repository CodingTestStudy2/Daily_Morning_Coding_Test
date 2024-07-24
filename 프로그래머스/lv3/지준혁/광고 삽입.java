import java.util.*;

// 못품
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        
        List<int[]> runningTime = new ArrayList<>();
        for (var log : logs) {
            String[] time = log.split("-");
            String[] start = time[0].split(":");
            String[] end = time[1].split(":");
            
            int st = Integer.parseInt(start[0]) * 60 * 60;
            st += Integer.parseInt(start[1]) * 60;
            st += Integer.parseInt(start[2]);
            
            int en = Integer.parseInt(end[0]) * 60 * 60;
            en += Integer.parseInt(end[1]) * 60;
            en += Integer.parseInt(end[2]);
            runningTime.add(new int[]{st, en});
        }
        for (var e : runningTime) {
            System.out.println(e[0] + " " + e[1]);
        }
        
        String ans = "";
        return ans;
    }
}
