class Solution {
    public int countValidWords(String sentence) {
        sentence = sentence.replaceAll("\\s+", " ");
        int answer = 0;
        String[] strs = sentence.split(" ");
        for (String str : strs) {
            if (vaild(str) && !str.isBlank()) {
                System.out.println(str);
                answer++;
            }
        }

        return answer;
    }

    private boolean vaild(String str) {
        int length = str.length();
        char[] chars = str.toCharArray();
        Set<Character> marks = Set.of('!', '.', ',');
        Map<Character, Integer> map = new HashMap<>();
        if (length == 1 && marks.contains(chars[0])) return true;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '-') {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.get(ch) >= 2) return false;
            }

            if ((ch >= '0' && ch <= '9') || ch == ' ') return false;
            if (i == 0 || i == chars.length - 1) {
                if (ch == '-') return false;
                if (marks.contains(ch) && i == 0) return false;
            } else {
                if (marks.contains(ch)) return false;
                if (ch == '-') {
                    char n = chars[i + 1];
                    if (i + 1 >= length || !(n >= 'a' && n <= 'z')) return false;
                }
            }
        }

        return true;
    }
}
