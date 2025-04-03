// 1. 아이디어 : 각 자리의 수 곱이 주어진 t에 나누어 떨어지는지 판단
// 2. 시간복잡도 : O(100 * 10)
// 3. 자료구조/알고리즘 :

class Solution {
    public int smallestNumber(int n, int t) {
        int answer = 0;
        while (n <= 100) {
            if (numOfMulti(n) % t == 0) {
                answer = n;
                break;
            }

            n++;
        }

        return answer;
    }

    private int numOfMulti(int num) {
        String numStr = String.valueOf(num);
        String[] arr = numStr.split("");
        int multi = 1;
        for (String e : arr) {
            multi *= Integer.parseInt(e);
        }

        return multi;
    }
}