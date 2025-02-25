public class LC661 {
    public int[][] imageSmoother(int[][] img) {
        int[][] ret = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                ret[i][j] = getSmoother(img, i, j);
            }
        }

        return ret;
    }

    private int getSmoother(int[][] img, int x, int y) {
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};

        int sum = 0;
        int count = 0;
        for (int i = 0; i < dx.length; i++) {
            for (int j = 0; j < dy.length; j++) {
                int nx = x + dx[i];
                int ny = y + dy[j];
                if (nx < 0 || ny < 0 || nx >= img.length || ny >= img[nx].length) continue;
                count++;
                sum += img[nx][ny];
            }
        }

        return sum / count;
    }
}