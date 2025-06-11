package 이재훈;

/*
1. 아이디어 :

- PriorityQueue 에 저장을 하면서 최소 알파뱃을 가져오는데 알파벳들의 인덱스를 가져오면서 set에 없애야되는 인덱스들을 저장한다.
- 그 후에 set에 저장되어있는 값들과 * 를 제외한 나머지를 stringbuilder에 저장 후 반환.

2. 시간복잡도 :
O( n log n)
3. 자료구조/알고리즘 :
- / PriorityQueue
 */

import java.util.*;

public class Q3170 {
    class Solution {
        public String clearStars(String s) {

            // find the smallest value from s
            PriorityQueue<Character> pq = new PriorityQueue<>();
            Map<Character, List<Integer>> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '*') {
                    char smallestChar = pq.poll();
                    List<Integer> temp = map.get(smallestChar);
                    int idx = temp.get(temp.size()-1);
                    set.add(idx);
                    temp.remove(temp.size()-1);
                } else {
                    map.putIfAbsent(c, new ArrayList<>());
                    map.get(c).add(i);
                    pq.add(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<s.length(); i++) {
                if(!set.contains(i) && s.charAt(i) != '*') sb.append(s.charAt(i));
            }

            return sb.toString();
        }
    }
}