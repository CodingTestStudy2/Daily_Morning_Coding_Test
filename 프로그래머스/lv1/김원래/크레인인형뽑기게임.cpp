#include <string>
#include <vector>
#include <stack>

using namespace std;

stack<int> basket;
int topRows[31];
int lastRow;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    lastRow = board.size();

    for (int col = 0; col < board[0].size(); ++col)
    {
        int curRow = 0;
        while (board[curRow][col] == 0) ++curRow;
        topRows[col] = curRow;
    }


    for (int move = 0; move < moves.size(); ++move)
    {

        int col = moves[move] - 1;

        if (topRows[col] == lastRow) continue;

        if (!basket.empty() && (board[topRows[col]][col] == basket.top()))
        {
            basket.pop();
            answer += 2;
        }
        else
            basket.push(board[topRows[col]][col]);


        topRows[col]++;
    }

    return answer;
}