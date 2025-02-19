import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC827 {
    public int largestIsland(int[][] grid) {
        bfs(grid);
    }

    private void bfs(int[][] grid, List<Integer> Points) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(Points.get(0));

    }

    private List<Integer> getZeroPoints(int[][] grid) {
        List<Integer> zeroPoints = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    zeroPoints.add(i);
                }
            }
        }
        return zeroPoints;
    }
}
