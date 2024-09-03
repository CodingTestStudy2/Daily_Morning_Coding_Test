#include <string>
#include <vector>

using namespace std;

int maxSum = 0;

int d[501][501];

void backtrack(vector<vector<int>>& triangle ,int& curSum, int curRow, int curCol)
{   
    curSum += triangle[curRow][curCol];
    
    if(triangle.size() - 1 == curRow)
    {
        maxSum = max(maxSum, curSum);
    }
    else
    {
        if(curSum > d[0][0])
        {
            d[curRow][curCol] = curSum;
            backtrack(triangle, curSum, curRow + 1, curCol);
            backtrack(triangle, curSum, curRow + 1, curCol + 1);
        }

    }

    curSum -= triangle[curRow][curCol];
}

int solution(vector<vector<int>> triangle) {
    int answer = 0;

    
    for(int row = 0 ; row < triangle.size() ; ++row)
    {
        for(int col = 0 ; col < triangle[row].size() ; ++col)
        {
            d[row][col] = -1;
        }
    }
    
    int sum = 0;
    backtrack(triangle, sum, 0, 0);

    
    answer = maxSum;
    
    return answer;
}