import java.util.HashMap;
import java.util.Map;

public class LC_2284 {
    class Solution {
        public String largestWordCount(String[] messages, String[] senders) {
            String name = null;
            int maxCnt = -1;
            Map<String, Integer> map = new HashMap<>();
            for(int i=0; i<messages.length; i++){
                int cnt = messages[i].split(" ").length;
                cnt += map.getOrDefault(senders[i], 0);
                map.put(senders[i], cnt);
                if(cnt > maxCnt){
                    maxCnt = cnt;
                    name = senders[i];
                }
                else if(cnt == maxCnt){
                    if(senders[i].compareTo(name) > 0) name = senders[i];
                }
            }
            return name;
        }
    }
}
