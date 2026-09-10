/*
1. 아이디어: 중력 적용 문제
           원래 배열에서 장애물을 만나기 전까지 '#'의 수를 계산 후, 장에물 위치-1 인덱스부터 '#'개수 만큼 채워준다.
           이후, 90도 회전 공식을 적용한다.

2. 시간복잡도: O(M) + O(M*N) + O(M*N) => O(M*N)

3. 자료구조/알고리즘: 구현

*/

class Solution {
    private int n,m;
    public char[][] rotateTheBox(char[][] boxGrid) {
        // 90도 회전시 중력 작용
        // 고정물 존재
        // 최대 500*500
        // 무조건 우측으로

        m = boxGrid.length;
        n = boxGrid[0].length;

        char[][] tmp = new char[m][n];

        for(int i=0; i<m; i++) {
            Arrays.fill(tmp[i], '.');
        }

        for(int i=0; i<m; i++) {
            int cnt = 0;
            for(int j=0; j<n; j++) {
                char c = boxGrid[i][j];

                if(c == '#') cnt++;
                else if(c == '*') {
                    tmp[i][j] = '*';
                    int idx = j-1; 

                    while(cnt>0) {
                        tmp[i][idx] = '#';
                        cnt--;
                        idx--;
                    }
                }

            }

            int idx = n-1;
            while(cnt>0) {
                tmp[i][idx] = '#';
                idx--;
                cnt--;
            }
        }

        return rotate90(tmp);
    }

    private char[][] rotate90 (char[][] tmp) {
        
        char ans[][] = new char[n][m];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                ans[j][m-1-i] = tmp[i][j];
            }
        }

        return ans;
    }
}