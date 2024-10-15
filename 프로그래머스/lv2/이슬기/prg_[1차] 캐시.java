/**
* Cache -> HashMap으로 구현
가장 오래전에 사용한 것을 캐시에서 지워버리기
25 + 5 + 5
["Jeju" : 0, "Pangyo" : 1, "Seoul" : 2]
*/
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int n = cities.length;
        HashMap<String, Integer> citiesMap = new HashMap<>();
        
        for (var i=0; i<n; i++) {
            String city = cities[i].toLowerCase();
            if (citiesMap.containsKey(city)) {
                answer += 1;
            } else {
                // 캐시 사이즈만큼 찼을 때, 가장 오래된 key를 비워줌
                if (citiesMap.size() >= cacheSize) {
                    int minValue = Integer.MAX_VALUE;
                    String minKey = "";
                    for (String key : citiesMap.keySet()) {
                        int v = citiesMap.get(key);
                        if (minValue > v) {
                            minValue = v;
                            minKey = key;
                        }
                    }
                    citiesMap.remove(minKey);
                }
                answer += 5;
            }
            if (cacheSize > 0) { // 캐시 사이즈가 0보다 클때만
                citiesMap.put(city, i);
            }
        }
        
        return answer;
    }
}