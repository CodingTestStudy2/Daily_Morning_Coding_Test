import java.util.*;

class Solution {
    int N;
    List<String> combin;
    String[][] relations;
    boolean[] visit;

    public int solution(String[][] relation) {
        int answer = 0;
        N = relation[0].length;
        relations = relation;
        visit = new boolean[N];

        for (int i = 1; i <= N; i++) {
            combin = new ArrayList<>();
            combination(0, 0, i, "");
            for (String s : combin) {
                String[] c = s.split(",");
                Set<String> set = new HashSet<>();
                for (int k = 0; k < relations.length; k++) {
                    String a = "";
                    for (String idx : c) {
                        a += relations[k][Integer.parseInt(idx)]+",";
                    }
                    set.add(a);
                }
                if (set.size() == relations.length) {
                    answer++;
                    for (String idx : c) {
                        visit[Integer.parseInt(idx)] = true;
                    }
                }
            }
        }
        return answer;
    }

    public void combination(int start, int cnt, int len, String ans) {
        if (cnt == len) {
            combin.add(ans.substring(0, ans.length() - 1));
            return;
        }
        for (int i = start; i < N; i++) {
            if (visit[i]) {
                continue;
            }
            combination(i + 1, cnt + 1, len, ans + i + ",");
        }
    }
}
