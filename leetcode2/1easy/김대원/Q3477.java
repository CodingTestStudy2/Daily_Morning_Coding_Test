// 1. 아이디어 : 순차적으로 버킷에 채우면서, 채울 수 없으면 버림
// 2. 시간복잡도 : O(N^2)
// 3. 자료구조/알고리즘 : 완전 탐색

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int answer = 0;
        int n = fruits.length;
        int result = n;
        int[] ch = new int[n];
        for (int i = 0; i < n; i++) {
            int friut = fruits[i];
            for (int j = 0; j < n; j++) {
                if (ch[j] == 0 && friut <= baskets[j]) {
                    ch[j] = 1;
                    result--;
                    break;
                }
            }
        }

        return result;
    }
}
