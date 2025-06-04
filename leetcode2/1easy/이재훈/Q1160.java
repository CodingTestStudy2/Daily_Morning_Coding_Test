package Leetcode.이재훈;

/*
1. 아이디어 :
 - 맵에 chars 정보를 저장해 놓고 각각 단어들이 chars안에 있는 데이터로 처리되는지 확인
2. 시간복잡도 :
O( n * m)
3. 자료구조/알고리즘 :
- /
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1160 {
    class Solution {
        public int countCharacters(String[] words, String chars) {
            int sum = 0;
            Map<Character, Integer> map = new HashMap<>();


            for(char c : chars.toCharArray()) {
                map.put(c, map.getOrDefault(c,0)+1);
            }

            for(String word : words) {
                boolean isFlag = true;
                Map<Character, Integer> copyMap = new HashMap<>(map);

                for(int i = 0; i< word.length();i++) {
                    if(!copyMap.containsKey(word.charAt(i)) || copyMap.get(word.charAt(i)) == 0) {
                        isFlag = false;
                        break;
                    } else {
                        int count = copyMap.get(word.charAt(i));
                        if(count != 0) copyMap.put(word.charAt(i), count-1);
                    }
                }
                if(isFlag) {
                    //System.out.println("word : " + word);
                    sum += word.length();
                }
            }

            return sum;
        }
    }
}