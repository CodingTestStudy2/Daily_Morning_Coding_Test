class Solution {
    public int countValidWords(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        int count = 0;

        for (String word : words) {
            if(isValid(word)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValid(String word) {
        if(word.isEmpty()) return false;

        int hyphenCount = 0;
        int punctuationCount = 0;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if(Character.isDigit(c)) {
                return false; // 숫자 포함 x
            }

            if (c == '-'){
                hyphenCount++;
                // 하이픈이 여러개 이거나, 시작/ 끝에 있거나, 양옆이 알파벳이 아니라면 false
                if(hyphenCount > 1) return false;
                if(i == 0 || i == word.length() - 1) return false;
                if(!Character.isLowerCase(word.charAt(i - 1)) || !Character.isLowerCase(word.charAt(i + 1))) {
                    return false;
                }
            }

            if (c == '.' || c == ',' || c == '!') {
                punctuationCount++;
                // 구두점은 한번만, 단어 끝에만
                if(punctuationCount > 1 || i != word.length() - 1) return false;
            }
        }

        return true;
    }
}
