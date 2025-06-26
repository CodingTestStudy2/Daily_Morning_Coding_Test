class Solution {
    public double largestTriangleArea(int[][] points) {
        double answer = 0.0;
        int n = points.length;
        // x1 x2 x3
        // y1 y2 y3
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int[] p1 = points[i], p2 = points[j], p3 = points[k];
                    answer = Math.max(
                            answer,
                            Math.abs((double) (p1[0] * (p2[1] - p3[1]) +
                                    p2[0] * (p3[1] - p1[1]) +
                                    p3[0] * (p1[1] - p2[1])
                            )) / 2
                    );
                }
            }
        }

        return answer;
    }
}
