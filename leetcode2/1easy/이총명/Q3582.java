class Solution {
    public String generateTag(String caption) {
        if(caption == null || caption.isEmpty()) return "";

        String tokens[] = caption.trim().split("\\s+");
        if(token.length == 0) return "";

        StringBuilder sb = new StringBuilder("#");

        // 첫단어 : 모두 소문자로 추가
        sb.append(tokens[0].toLowerCase());

        // 이후 단어들: 각 단어의 첫 글자 대문자로 + 나머지 소문자
        for(int i = 1; i < tokens.length; i++){
            String w = tokens[i];
            if(w.isEmpty()) continue;
            sb.append(Character.toUpperCase(w.charAt(0)));
            if
        }
    }
}
