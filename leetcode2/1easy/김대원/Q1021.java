class Solution {
    public String removeOuterParentheses(String s) {
        boolean flag = false;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        StringBuilder answer = new StringBuilder();
        for (char ch : chars) {
            if (ch == '(') {
                stack.push(ch);
                if (stack.size() >= 2) {
                    answer.append("(");
                    flag = true;
                }
            } else {
                stack.pop();
                if (stack.isEmpty()) flag = false;
                if (flag) answer.append(")");
            }
        }

        return answer.toString();
    }
}