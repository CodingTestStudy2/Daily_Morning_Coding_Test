import java.util.*;

class Solution {
    public long solution(int[]weights){
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        for(int i : weights) {
    		double a = i*1.0;
    		double b = (i*2.0)/3.0;
    		double c = (i*1.0)/2.0;
    		double d = (i*3.0)/4.0;
    		if(map.containsKey(a)){
                answer += map.get(a);
            }
    		if(map.containsKey(b)){
                answer += map.get(b);
            } 
    		if(map.containsKey(c)){
                answer += map.get(c);
            }
    		if(map.containsKey(d)){
                answer += map.get(d);
            }
    		map.put((i*1.0), map.getOrDefault((i*1.0), 0)+1);
        }
        
        return answer;
    }
    
    
    /*Set<String> answer;

    public long solution(int[] weights) {
        long answerCount = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < weights.length; i++) {
            for (int j = 2; j <= 4; j++) {
                map.putIfAbsent(weights[i] * j, new ArrayList<>());
                List<Integer> arr = map.get(weights[i] * j);
                arr.add(weights[i]);  
            }
        }

        Set<Integer> keys = map.keySet();
        answer = new HashSet<>();
        for (int key : keys) {
            if (map.get(key).size() >= 2) {
                combination(map.get(key), "", 0, 0);
            }
        }

        return answer.size();
    }

    private void combination(List<Integer> values, String ans, int start, int count) {
        if (count == 2) {
            answer.add(ans);
            return;
        }
        for (int i = start; i < values.size(); i++) {
            combination(values, ans + values.get(i) + "-", i + 1, count + 1); 
        }
    }*/
}
