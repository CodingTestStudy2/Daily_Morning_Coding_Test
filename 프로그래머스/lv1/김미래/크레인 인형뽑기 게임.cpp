#include <string>
#include <vector>
#include <stack>
#include <iostream>
using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    stack<int> s;
    int check[31][31] ={0,};
    
    for(int i=0; i<moves.size(); i++){
        int line = moves[i]-1;
        for(int j=0; j<board[0].size(); j++){
            int now = board[j][line];
            if(now == 0) {
                continue;
            }
            else{
                if(check[j][line] == 0){
                    check[j][line] = 1;
                    if(!s.empty() && s.top() == now ){
                        answer+=2;
                        s.pop();
                        break;
                    }else{
                    s.push(board[j][line]);
                    break;
                    }
                }
            }
        }
    }
    if(answer == 0) return 0;
    else return answer;
}
