import java.util.*;

class Solution {
    
    TreeMap<String, Integer> map = new TreeMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        List<Map.Entry<String, Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < course.length; ++i) {
            for (int j = 0; j < orders.length; ++j) {
                dfs(0, orders[j], course[i], "", 0);
            }
            int maxValue = 1;
            for (var e : map.entrySet()) {
                if (e.getValue() > maxValue) {
                    maxValue = e.getValue();
                }
            }

            if (maxValue != 1) {
                for (var e : map.entrySet()) {
                    if (e.getValue() == maxValue) {
                        ans.add(e);
                    }
                }
            }
            map.clear();
        }
        ans.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        ans.sort(Map.Entry.comparingByKey());
        
        List<String> list = new ArrayList<>();
        for (var e : ans) {
            list.add(e.getKey());
        }
     
        String[] answer = list.toArray(new String[0]);
        return answer;
    }
    
    void dfs(int depth, String order, int digit, String menu, int st) {
        if (depth == digit) {
            map.put(menu, map.getOrDefault(menu, 0) + 1);
            char[] chars = menu.toCharArray();
            Arrays.sort(chars);
            String reversed = new String(chars);
            if (!menu.equals(reversed)) {
                map.put(reversed, map.getOrDefault(reversed, 0) + 1);
            }
            return;
        }
        
        for (int i = st; i < order.length(); ++i) {
            dfs(depth + 1, order, digit, menu + order.charAt(i), i + 1);
        }
    }
}
