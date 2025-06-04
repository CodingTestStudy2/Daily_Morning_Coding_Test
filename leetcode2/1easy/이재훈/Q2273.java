package Leetcode.이재훈;

/*
1. 아이디어 :

 - 처음 값을 넣고 계속 비교하면서 애나그램이 아닌경우 넣기

2. 시간복잡도 :
O( n log n )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

public class Q2273 {
    class Solution {
        public List<String> removeAnagrams(String[] words) {
            List<String> result = new ArrayList<>();
            result.add(words[0]);

            for (int i = 1; i < words.length; i++) {
                if (!isAnagram(result.get(result.size() - 1), words[i])) {
                    result.add(words[i]);
                }
            }

            return result;
        }

        private boolean isAnagram(String s1, String s2) {
            char[] a = s1.toCharArray();
            char[] b = s2.toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            return Arrays.equals(a, b);
        }
    }
}