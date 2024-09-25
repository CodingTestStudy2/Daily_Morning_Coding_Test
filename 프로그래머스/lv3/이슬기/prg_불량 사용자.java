/**
* 
{"frodo" : [1, 2], "fradi" : [1], "crodo": [2], "abc123" : [3, 4], "frodoc" : [3, 4]}
["frodo", "crodo", "abc123", "frodoc"]
*/
import java.util.*;

class Solution {
    String[] alert_id;
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    HashSet<String[]> set;
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        int n = banned_id.length;
        alert_id = new String[n];
        set = new HashSet<>();
        
        // map 만들기
        for (String id : user_id) {
            for (int i=0; i<n; i++) {
                if (banned_id[i].length() != id.length()) continue;
                
                boolean isTrue = true;
                for (int j=0; j<banned_id[i].length(); j++) {
                    if (banned_id[i].charAt(j) != '*' && id.charAt(j) != banned_id[i].charAt(j)) {
                        isTrue = false;
                        break;
                    }
                }
                if (isTrue) {
                    ArrayList<Integer> get = map.getOrDefault(id, new ArrayList<>());
                    get.add(i);
                    map.put(id, get);
                }
            }
        }
        
        System.out.println(map);
        combination(0, 0, n, user_id);
        
        return answer;
    }
    
    private void combination(int cnt, int start, int n, String[] user_id) {
        if (cnt == n) {
            if (!Arrays.asList(alert_id).contains("")) {
                System.out.println(Arrays.toString(alert_id));
                set.add(alert_id);
            }
            return;
        }
        
        for (int i=start; i<user_id.length; i++) {
            ArrayList<Integer> seat = map.get(user_id[i]);
            if (seat == null) continue;
            
            for (int item : seat) {
                System.out.print(seat);
                System.out.println(user_id[i]);
                alert_id[item] = user_id[i];
                combination(cnt+1, i+1, n, user_id);
                alert_id[item] = "";
            }
        }
    }
}