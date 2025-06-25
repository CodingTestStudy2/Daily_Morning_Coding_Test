package 한준호;

class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, -1, 1};
        if (a == e) {
            if (!(a == c && b < d && d < f) && !(a == c && f < d && d < b)) {
                System.out.println(1);
                return 1;
            }
        }
        if (b == f) {
            if (!(b == d && a < c && c < e) && !(b == d && e < c && c < a)) {
                System.out.println(3);
                return 1;
            }
        }
        /**
         0 0 1
         0 2 0
         3 0 0
         */

        for(int tt = 0; tt < 4; tt++){
            int x = c;
            int y = d;
            while(x>= 1 && x <= 8 && y >= 1 && y<= 8){
                int p = x + dx[tt];
                int q = y + dy[tt];
                if(p == a && q == b){
                    break;
                }
                if(p == e && q == f){
                    return 1;
                }
                x = p;
                y = q;
            }
        }

        return 2;
    }
}

// (x + y)%2
// 무조건 2번 이내?
// 비숍이 룩의 길을 막고 있을수도
// 비숍이 길을 열어주는게 최선의 답일 가능성

/**
 * 1. 룩이 공격
 * - 같은 열, 가로막히지 않음 - 1번
 * - 같은 열, 가로막힘 - 2번
 * - 다른 열, 가로막을 수 없는 구조 - 2번
 * <p>
 * 2. 비숍이 공격
 * - 비숍은 룩의 성능덕에 한번에 공격할 수 있는지만 보면 될듯?
 * - 한번에 공격 불가 - 룩에 가로막힘
 */