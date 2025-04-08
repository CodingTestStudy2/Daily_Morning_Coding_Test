// 1. 아이디어 : 노드가 존재할 때, 자식 노드 개수 판단
// 2. 시간복잡도 : O(N)
// 3. 자료구조/알고리즘 : 그리디

class Solution {

    // 9: cnt = --: 0 -> 2
    // 3: cnt = --: 1 -> 3
    // 4: cnt = --: 2 -> 4
    // 1: cnt = --: 1 -> 3
    // 2: cnt = --: 0 -> 2
    // 6: cnt = --; 0 -> 2

    public boolean isValidSerialization(String preorder) {
        int child = 1;
        String[] strs = preorder.split(",");
        for (String str : strs) {
            child--;
            if (child >= 0)  {
                if (!str.equals("#")) child += 2;
            } else break;
        }

        return child == 0;
    }
}
