package Leetcode.염류선;

import java.util.ArrayList;
import java.util.List;

public class Q2194 {
    public List<String> cellsInRange(String s) {
        List<String> result = new ArrayList<>();

        char a = s.charAt(0);
        char b = s.charAt(3);
        int c = s.charAt(1) - '0';
        int d = s.charAt(4) - '0';

        for (char col = a; col <= b; col++) {
            for (int row = c; row <= d; row++) {
                result.add("" + col + row);
            }
        }

        return result;
    }
}
