#include <string>
#include <vector>

using namespace std;

int visit[14];
int res;


void backtrack(int studentCnt, int curSum, int curIdx, vector<int>& number)
{
    if(studentCnt == 3) {
        if(curSum == 0) ++res;
        return;
    }
    
    for(int cnt = curIdx ; cnt < number.size() ; ++cnt) {
        if(visit[cnt] == 1) continue;
        visit[cnt] = 1;
        backtrack(studentCnt + 1 , curSum + number[cnt], cnt,number);
        visit[cnt] = 0;
    }
}

int solution(vector<int> number) {
    int answer = 0;
    
    backtrack(0, 0, 0,number);
    
    answer = res;
    
    return answer;
}