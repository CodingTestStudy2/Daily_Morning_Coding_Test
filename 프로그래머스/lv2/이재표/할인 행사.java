import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int start = 0;
        int end = 10;
        int total = 0;
        Map<String, Integer> left = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            left.put(want[i], number[i]);
            total += number[i];
        }

        for (int i = start; i < end; i++) {
            Integer value = left.getOrDefault(discount[i], Integer.MAX_VALUE);
            if (value == Integer.MAX_VALUE) {
                continue;
            }
            left.put(discount[i], value - 1);
            if (value - 1 >= 0) {
                total--;
            }
        }

        if (total == 0) {
            answer++;
        }

        for (int i = end; i < discount.length; i++) {
            Integer value1 = left.getOrDefault(discount[i], Integer.MAX_VALUE);
            if (value1 != Integer.MAX_VALUE) {
                left.put(discount[i], value1 - 1);
                if (value1 - 1 >= 0) {
                    total--;
                }
            }
            Integer value2 = left.getOrDefault(discount[start], Integer.MAX_VALUE);
            if (value2 != Integer.MAX_VALUE) {
                left.put(discount[start], value2 + 1);
                if (value2 + 1 > 0) {
                    total++;
                }
            }
            start++;
            if (total == 0) {
                answer++;
            }
        }
        return answer;
    }
}
