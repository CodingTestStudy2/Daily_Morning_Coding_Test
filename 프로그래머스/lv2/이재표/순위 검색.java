import java.util.*;

class Solution {
    Map<String, ArrayList<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        for (String s : info) {
            String[] splitInfo = s.split(" ");
            dfs(splitInfo, "", 0);
        }
        
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        int[] answer = new int[query.length];
        int idx = 0;

        for (String s : query) {
            String[] split = s.replace(" and ", " ").split(" ");
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < split.length - 1; i++) {
                sb.append(split[i]);
            }

            int score = Integer.parseInt(split[4]); 
            answer[idx++] = search(sb.toString(), score);
        }

        return answer;
    }

    public void dfs(String[] info, String str, int depth) {
        if (depth == 4) {
            int score = Integer.parseInt(info[depth]);
            if (map.containsKey(str)) {
                map.get(str).add(score);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(score);
                map.put(str, list);
            }
            return;
        }

        dfs(info, str + "-", depth + 1);
        dfs(info, str + info[depth], depth + 1);
    }
    
    public int search(String query, int score) {
        if (!map.containsKey(query))
            return 0;

        ArrayList<Integer> list = map.get(query);
        int start = 0;
        int end = list.size();

        while (start < end) {
            int mid = (start + end) / 2;
            if (list.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return list.size() - start;
    }
}
