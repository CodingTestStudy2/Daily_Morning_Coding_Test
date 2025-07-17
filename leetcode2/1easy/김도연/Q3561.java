package Leetcode.김도연;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q3561  {
    public String resultingString(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && isConsecutive(stack.peek(), c))
                stack.pop();
            else
                stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pollLast());

        return sb.toString();
    }

    private boolean isConsecutive(char a, char b) {
        int  diff = Math.abs(a - b);
        return diff == 1 || diff == 25;
    }
}