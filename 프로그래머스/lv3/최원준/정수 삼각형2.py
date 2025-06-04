# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''

'''
class Leetcode.이재훈.이재훈.Solution {
    public int solution(int[][] triangle) {
        int total_row = triangle.length;
        for (int row = total_row-2; row>=0; row--) {
            int total_col = triangle[row].length;
            for (int col=0; col<total_col; col++) {
                triangle[row][col] += Math.max(triangle[row+1][col], triangle[row+1][col+1]);
            }
        }
        return triangle[0][0];
    }
}
'''