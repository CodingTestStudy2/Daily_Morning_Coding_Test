class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        int min = Arrays.stream(enemyEnergies).min().getAsInt();
        if (currentEnergy < min) return 0;

        int n = enemyEnergies.length;
        long point = 0;
        Set<String> set = new HashSet<>();
        Queue<int[]> q1 = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
        });

        Queue<int[]> q2 = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });

        for (int i = 0; i < n; i++) {
            int e = enemyEnergies[i];
            q1.offer(new int[] {e, i});
            q2.offer(new int[] {e, i});
        }

        while (!q1.isEmpty()) {
            int[] now = q1.peek();
            int e = now[0];
            if (set.contains(now[0] + " " + now[1])) {
                q1.poll();
                continue;
            }

            if (e <= currentEnergy) {
                int divide = currentEnergy / e;
                point += divide;
                currentEnergy -= (divide * e);
            } else {
                if (!q2.isEmpty()) {
                    int[] qp = q2.poll();
                    currentEnergy += qp[0];
                    set.add(qp[0] + " " + qp[1]);
                }
            }
        }

        return point;
    }
}