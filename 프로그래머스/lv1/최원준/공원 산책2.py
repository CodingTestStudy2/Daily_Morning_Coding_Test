# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''

def solution(park, routes):
    def check(row, col, dir, dist):
        for i in range(1, dist+1):
            if dir == "S":
                row+=1
            elif dir == "N":
                row-=1
            elif dir == "W":
                col-=1
            elif dir == "E":
                col += 1

            if not (row in range(n) and col in range(m)) or park[row][col] == "X":
                return False
        return True

    n, m = len(park), len(park[0])
    sx, sy = -1, -1
    for row in range(n):
        for col in range(m):
            if park[row][col] == "S":
                sx, sy = row, col
                break

    for route in routes:
        dir, dist = route.split(" ")
        dist = int(dist)
        if check(sx, sy, dir, dist):
            if dir == "S":
                sx += dist
            elif dir == "N":
                sx -= dist
            elif dir == "W":
                sy -= dist
            elif dir == "E":
                sy += dist

    return [sx, sy]



'''
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    boolean canMove(char[][] carr, int row, int col, char dir, int dist){
        for (int i=1; i<=dist; i++) {
            switch (dir) {
                case 'S':
                    row += 1; break;
                case 'N':
                    row -= 1; break;
                case 'W':
                    col -= 1; break;
                case 'E':
                    col += 1; break;
            }
            if (!(0<=row && row< carr.length && 0<=col && col<carr[0].length) || carr[row][col] == 'X') {
                return false;
            }
        }
        return true;
    }
    
    public int[] solution(String[] park, String[] routes) {
        char[][] carr = new char[park.length][];
        for (int i=0; i<park.length; i++){
            carr[i] = park[i].toCharArray();
        }
        
        int n = carr.length, m = carr[0].length;
        int sx = -1, sy = -1;
        for (int row=0; row<n; row++){
            for (int col=0; col<m; col++){
                if (carr[row][col] == 'S') {
                    sx = row; 
                    sy = col;
                    break;
                }
            }
        }
        
        for (String route:routes){
            String[] routeArr = route.split(" ");
            char dir = routeArr[0].charAt(0);
            int dist = Integer.parseInt(routeArr[1]);
            
            if (canMove(carr, sx, sy, dir, dist)) {
                switch (dir) {
                    case 'N': sx-=dist; break;
                    case 'S': sx+=dist; break;
                    case 'W': sy-=dist; break;
                    case 'E': sy+=dist; break;
                }
            }
        }
        
        return new int[]{sx, sy};
    }
}
'''