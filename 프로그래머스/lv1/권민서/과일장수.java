import java.util.*;

class Solution {

    public int solution(int k, int m, int[] score) {

        List<Integer> list = new ArrayList<>();
        for (int x : score) {
            list.add(x);
        }
        Collections.sort(list, Collections.reverseOrder());

        int answer = 0;

        for (int i = m - 1; i < list.size(); i += m) {
            answer += list.get(i) * m;
        }
        return answer;
    }
}
