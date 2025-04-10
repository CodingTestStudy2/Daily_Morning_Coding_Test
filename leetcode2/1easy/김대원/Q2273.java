// 1. 아이디어 : 정렬 후 같은 원소 비교
// 2. 시간복잡도 : O(N^2)
// 3. 자료구조/알고리즘 : 정렬

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> answer = new ArrayList<>();
        for (String word : words) answer.add(word);

        for (int i = 1; i < answer.size(); i++) {
            String prev = answer.get(i - 1);
            String cur = answer.get(i);
            char[] pChars = prev.toCharArray();
            char[] cChars = cur.toCharArray();

            Arrays.sort(pChars);
            Arrays.sort(cChars);

            int idx = 0;
            boolean flag = false;
            while (pChars.length == cChars.length && idx < pChars.length) {
                if (pChars[idx] != cChars[idx]) {
                    flag = false;
                    break;
                }

                flag = true;
                idx++;
            }

            if (flag) {
                answer.remove(i);
                i--;
            }
        }

        return answer;
    }
}