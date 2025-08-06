package Leetcode.김도연;

class Q3291 {
    static class Trie {
        Trie[] children = new Trie[26];
        void insert(String w) {
            Trie node = this;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
        }
    }

    private Trie trie;
    private String target;
    private Integer[] memo;
    private final int INF = 1 << 30;

    public int minValidStrings(String[] words, String target) {
        this.target = target;
        int n = target.length();
        trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }
        memo = new Integer[n];
        int ans = dfs(0);
        return ans >= INF ? -1 : ans;
    }

    private int dfs(int i) {
        if (i >= target.length()) return 0;
        if (memo[i] != null) return memo[i];

        Trie node = trie;
        int res = INF;
        // target[i..j]가 trie 상에 유효한 prefix인지 탐색
        for (int j = i; j < target.length(); j++) {
            int idx = target.charAt(j) - 'a';
            if (node.children[idx] == null) break;
            node = node.children[idx];
            // prefix 길이 = j - i + 1를 사용하고 이어서 계산
            res = Math.min(res, 1 + dfs(j + 1));
        }
        memo[i] = res;
        return res;
    }
}
