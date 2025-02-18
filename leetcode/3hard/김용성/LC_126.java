import java.util.*;

public class LC_126 {
    public static final int MAX = 501;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordList.addFirst(beginWord);
        List<List<Integer>> edge = new ArrayList<>();
        List<List<String>> ret = new ArrayList<>();
        int[] value = new int[wordList.size()];
        Arrays.fill(value, MAX);

        makeEdge(wordList, edge);
        Queue<Pair> queue = new LinkedList<>();

        value[0] = 0;
        List<String> firstWord = new ArrayList<>();
        firstWord.add(wordList.getFirst());
        queue.add(new Pair(0, firstWord));

        while (!queue.isEmpty()) {
            int curIdx = queue.peek().first;
            List<String> seq = queue.poll().second;

            if (wordList.get(curIdx).equals(endWord)) {
                ret.add(seq);
                continue;
            }

            for (int i = 0; i < edge.get(curIdx).size(); i++) {
                int nextIdx = edge.get(curIdx).get(i);


                if (value[nextIdx] >= value[curIdx] + 1) {
                    value[nextIdx] = value[curIdx] + 1;
                    List<String> nextSeq = new ArrayList<>(seq);
                    nextSeq.add(wordList.get(nextIdx));
                    queue.add(new Pair(nextIdx, nextSeq));
                }
            }
        }

        return ret;
    }

    private void makeEdge(List<String> wordList, List<List<Integer>> edge) {

        for (int i = 0; i < wordList.size(); i++) {
            edge.add(new ArrayList<>());
        }

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

    private class Pair {
        public Integer first;
        public List<String> second;

        public Pair(Integer first, List<String> second) {
            this.first = first;
            this.second = second;
        }
    }
}

