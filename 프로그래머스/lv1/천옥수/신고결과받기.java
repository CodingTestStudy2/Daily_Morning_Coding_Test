import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> idIdxMap = new HashMap<>();

        for(int idx = 0; idx < id_list.length; idx++) {
            idIdxMap.put(id_list[idx], idx);
        }
        Map<String, Set<Integer>> bannedMap = new HashMap<>();

        for(String sr: report){
            String[] report_array = sr.split(" ");
            // Set 안에서 만약 해당 인물이 이미 Banned 가 생성되어있으면 Banned 가 같은 객체인지 어떻게 확인함?

            // 중복을 해결해야하고, 그러면서고, key 값으로 조회가 가능해야함
            if(!bannedMap.containsKey(report_array[1])){
                Set<Integer> newSet= new HashSet<>();
                newSet.add(idIdxMap.get(report_array[0]));
                bannedMap.put(report_array[1], newSet);
            } else {
                Set oldSet = bannedMap.get(report_array[1]);
                oldSet.add(idIdxMap.get(report_array[0]));
            }
        }

        // 신고자의 수가 k 보다 큰 경우 유저가 받은 결과 메일수를 담는다.
        int[] answer = new int[id_list.length];
        for (Map.Entry<String, Set<Integer>> entry : bannedMap.entrySet()) {
            Set<Integer> reporters = entry.getValue();
            if (reporters.size() >= k) {
                for (int idx : reporters) {
                    answer[idx]++;
                }
            }
        }
        return answer;

    }

}