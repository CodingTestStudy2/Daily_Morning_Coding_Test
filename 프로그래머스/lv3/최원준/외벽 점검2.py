# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :


import java.util.*;

class Solution {
    int totalFriends;
    int weakLength;
    Set<Integer> visited = new HashSet<>();
    ArrayList<ArrayList<Integer>> permutations = new ArrayList<>();
    public void getPermutation(ArrayList<Integer> permutation, int[] dist){
        if (permutation.size() == totalFriends) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for (int i=0; i<totalFriends; i++) {
            if (visited.contains(dist[i])) continue;
            visited.add(dist[i]);
            permutation.add(dist[i]);
            getPermutation(permutation, dist);
            permutation.remove(permutation.size()-1);
            visited.remove(dist[i]);
        }
    }

    public int solution(int n, int[] weak, int[] dist) {
        totalFriends = dist.length;
        weakLength = weak.length;
        int[] weak2 = new int[weakLength * 2];
        for (int i = 0; i<weakLength; i++) {
            weak2[i] = weak[i];
            weak2[i+weakLength] = weak[i] + n;
        }

        getPermutation(new ArrayList<>(), dist);

        int ans = totalFriends + 1;

        for (var permutation : permutations) {
            for (int startIdx = 0; startIdx < weakLength; startIdx++) {
                int friendIdx = 0;
                int maxPosition = weak2[startIdx] + permutation.get(friendIdx);

                for (int i = startIdx; i < startIdx + weakLength; i++) {
                    if (maxPosition < weak2[i]) {
                        friendIdx++;
                        if (friendIdx == permutation.size()) break;
                        maxPosition = weak2[i] + permutation.get(friendIdx);
                    }
                }
                ans = Math.min(ans, friendIdx+1);
            }
        }
        return ans > totalFriends? -1: ans;
    }
}
'''


