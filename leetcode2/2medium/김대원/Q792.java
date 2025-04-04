// 1. 아이디어 : 인덱스를 비교하여 일치하는지 확인, 중복된 문자열 검사 x
// 2. 시간복잡도 : O(N * M)
// 3. 자료구조/알고리즘 : map

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Integer, Character> map = new HashMap<>();
        Map<String, Boolean> cache = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(i, s.charAt(i));
        }

        int answer = 0;
        for (String word : words) {
            if (cache.containsKey(word)) {
                if (cache.get(word)) {
                    answer++;
                }
                continue;
            }

            int idx = 0;
            int subIdx = 0;
            while (idx < s.length()) {
                if (subIdx == word.length()) break;
                if (map.get(idx) == word.charAt(subIdx)) {
                    idx++;
                    subIdx++;
                } else {
                    idx++;
                }
            }

            if (subIdx < word.length()) {
                cache.put(word, false);
            } else {
                cache.put(word, true);
                answer++;
            }
        }

        return answer;

    }
}