package 이재훈;

/*
1. 아이디어 :

-

2. 시간복잡도 :
O( n log n)
3. 자료구조/알고리즘 :
- / hashmap + two pointer
 */

import java.util.*;

public class Q1297 {
    class Solution {
        public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
            // maxLetters

            // map.size() >= maxLetters
            // minSize <= size <= maxSize

            // a a b a
            // a b a b
            // a b a b c
            // b c
            // b c a
            // c a
            // c a a b
            // a a b

            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b)->b.getValue() - a.getValue());

            Map<Character, Integer> charMap = new HashMap<>();
            Map<String, Integer> wordMap = new HashMap<>();

            int size = 0;
            int left = 0;
            int right = 0;
            int n = s.length();

            while(right < n) {
                charMap.put(s.charAt(right), charMap.getOrDefault(s.charAt(right), 0) + 1);
                size++;
                right++;
                if(minSize <= size && size<=maxSize) {
                    if(charMap.size() <= maxLetters) {
                        String subString = s.substring(left, right);
                        wordMap.put(subString, wordMap.getOrDefault(subString, 0) + 1);
                    }

                    char cha = s.charAt(left);
                    int count = charMap.get(cha) - 1;
                    if(count == 0) charMap.remove(cha);
                    else charMap.put(cha, count);

                    left++;
                    size--;
                }
            }

            for(Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                pq.add(entry);
            }

            return pq.isEmpty() ? 0 : pq.poll().getValue();
        }
    }
}