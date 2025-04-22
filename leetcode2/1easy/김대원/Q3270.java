// 1. 아이디어 : 각 자리수의 최솟값으로 완성한 수를 반환
// 2. 시간복잡도 : O(N)
// 3. 자료구조/알고리즘 : 구현

class Solution {
    public int generateKey(int num1, int num2, int num3) {
        String[] strs = new String[3];
        strs[0] = n2s(num1);
        strs[1] = n2s(num2);
        strs[2] = n2s(num3);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String str = strs[i];
            sb.append(str);
            while (sb.length() != 4) {
                sb.insert(0, 0);
            }

            strs[i] = sb.toString();
            sb.setLength(0);
        }

        for (int i = 0; i < 4; i++) {
            int digit1 = strs[0].charAt(i) - 48;
            int digit2 = strs[1].charAt(i) - 48;
            int digit3 = strs[2].charAt(i) - 48;
            int min = Math.min(digit1, Math.min(digit2, digit3));
            sb.append(min);
        }

        return Integer.parseInt(sb.toString());
    }

    private String n2s(int num) {
        return String.valueOf(num);
    }
}