package Leetcode.김도연;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q3561  {
    public String resultingString(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!deque.isEmpty() && isConsecutive(deque.peek(), c))
                deque.pop();
            else
                deque.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty())
            sb.append(deque.pollLast());

        return sb.toString();
    }

    private boolean isConsecutive(char a, char b) {
        int  diff = Math.abs(a - b);
        return diff == 1 || diff == 25;
    }
}