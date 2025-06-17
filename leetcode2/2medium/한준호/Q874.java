package 한준호;

class Solution {
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;


    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    public int robotSim(int[] commands, int[][] obstacles) {
        int dir = UP;
        int x = 0;
        int y = 0;
        int maximum = 0;
        Map<Pair, Boolean> obstacleMap = new HashMap<>();
        for(int i = 0; i<obstacles.length; i++){
            Pair pair = new Pair(obstacles[i][0], obstacles[i][1]);
            obstacleMap.put(pair, true);
        }

        for(int i = 0; i<commands.length; i++){
            if(commands[i]<0){
                dir = changeDir(dir, commands[i]);
                continue;
            }
            while(commands[i]-- > 0){
                int p = x + dx[dir];
                int q = y + dy[dir];
                Pair next = new Pair(p, q);
                if(obstacleMap.getOrDefault(next, false)) continue;
                x = p;
                y = q;
                System.out.println("now = " + x + ", "+y);
                maximum = Math.max(maximum, x*x+y*y);
            }
        }
        return maximum;
    }

    public record Pair(int x, int y){}

    private int changeDir(int dir, int want){
        if(dir == LEFT){
            if(want == -1){
                return UP;
            }
            if (want == -2){
                return DOWN;
            }
        }
        if(dir == RIGHT){
            if(want == -1){
                return DOWN;
            }
            if (want == -2){
                return UP;
            }
        }

        if(dir == UP){
            if(want == -1){
                return RIGHT;
            }
            if (want == -2){
                return LEFT;
            }
        }
        if(dir == DOWN){
            if(want == -1){
                return LEFT;
            }
            if (want == -2){
                return RIGHT;
            }
        }
        return -1;
    }
}