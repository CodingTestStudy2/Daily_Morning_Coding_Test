class Solution {

// i) 수평 먼저 자르는 경우
//     => verticalCut[n - 2] * n - 1 + ... + verticalCut[0] * 1
//     => horizontalCut[0] * n + .. horizontalCut[m - 1] * n;

// ii) 수직 먼저 자르는 경우
//.    => horizontalCut[0] + .. horizontalCut[m - 1];
//     => verticalCut[0] * m - 1 + ... + verticalCut[n - 1] * m - 1

// iii) 수평 + 수직 반복

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int answer = 0;
        int row = 0;
        int col = 0;
        int mSize = 1;
        int nSize = 1;

        while (row < m - 1 && col < n - 1) {
            if (horizontalCut[row] > verticalCut[col]) {
                mSize++;
                answer += horizontalCut[row++] * nSize;
            } else {
                nSize++;
                answer += verticalCut[col++] * mSize;
            }
        }

        // int first = 0;
        // for (int i = 0; i < n - 1; i++) {
        //     first += verticalCut[i];
        // }
        // // (verticalCut[i] * (i + 1));

        // for (int i = 0; i < m - 1; i++) {
        //     first += horizontalCut[i] * n;
        // }

        // int second = 0;
        // for (int i = 0; i < m - 1; i++) {
        //     second += horizontalCut[i];
        // }

        // for (int i = 0; i < n - 1; i++) {
        //     second += verticalCut[i] * m;
        // }

        return answer;
    }
}