class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder answer = new StringBuilder();
        int n = num1.length() - 1, m = num2.length() - 1;
        int next = 0;
        while (n >= 0 || m >= 0) {
            int x1 = 0, x2 = 0;
            if (n >= 0 && num1.charAt(n) != '0') x1 = num1.charAt(n) - '0';
            if (m >= 0 && num2.charAt(m) != '0') x2 = num2.charAt(m) - '0';

            int result = x1 + x2 + next;
            if (result > 9) {
                next = 1;
                result %= 10;
            } else {
                next = 0;
            }

            answer.append(result);
            n--;
            m--;
        }

        if (next != 0) answer.append(next);
        return answer.reverse().toString();
    }
}