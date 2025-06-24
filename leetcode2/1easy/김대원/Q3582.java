class Solution {
    public String generateTag(String caption) {
        String answer = "#";
        String[] arr = caption.split(" ");
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i].toLowerCase();
            if (str.isBlank()) continue;
            if (idx == 0) answer += str;
            else {
                char ch = Character.toUpperCase(str.charAt(0));
                answer += ch + str.substring(1, str.length());
            }
            idx++;
        }

        if (answer.length() >= 100) answer = answer.substring(0, 100);
        return answer;
    }
}
