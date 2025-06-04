package Leetcode.이재훈;

/*
1. 아이디어 :

- 맵에 디짓별로 카운트를 넣고
- 데이터를 확인한다음에 맞으면 그걸 스트링으로 반환

2. 시간복잡도 :
O( n )
3. 자료구조/알고리즘 :
- /
 */

public class Q3438 {
    class Solution {
        public String findValidPair(String s) {

            // hashmap
            // key : each digit, value : count
            HashMap<Integer, Integer> map = new LinkedHashMap<>();
            for(char cNum :  s.toCharArray()) {
                int num = cNum - '0';
                map.put(num, map.getOrDefault(num,0) +1);
            }

            for(int i = 0; i < s.length()-1; i++) {
                if(s.charAt(i) != s.charAt(i+1) && map.get(s.charAt(i) - '0') == s.charAt(i) - '0'
                        && map.get(s.charAt(i+1) - '0') == s.charAt(i+1) - '0') {
                    return s.charAt(i) + "" + s.charAt(i+1);
                }
            }
            // for(Map.Entry<Integer, Integer> entry :  map.entrySet()) {
            //     if(entry.getValue() == entry.getKey()) {
            //         sb.append(String.valueOf(entry.getKey()));
            //     }
            // }

            return "";
        }
    }
}