import java.util.*;
class Solution {
    Set<String> set;
    boolean[] visit;
    public int solution(String[] user_id, String[] banned_id) {
        visit = new boolean[user_id.length];
        set = new HashSet<>();
        for(int i = 0; i < banned_id.length; i++){
            banned_id[i] = banned_id[i].replace('*', '.');
        }
        back(0, "", user_id, banned_id);
        return set.size();
    }
    public void back(int idx, String result, String[] user_id, String[] banned_id) {
        if (idx == banned_id.length) {
            String[] res = result.split(" ");
            Arrays.sort(res);
            String a = "";
            for (int i = 0; i < res.length; i++) {
                a += res[i];
            }
            set.add(a);
            return;
        }
        for (int i = 0; i < user_id.length; i++) {
            if (visit[i] || !user_id[i].matches(banned_id[idx])) {
                continue;
            }
            visit[i] = true;
            back(idx + 1, user_id[i] + " " + result, user_id, banned_id);
            visit[i] = false;
        }
    }
}
