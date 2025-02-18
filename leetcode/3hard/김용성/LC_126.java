import java.util.*;

public class LC_126 {
    class Solution {
        public static final int MAX = 501;
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<Integer>> edge = new ArrayList<>(wordList.size());
            int[] value = new int[wordList.size() + 2];
            Arrays.fill(value, MAX);

            makeEdge(beginWord, endWord, wordList, edge);

            Queue<Integer> queue = new LinkedList<>();

            queue.add(0);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int i = 0; i < edge.get(cur).size(); i++) {
                    int next = edge.get(cur).get(i);

                    if(value[next] > value[cur] + 1) {
                        value[next] = value[cur] + 1;
                        queue.add(next);
                    }
                }
            }

            if(value[wordList.size()-1] == MAX) return new ArrayList<>();
            return 
        }

        private void makeEdge(String beginWord, String endWord, List<String> wordList, List<List<Integer>> edge) {
            wordList.add(0, beginWord);
            wordList.add(endWord);

            for (int i = 0; i < wordList.size(); i++) {
                for (int j = i + 1; j < wordList.size(); j++) {
                    if (isSimilarWord(wordList.get(i), wordList.get(j))) {
                        edge.get(i).add(j);
                        edge.get(j).add(i);
                    }
                }
            }
        }

        public boolean isSimilarWord(String word1, String word2) {
            int check = 0;
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    check++;
                    if (check > 1) return false;
                }
            }
            return true;
        }
    }
}
