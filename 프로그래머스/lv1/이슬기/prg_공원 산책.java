/**
* 1. 강아지 이동
* 2. 갈 수 있는지 확인
* 3. 갈 수 있으면 해당 루트 추가, 갈 수 없으면 무시
*/
import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        Queue<int[]> q = new LinkedList<>();
        int n = park.length;
        int m = park[0].length();
        for (int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (park[i].charAt(j) == 'S') {
                    q.add(new int[]{i, j});
                    break;
                }
            }
        }
        //System.out.println(Arrays.toString(q.peek()));
        
        for (int i=0; i<routes.length; i++) {
            int[] now = q.poll();
            String[] route = routes[i].split(" ");
            int nx = now[0];
            int ny = now[1];
            boolean isTrue = true;
            
            for (int j=0; j<Integer.parseInt(route[1]); j++) {
                if (route[0].equals("E")) {
                    ny += 1;
                } else if (route[0].equals("S")) {
                    nx += 1;
                } else if (route[0].equals("W")) {
                    ny -= 1;
                } else if (route[0].equals("N")) {
                    nx -= 1;
                }

                if (0 <= nx && nx < n && 0 <= ny && ny < m && park[nx].charAt(ny) != 'X') {
                    continue;
                } else {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) {
                q.add(new int[]{nx, ny});
            } else {
                q.add(now);
            }
        }
        //System.out.println(Arrays.toString(q.peek()));
        
        return q.peek();
    }
}