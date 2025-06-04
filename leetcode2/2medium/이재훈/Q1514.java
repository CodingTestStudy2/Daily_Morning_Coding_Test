package 이재훈;/*
1. 아이디어 :
-

2. 시간복잡도 :
O( n + m )
3. 자료구조/알고리즘 :
- / bfs
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q1514 {
    class Solution {
        class Pair {
            int node;
            double prob;
            public Pair(int node, double prob) {
                this.node = node;
                this.prob = prob;
            }
        }

        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            List<List<Pair>> graph = new ArrayList<>();
            for(int i = 0; i< n; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i = 0;i < edges.length; i++) {
                int from = edges[i][0];
                int to = edges[i][1];
                double prob = succProb[i];

                graph.get(from).add(new Pair(to, prob));
                graph.get(to).add(new Pair(from, prob));
            }

            double[] maxProb = new double[n];
            maxProb[start_node] = 1.0;

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
            pq.offer(new Pair(start_node, 1.0));

            while(!pq.isEmpty()) {
                Pair cur = pq.poll();
                int curNode = cur.node;
                double curProb = cur.prob;

                if(curNode == end_node) return curProb;

                for(Pair neighbour : graph.get(curNode)) {
                    int nextNode = neighbour.node;
                    double nextProb = neighbour.prob * curProb;

                    if(nextProb > maxProb[nextNode]) {
                        maxProb[nextNode] = nextProb;
                        pq.offer(new Pair(nextNode, nextProb));
                    }
                }
            }
            return 0.0;
        }
    }
}