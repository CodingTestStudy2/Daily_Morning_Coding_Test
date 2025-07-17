class Solution {
    public String resultingString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) stack.push(ch);
            else {
                if (check(stack.peek(), ch)) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        // String answer = "";
        StringBuilder answer = new StringBuilder();
        for (char ch : stack) answer.append(ch);
        return answer.toString();
    }

    private boolean check(char prev, char cur) {
        if ((cur == 'a' && prev == 'z') || (cur == 'z' && prev == 'a')) return true;
        return Math.abs(prev - cur) == 1;
    }
}