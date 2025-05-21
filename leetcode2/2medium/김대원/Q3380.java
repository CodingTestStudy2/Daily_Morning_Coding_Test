class Solution {

    static int answer;
    static Set<String> set;

    public int maxRectangleArea(int[][] points) {
        answer = -1;
        int n = points.length;
        if (n < 4) return answer;
        Arrays.sort(points, new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
        });

        set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int[] point = points[i];
            set.add(point[0] + "," + point[1]);
        }

        recur(n, new int[n], points, new ArrayList<>());

        return answer;
    }

    private void recur(int n, int[] ch, int[][] points, List<int[]> tmp) {
        if (tmp.size() == 4) {
            int[] p1 = tmp.get(0);
            int[] p2 = tmp.get(1);
            int[] p3 = tmp.get(2);
            int[] p4 = tmp.get(3);

            boolean flag = true;
            int minX = Math.min(p1[0], p4[0]);
            int maxX = Math.max(p1[0], p4[0]);
            int minY = Math.min(p1[1], p4[1]);
            int maxY = Math.max(p1[1], p4[1]);

            if ((p2[0] == minX && p2[1] == maxY && p3[0] == maxX && p3[1] == minY) ||
                    (p3[0] == minX && p3[1] == maxY && p2[0] == maxX && p2[1] == minY)) {
                for (String key : set) {
                    String[] strs = key.split(",");
                    int containsX = Integer.parseInt(strs[0]);
                    int containsY = Integer.parseInt(strs[1]);

                    if (containsX >= minX && containsX <= maxX && containsY >= minY && containsY <= maxY) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    answer = Math.max(answer, (maxX - minX) * (maxY - minY));
                }
            }


            return;
        }

        for (int i = 0; i < n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                tmp.add(points[i]);
                set.remove(points[i][0] + "," + points[i][1]);
                recur(n, ch, points, tmp);
                tmp.remove(tmp.size() - 1);
                set.add(points[i][0] + "," + points[i][1]);
                ch[i] = 0;
            }
        }
    }
}