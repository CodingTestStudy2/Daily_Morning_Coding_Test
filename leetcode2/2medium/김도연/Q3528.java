package Leetcode.김도연;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q3528 {
    static final int MOD = 1_000_000_007;

    public int[] baseUnitConversions(int[][] conversions) {
        int n = conversions.length + 1;

        List<List<long[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] c: conversions) {
            int u = c[0], v = c[1], f = c[2];
            graph.get(u).add(new long[]{v, f});
            graph.get(v).add(new long[]{u, modInverse(f)});
        }

        int[] result = new int[n];
        boolean[] visited = new boolean[n];
        Queue<long[]> queue = new ArrayDeque<>();
        queue.offer(new long[]{0, 1});
        result[0] = 1;
        visited[0] = true;

        while (!queue.isEmpty()) {
            long[] cur = queue.poll();
            int u = (int) cur[0];
            long val = cur[1];

            for (long[] next : graph.get(u)) {
                int v = (int) next[0];
                long factor = next[1];
                if (!visited[v]) {
                    long newVal = (val * factor) % MOD;
                    result[v] = (int) newVal;
                    visited[v] = true;
                    queue.offer(new long[]{v, newVal});
                }
            }
        }

        return result;
    }

    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}