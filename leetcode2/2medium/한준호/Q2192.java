package Leetcode.한준호;

import java.util.*;

class Solution {
    List<List<Integer>> g = new ArrayList<>();
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, Integer> indegree = new HashMap<>();
        for(int i = 0; i<n; i++){
            g.add(new ArrayList<>());
            indegree.put(i, 0);
        }
        for(int i = 0; i<edges.length; i++){
            addEdge(edges[i][0], edges[i][1]);
            indegree.merge(edges[i][1], 1, Integer::sum);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i<n; i++){
            if(indegree.get(i) == 0){
                queue.offer(i);
            }
        }
        Map<Integer, Set<Integer>> answer = new HashMap<>();
        while(!queue.isEmpty()){
            int now = queue.remove();
            List<Integer> adj = findEdges(now);
            Set<Integer> nowSet = answer.computeIfAbsent(now, key->new TreeSet<>());
            for(int i = 0; i<adj.size(); i++){
                int next = adj.get(i);
                Set<Integer> nextSet = answer.computeIfAbsent(next, key -> new TreeSet<>());
                nextSet.addAll(nowSet);
                nextSet.add(now);
                int nextIndegree = indegree.merge(next, -1, Integer::sum);
                if(nextIndegree == 0){
                    queue.add(next);
                }
            }
        }
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0; i<n; i++){
            Set<Integer> now = answer.computeIfAbsent(i, key -> new TreeSet<>());
            ret.add(now.stream().toList());
        }
        return ret;
    }

    void addEdge(int u, int v){
        g.get(u).add(v);
    }

    List<Integer> findEdges(int u){
        return g.get(u);
    }
}

/**
 * 위상정렬이 필요한가? o
 * 자바에서 그래프 표현 방법
 */