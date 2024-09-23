import java.util.*;
import javafx.util.Pair;

class Solution {
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 중복 제거 
        Set<String> set = new HashSet<>();
        for(String e: genres){
            set.add(e);
        }
        
        Iterator<String> it = set.iterator();
        
        // 장르별 총 재생 횟수
        HashMap<String, Integer> map = new HashMap<>();
        
        while(it.hasNext()){ // 최대 100
            String now = it.next();
            
            int sum = 0;
            for(int i = 0; i < genres.length; i++){ // 최대 100 
                if(now.equals(genres[i])){
                    sum += plays[i];
                }
            }
            
            map.put(now, sum);
        }
        
        // HashMap to List
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        
        // 총 재생 횟수 기준으로 내림차순 정렬
        entries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue())); 

        // 장르별 각 노래의 재생 횟수, 고유 번호 저장 
        ArrayList<ArrayList<Pair<Integer, Integer>>> arr = new ArrayList<>();
        
        for (Map.Entry<String, Integer> e: entries) {
            ArrayList<Pair<Integer, Integer>> playsPerGenre = new ArrayList<>();
            
            for(int i = 0; i < genres.length; i++){
                // 정렬된 장르 순서대로 2차원 배열 초기화 
                if(e.getKey().equals(genres[i])){
                    playsPerGenre.add(new Pair(plays[i], i));
                }
            }
            
            arr.add(playsPerGenre);
        }
        
        // first 기준으로 내림차순, second 기준으로 오름차순 정렬 
        arr.forEach( pairs -> {
            Collections.sort(pairs, (p1, p2) -> {
                if (!p1.getKey().equals(p2.getKey())) {
                    return p2.getKey() - p1.getKey();  
                } else {
                    return p1.getValue() - p2.getValue();  
                }
            });
        });
        
        // 각 장르에서 첫번째 2개만 수록 
        arr.forEach( pairs -> {
            answer.add(pairs.get(0).getValue());
            
            if(pairs.size() == 1) return;
            else answer.add(pairs.get(1).getValue());
        });
        
        return answer;
    }
}