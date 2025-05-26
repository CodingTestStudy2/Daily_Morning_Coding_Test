/*
1. 아이디어 : x 좌표, y 좌표에 해당하는  Map을 생성하고 key에는 x를, value에는 y 값의 집합을 저장

2. 시간복잡도 : O(N * logN)

3. 자료구조/알고리즘 : 맵, 트리셋, 완전탐색

 */

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int answer = 0;
        Map<Integer, TreeSet<Integer>> xMap = new HashMap<>();
        Map<Integer, TreeSet<Integer>> yMap = new HashMap<>();
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];

            if (!xMap.containsKey(x)) {
                TreeSet<Integer> tSet = new TreeSet<>();
                tSet.add(y);
                xMap.put(x, tSet);
            } else {
                xMap.get(x).add(y);
            }

            if (!yMap.containsKey(y)) {
                TreeSet<Integer> tSet = new TreeSet<>();
                tSet.add(x);
                yMap.put(y, tSet);
            } else {
                yMap.get(y).add(x);
            }
        }

        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];

            TreeSet<Integer> yValues = xMap.get(x);
            boolean yb = false;
            if (yValues.higher(y) != null && yValues.lower(y) != null) yb = true;

            TreeSet<Integer> xValues = yMap.get(y);
            boolean xb = false;
            if (xValues.higher(x) != null && xValues.lower(x) != null) xb = true;

            if (xb && yb) answer++;
        }

        return answer;
    }
}