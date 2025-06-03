# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


'''
import java.util.*;
class Leetcode.이재훈.Solution {
    int[] par;
    
    int find(int x) {
        if (x != par[x]) {
            par[x] = find(par[x]);
        } 
        return par[x];
    }
    
    void union(int a, int b){
        int ra = find(a);
        int rb = find(b);
        par[rb] = ra;
    }
    
    
    public int solution(int n, int[][] computers) {
        par = new int[n];
        for (int i=0; i<n; i++){
            par[i] = i;
        }
        int row = computers.length, col = computers[0].length;
        for (int r=0; r<row; r++) {
            for (int c=0; c<col; c++) {
                if (computers[r][c] == 1) {
                    union(r, c);
                }
            }
        }
        int ans = 0;
        for (int i=0; i<n; i++){
            ans += par[i] == i ? 1 : 0;
        }
        return ans;
    }
}'''