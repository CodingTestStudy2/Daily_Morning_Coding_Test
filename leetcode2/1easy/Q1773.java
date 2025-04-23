package Leetcode;

/*
1. 아이디어 :

- 해쉬맵에 저장 후 값을 꺼냄

2. 시간복잡도 :
O( n log n )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

public class Q1773 {
    class Solution {
        public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            Map<String, Integer> typeMap = new HashMap<>();
            Map<String, Integer> colorMap = new HashMap<>();
            Map<String, Integer> nameMap = new HashMap<>();

            for(List<String> item : items) {
                String type = item.get(0);
                String color = item.get(1);
                String name = item.get(2);

                typeMap.put(type, typeMap.getOrDefault(type,0) + 1);
                colorMap.put(color, colorMap.getOrDefault(color,0) + 1);
                nameMap.put(name, nameMap.getOrDefault(name,0) + 1);
            }
            int res = 0;
            switch(ruleKey) {
                case "type" : if(typeMap.containsKey(ruleValue)) res =typeMap.get(ruleValue);
                    break;
                case "color" : if(colorMap.containsKey(ruleValue)) res =colorMap.get(ruleValue);
                    break;
                case "name" : if(nameMap.containsKey(ruleValue))res =nameMap.get(ruleValue);
                    break;

                default : break;
            }
            return res;
        }
    }
}