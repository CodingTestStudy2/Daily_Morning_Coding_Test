package 한준호;

class Solution {
    public static int[][] dx = {{0, -1, 0, 0, -1, -1}, {0, 1, 1, 1, 0, 0}};
    public static int[][] dy = {{-1, 0, -1, 1, 0, 0}, {1, 0, 0, 0, -1, 1}};
    public boolean hasValidPath(int[][] grid) {
        Queue<Pair> bfsQ = new LinkedList<>();
        bfsQ.add(new Pair(0, 0));
        int[][] check = new int[grid.length][grid[0].length];
        check[0][0] = 1;
        while(!bfsQ.isEmpty()){
            Pair now = bfsQ.remove();
            int x = now.x;
            int y = now.y;
            for(int dir = 0; dir<2; dir++){
                int p = x + dx[dir][grid[x][y] - 1];
                int q = y + dy[dir][grid[x][y] - 1];
                if(p < 0 || p >= grid.length || q < 0 || q>= grid[0].length) continue;
                if(check[p][q] != 0)continue;
                for(int dir2 = 0; dir2 < 2; dir2++){
                    int r = p + dx[dir2][grid[p][q] - 1];
                    int s = q + dy[dir2][grid[p][q] - 1];
                    if(r != x || s != y) continue;
                    check[p][q] = 1;
                    bfsQ.add(new Pair(p, q));
                }
            }
        }
        if(check[grid.length-1][grid[0].length-1] == 1)return true;
        else return false;
    }

    public record Pair(int x, int y){};

    // 입구와 출구
    // 서로 반대가 될 수도 있음
    // 현재 지점의 출입구를 통해 다음 위치 추정
    // 다음 지점의 출입구에 내가 있을 수 있는가 -> 다음으로 건너갈 수 있는가
}