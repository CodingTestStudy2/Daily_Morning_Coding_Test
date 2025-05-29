class Solution {

    static class Node implements Comparable<Node> {
        int v;
        double cost;

        public Node(int v, double cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return Double.compare(n.cost, this.cost);
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];

            int v1 = edge[0];
            int v2 = edge[1];
            double cost = succProb[i];
            graph.get(v1).add(new Node(v2, cost));
            graph.get(v2).add(new Node(v1, cost));
        }

        double[] dis = new double[n + 1];
        int[] ch = new int[n + 1];
        Arrays.fill(dis, 1.0);
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start_node, 1.0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int cv = cur.v;
            double cc = cur.cost;
            ch[cv] = 1;

            if (dis[cv] > cc) continue;

            for (Node next : graph.get(cv)) {
                if (ch[next.v] == 0) {
                    if (dis[next.v] == 1.0) {
                        double nc = next.cost * cc;
                        dis[next.v] = nc;
                        pq.offer(new Node(next.v, nc));
                    } else if (dis[next.v] < next.cost * cc) {
                        dis[next.v] = next.cost * cc;
                        pq.offer(new Node(next.v, next.cost * cc));
                    }
                }
            }
        }

        return dis[end_node] == 1.0 ? 0.0 : dis[end_node];
    }
}