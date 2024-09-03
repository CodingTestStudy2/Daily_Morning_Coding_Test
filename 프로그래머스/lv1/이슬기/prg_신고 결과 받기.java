/**
* HashMap 두 개 만들기
* 1. 유저ID, 신고당한 횟수 -> 정지된 유저 ID만 모으기
* 2. 유저ID, 유저가 신고한 ID
*/
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, Integer> warningCnt = new HashMap<>();
        HashMap<String, HashSet<String>> warningID = new HashMap<>();
        HashSet<String> stopID = new HashSet<>();
        
        for (int i=0; i<report.length; i++) {
            String[] reportArr = report[i].split(" ");
            HashSet<String> item = warningID.getOrDefault(reportArr[0], new HashSet<>());
            
            if (!item.contains(reportArr[1])) {
                warningCnt.put(reportArr[1], warningCnt.getOrDefault(reportArr[1], 0) + 1);
            }
            item.add(reportArr[1]);
            warningID.put(reportArr[0], item);
        }
        
        for (String id : warningCnt.keySet()) {
            if (warningCnt.get(id) >= k) { // 신고횟수 k이상이라면
                stopID.add(id);
            }
        }
        
        for (String warning_id : warningID.keySet()) {
            HashSet<String> set = warningID.get(warning_id);
            for (String stop_id : stopID) {
                if (set.contains(stop_id)) {
                    answer[Arrays.asList(id_list).indexOf(warning_id)] += 1;
                }
            }
        }
        
        // System.out.println(warningCnt.toString());
        // System.out.println(warningID.toString());
        
        return answer;
    }
}