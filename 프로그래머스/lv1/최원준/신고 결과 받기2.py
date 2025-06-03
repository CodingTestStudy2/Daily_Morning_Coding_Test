# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


'''
import java.util.*;
class Leetcode.이재훈.Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reported = new HashMap<>();
        Map<String, Integer> noted = new HashMap<>();
        for (String id : id_list) {
            noted.put(id, 0);
        }
        
        for (String rep : report) {
            String[] temp = rep.split(" ");
            String u = temp[0], v = temp[1];
            
            if (!reported.containsKey(v)) {
                reported.put(v, new HashSet<>());
            }
            reported.get(v).add(u);
        }
        
        for (Map.Entry<String, Set<String>> entry: reported.entrySet()) {
            String u = entry.getKey();
            Set<String> vs = entry.getValue();
            if (vs.size() >= k){
                for (String v:vs) {
                    noted.put(v, noted.get(v) + 1);
                }
            }
        }
        int[] ans = new int[id_list.length];
        for (int i=0; i<id_list.length; i++) {
            String key = id_list[i];
            ans[i] = noted.get(key);
        }
        return ans;
    }
}
'''