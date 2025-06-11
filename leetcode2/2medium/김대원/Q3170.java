class Solution {
    public String clearStars(String s) {
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return b[1] - a[1];
                return a[0] - b[0];
            }
        });

        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> rq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                if (!pq.isEmpty()) {
                    int[] poll = pq.poll();
                    rq.offer(poll);
                }
            } else {
                pq.offer(new int[] {ch - '0' , i});
                queue.offer(new int[] {ch - '0', i});
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!queue.isEmpty()) {
            if (!rq.isEmpty()) {
                int[] qp = queue.peek();
                int[] rp = rq.peek();

                if (qp[0] == rp[0] && qp[1] == rp[1]) {
                    rq.poll();
                    queue.poll();
                } else {
                    qp = queue.poll();
                    answer.append((char)(qp[0] + '0'));
                }
            } else {
                int[] qp = queue.poll();
                answer.append((char)(qp[0] + '0'));
            }
        }

        return answer.toString();
    }
}

// 1 <= s.length <= 10^5
// s consists only of lowercase English letters and '*'.
// The input is generated such that it is possible to delete all '*' characters.
