package Leetcode;

/*
1. 아이디어 :

- 맵에 테이블번호를 키로 해서 각 오더한 메뉴와 그 오더 수를 저장
- 그걸 list로 빼내서 저장 후 리턴

2. 시간복잡도 :
O( n  )
3. 자료구조/알고리즘 :
- / 완전 탐색
 */

public class Q1418 {
    class Solution {
        public List<List<String>> displayTable(List<List<String>> orders) {
            Map<Integer, Map<String, Integer>> map = new HashMap<>();
            Set<String> foodSet = new TreeSet<>();
            for(List<String> ls : orders) {
                int tableNum = Integer.parseInt(ls.get(1));
                String foodItem = ls.get(2);
                foodSet.add(foodItem);
                map.putIfAbsent(tableNum, new HashMap<>());

                Map<String, Integer> foodMap = map.get(tableNum);
                foodMap.put(foodItem, foodMap.getOrDefault(foodItem, 0) + 1);
            }
            //
            List<List<String>> res = new ArrayList<>();
            List<String> foodList = new ArrayList<>();
            foodList.add("Table");
            for(String food : foodSet) {
                foodList.add(food);
            }
            res.add(foodList);

            List<Map.Entry<Integer, Map<String,Integer>>> entryList = new ArrayList<>(map.entrySet());
            entryList.sort(Map.Entry.comparingByKey());

            for(Map.Entry<Integer, Map<String, Integer>> entry : entryList) {
                List<String> foodLs = new ArrayList<>();
                Map<String, Integer> foodMap = entry.getValue();
                int tableNo = entry.getKey();

                foodLs.add(tableNo + "");
                for(String food : foodSet) {
                    if(foodMap.containsKey(food)) {
                        foodLs.add(foodMap.get(food) + "");
                    } else {
                        foodLs.add("0");
                    }
                }
                res.add(foodLs);
            }
            return res;
        }
    }
}