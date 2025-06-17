package 이재훈;

/*
1. 아이디어 :

- -2, -1일때는 움직이는 순서를 바꿔서, 그 외 숫자일때는 직접 x,y 좌표를 움직인다
- obstacles에 있는 좌표를 만났을때 멈추고 다음 command를 따른다.
- 움직이고 난다음에 maxDist를 찾아서 반환한다.

2. 시간복잡도 :
O( n  )
3. 자료구조/알고리즘 :
- /
 */

import java.util.*;

public class Q874 {
    class Solution {
        int x = 0;
        int y = 0;
        int maxDist = 0;
        Set<String> obstacleSet = new HashSet<>();
        public int robotSim(int[] commands, int[][] obstacles) {
            char direction = 'n'; // if n == north, e == east, s = south, w == west

            for(int[] obst : obstacles) {
                int row = obst[0];
                int col = obst[1];

                obstacleSet.add(col + "," + row);
            }

            for(int command : commands) {

                if(command == -2) {
                    // Turn left 90 degrees.
                    if(direction == 'n') {
                        direction = 'w';
                    } else if(direction == 'w') {
                        direction = 's';
                    } else if(direction == 's') {
                        direction = 'e';
                    } else {
                        direction = 'n';
                    }

                } else if (command == -1) {
                    // Turn right 90 degrees.
                    if(direction == 'n') {
                        direction = 'e';
                    } else if(direction == 'e') {
                        direction = 's';
                    } else if(direction == 's') {
                        direction = 'w';
                    } else {
                        direction = 'n';
                    }
                } else {
                    // move
                    for(int i = 0; i< command; i++) {
                        int nx = x;
                        int ny = y;
                        if(direction == 'n') {
                            nx++;
                        } else if(direction == 'e') {
                            ny++;
                        } else if(direction == 's') {
                            nx--;
                        } else {
                            ny--;
                        }
                        if(obstacleSet.contains(nx+ "," + ny)) break;
                        x = nx;
                        y = ny;
                        maxDist = Math.max(maxDist, (x*x) + (y*y));
                    }
                }
            }
            return maxDist;
        }

        public void move(char direction, int command) {


        }
    }
}