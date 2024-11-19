import java.util.*;

class Solution {
    Set<Integer> set;

    public int solution(String numbers) {
        set = new HashSet<>();
        boolean[] visit = new boolean[numbers.length()];
        permutation("", numbers, visit, 0);

        int max = 0;
        for (int s : set) {
            max = Math.max(s, max);
        }

        boolean[] arr = new boolean[max + 1];
        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i <= max; i++) {
            if (!arr[i]) { 
                for (int j = i * 2; j <= max; j += i) {
                    arr[j] = true;
                }
            }
        }

        int answer = 0;
        for (int s : set) {
            if (!arr[s]) { 
                answer++;
            }
        }

        return answer;
    }

    private void permutation(String answer, String n, boolean[] visit, int count) {
        if (count == n.length()+1) {
            return;
        }
        if (count > 0 && !answer.isEmpty()) {
            int num = Integer.parseInt(answer);
            if (num > 0) {
                set.add(num);
            }
        }
        for (int i = 0; i < n.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                permutation(answer + n.charAt(i), n, visit, count + 1);
                visit[i] = false;
            }
        }
    }
}
