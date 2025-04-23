// 1. 아이디어 : ruleKey와 매칭되는 요소 찾아서 카운팅
// 2. 시간복잡도 :
// 3. 자료구조/알고리즘 : X

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int typeIdx = 0;
        if (ruleKey.equals("color")) typeIdx = 1;
        else if (ruleKey.equals("name")) typeIdx = 2;

        int answer = 0;
        for (List<String> list : items) {
            if (list.get(typeIdx).equals(ruleValue)) {
                answer++;
            }
        }

        return answer;
    }
}