class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : chars.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        int answer = 0;
        for (String word : words) {
            boolean flag = true;
            int[] chCnt = new int[26];

            for (char ch : word.toCharArray()) {
                chCnt[ch - 'a']++;
                int cnt = map.getOrDefault(ch, 0);
                if (cnt == 0 || cnt < chCnt[ch - 'a']) {
                    flag = false;
                    break;
                }
            }

            if (flag) answer += word.length();
        }

        return answer;
    }
}