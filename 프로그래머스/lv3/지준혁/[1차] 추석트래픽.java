class Solution {
    
    int range;
    public int solution(String[] lines) {
        
        int n = lines.length;
        int answer = 0;
        int[] dp = new int[60 * 60 * 1000];
        int[] starts = new int[n];
        int[] ends = new int[n];
        
        int idx = 0;
        for (var line : lines) {
            int en = convertToMile(line);
            int st = en - (range + 1);
            dp[(int)st]++;
            dp[(int)(en + 1)]--;
            starts[idx] = st;
            ends[idx++] = en;
        }

        return answer;
    }
    int convertToMile(String time) {
        String[] split = time.split(" ");
        String[] times = split[1].split(":");
        String[] mileAndSec = times[2].split("\\.");
        
        String[] split2 = split[2].substring(0, split[2].length() - 1).split("\\.");
        

        range += Integer.parseInt(split2[0]) * 1000;
        if (split[2].contains(".")) {            
            int num = Integer.parseInt(split2[1]);
            if (split2[1].length() == 1) range += num * 100;
            else if (split2[1].length() == 2) range += num * 10;
            else range += num;
        }

    
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        int sec = Integer.parseInt(mileAndSec[0]);
        int mile = Integer.parseInt(mileAndSec[1]);
        
        return hour * 60 * 60 * 1000 + minute * 60 * 1000 + sec * 1000 + mile;
    }
}
