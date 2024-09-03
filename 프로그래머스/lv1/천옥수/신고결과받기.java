import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> idIdxMap = new HashMap<>();

        for(int idx = 0; idx < id_list.length; idx++) {
            idIdxMap.put(id_list[idx], idx);
        }
        // System.out.println(idIdxMap.toString());
        //
        Map<String, Set<Integer>> bannedMap = new HashMap<>();

        for(String sr: report){
            String[] report_array = sr.split(" ");
            // Set 안에서 만약 해당 인물이 이미 Banned 가 생성되어있으면 Banned 가 같은 객체인지 어떻게 확인함?

            // 중복을 해결해야하고, 그러면서고, key 값으로 조회가 가능해야함
            if(!bannedMap.containsKey(report_array[1])){
                bannedMap.put(report_array[1], new HashSet(idIdxMap.get(report_array[0])));
            } else {
                Set oldSet = bannedMap.get(report_array[1]);
                oldSet.add(idIdxMap.get(report_array[0]));
                // System.out.println(oldSet.toString());
            }
        }

        // 신고자의 수가 k 보다 큰 경우 유저가 받은 결과 메일수를 담는다.
        int[] answer = new int[id_list.length];
        for (Map.Entry<String, Set<Integer>> entry : bannedMap.entrySet()) {
            Set<Integer> reporters = entry.getValue();
            System.out.println(entry.getKey());
            System.out.println(reporters);
            if (reporters.size() >= k) {
                // If the number of reporters is >= k, notify each reporter
                for (int idx : reporters) {
                    answer[idx]++;
                }
            }
        }

        return answer;

    }

}