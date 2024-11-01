# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int serialize(String time){
        String[] hms = time.split(":");
        return Integer.parseInt(hms[0])*3600 + Integer.parseInt(hms[1]) * 60 + Integer.parseInt(hms[2]);
    }

    public String deserialize(int num) {
    int hours = num / 3600;
    int minutes = (num % 3600) / 60;
    int seconds = num % 60;

    StringBuilder sb = new StringBuilder();
    if (hours < 10) sb.append("0");
    sb.append(hours).append(":");
    if (minutes < 10) sb.append("0");
    sb.append(minutes).append(":");
    if (seconds < 10) sb.append("0");
    sb.append(seconds);
    return sb.toString();
}


    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = serialize(play_time);
        int advDuration = serialize(adv_time);
        int[] prefixSum = new int[playTime + 1];

        for (String log : logs){
            String[] times = log.split("-");
            int start = serialize(times[0]), end = serialize(times[1]);
            prefixSum[start]++;
            prefixSum[end]--;
        }

        for (int i=1; i<playTime; i++) {
            prefixSum[i] += prefixSum[i-1];
        }

        long cmax = 0;
        for (int i=0; i<advDuration; i++) cmax += prefixSum[i];

        long curr = cmax;
        int ans = 0;

        for (int start = 1; start + advDuration <= playTime; start++) {
            curr += prefixSum[start + advDuration - 1] - prefixSum[start-1];
            if (curr > cmax) {
                cmax = curr;
                ans = start;
            }
        }

        return deserialize(ans);
    }
}






'''


