package 한준호;

import java.util.*;


class Solution {

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public int minPushBox(char[][] grid) {
        Queue<NextMove> bfsQ = new ArrayDeque<>();
        Map<NextMove, Integer> check = new HashMap<>();
        Position firstBoxPos = null;
        Position firstHumanPos = null;
        Position endPos = null;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'B') {
                    firstBoxPos = new Position(i, j);
                }
                if(grid[i][j] == 'S') {
                    firstHumanPos = new Position(i, j);
                }
                if(grid[i][j] == 'T') {
                    endPos = new Position(i, j);
                }
            }
        }
        List<NextMove> can = checkBoxCanMove(grid, firstHumanPos, firstBoxPos);
        for (NextMove next : can) {
            bfsQ.add(next);
            check.put(next, 1);
        }
        while (!bfsQ.isEmpty()) {
            NextMove now = bfsQ.poll();
            Position nextBoxPos = now.position;
            Position nextHumanPos = now.getBeforePosition();
            List<NextMove> nextList = checkBoxCanMove(grid, nextHumanPos, nextBoxPos);
            for (NextMove next : nextList){
                if(check.get(next) == null) {
                    check.put(next, check.get(now) + 1);
                    bfsQ.add(next);
                }
            }
        }
        int result = 1_000_000_000;
        for (int k = 0; k< 4; k++){
            NextMove end = new NextMove(endPos, k);
            if(check.get(end) != null) {
                result = Math.min(result, check.get(end));
            }
        }
        if(result == 1_000_000_000){
            return -1;
        }
        return result;
    }



    public List<NextMove> checkBoxCanMove(char[][] grid, Position humanPosition, Position boxPosition){
        List<NextMove> result = new ArrayList<>();
        Queue<Position> bfsQ = new ArrayDeque<>();
        int[][] check = new int[grid.length][grid[0].length];
        check[humanPosition.x][humanPosition.y] = 1;
        bfsQ.add(humanPosition);
        while(!bfsQ.isEmpty()){
            Position nowPos = bfsQ.poll();
            int x = nowPos.x;
            int y = nowPos.y;

            for(int k = 0; k<4; k++){
                int p = x + dx[k];
                int q = y + dy[k];
                Position nextPos = new Position(p, q);
                if(p<0||p>=grid.length || q<0 || q>=grid[0].length) continue;
                if(check[p][q] == 1)continue;
                if(grid[p][q] == '#' || nextPos.equals(boxPosition)) continue;
                check[p][q] = 1;
                bfsQ.add(nextPos);
            }
        }
        for(int k = 0; k<4; k++){
            int x = boxPosition.x + dx[k];
            int y = boxPosition.y + dy[k];
            int rx = boxPosition.x - dx[k];
            int ry = boxPosition.y - dy[k];
            if(x < 0 || x >= grid.length || y < 0 ||  y>= grid[0].length) continue;
            if(grid[x][y] == '#') continue;
            if(rx < 0 || rx >= grid.length || ry < 0 || ry >= grid[0].length) continue;
            if(check[rx][ry] == 0) continue;
            result.add(new NextMove(new Position(x, y), k));
        }
        return result;
    }
}
class NextMove{
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public Position position;
    public int dir;

    public NextMove (Position position, int dir){
        this.position = position;
        this.dir = dir;
    }

    public Position getBeforePosition() {
        return new Position(position.x - dx[dir], position.y-dy[dir]);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NextMove nextMove = (NextMove) o;
        return dir == nextMove.dir && Objects.equals(position, nextMove.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, dir);
    }

    @Override
    public String toString() {
        return "NextMove{" +
                "position=" + position +
                ", dir=" + dir +
                '}';
    }
}

class Position{

    public int x;
    public int y;


    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
/**
 * 밀어낼 수 없으면 -1
 * 연결 요소를 매번 새로 평가?
 * 갈 수 있고 없음은 한번에 평가되나?
 * 박스를 끌고 가면
 * 사람이 갈 수 있는 곳을 먼저 파악하는게 박스 미는데 도움이 되나? 안됨. 결국 현재 상황에 맞춰 밀어야됨 - 4방향 가능성, 밀 수 있는 방향 자체를 BFS로
 [-]-
 ---
 []
 []
 */

/**
 이동 가능 여부 확인
 0. 현재 사람의 위치와 박스의 위치를 계산한다 - 초기 상태가 먼저 계산되어야 함
 (기존 방향 반대편에 사람이 있다고 가정? 이미 이동 완료된 상태라고 가정? 글로 갈 수 있다고 가정? now때 옮기기? o).
 1. 사람이 그 뒤로 갈 수 있는지 체크해본다.
 2. 박스가 그 자리로 갈 수 있는지 체크해본다.
 */