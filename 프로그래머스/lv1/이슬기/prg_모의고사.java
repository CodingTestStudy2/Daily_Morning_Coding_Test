/**
* 구현
수포자가 찍는 방식 -> 배열로 저장
정답과 비교
3 3 1 1 2 2 4 4 5 5 3 3
0 0 1 1 2 2
0 1 2 3 4 5 6 7 8 9 10
*/
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int n = answers.length;
        int person1 = 0, person2 = 0, person3 = 0;
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 3, 4, 5};
        int[] arr3 = {3, 1, 2, 4, 5};
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (var i=0; i<n; i++) {
            person1 = arr1[i % 5];
            person2 = i % 2 == 0 ? 2 : arr2[(i % 8) / 2];
            person3 = arr3[(i / 2) % 5];
            
            if (answers[i] == person1) {
                map.put(1, map.getOrDefault(1, 0) + 1);
            }
            if (answers[i] == person2) {
                map.put(2, map.getOrDefault(2, 0) + 1);
            }
            if (answers[i] == person3) {
                map.put(3, map.getOrDefault(3, 0) + 1);
            }
        }
        
        //System.out.println(map);
        ArrayList<Integer> answer = new ArrayList<>();
        int maxValue = 0;
        
        for (var j=1; j<4; j++) {
            if (map.getOrDefault(j, 0) == 0) continue;
            
            if (maxValue < map.get(j)) {
                answer = new ArrayList<>();
                maxValue = map.get(j);
                answer.add(j);
            } else if (maxValue == map.get(j)) {
                answer.add(j);
            }
            //System.out.println(answer);
        }
        
        int[] res = answer.stream().mapToInt(i->i).toArray();
        
        return res;
    }
}