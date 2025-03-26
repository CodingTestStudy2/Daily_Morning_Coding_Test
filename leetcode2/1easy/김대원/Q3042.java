// 1. 아이디어 : 단순 반복문. word의 prefix, subfix 비교
// 2. 시간복잡도 : O(N^2 * M)
// 3. 자료구조/알고리즘 : 완전 탐색

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int length = words.length;
        int answer = 0;
        for (int i = 0; i < length; i++) {
            String pre = words[i];
            for (int j = i + 1; j < length; j++) {
                String sub = words[j];
                if (pre.length() > sub.length()) continue;
                if (pre.equals(sub.substring(0, pre.length())) && pre.equals(sub.substring(sub.length() - pre.length(), sub.length()))) {
                    answer++;
                }
            }
        }

        return answer;
    }
}