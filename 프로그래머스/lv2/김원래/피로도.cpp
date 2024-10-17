#include <string>
#include <vector>

using namespace std;

int visit[8];
int res = 0;
vector<vector<int>> dungeons;

void DFS(int curK, int dungeonCnt, int depth)
{
    if(depth == dungeons.size()) {
        res = max(res, dungeonCnt);
        return;
    }
    
    
    for(int cnt = 0 ; cnt < dungeons.size() ; ++cnt) {
        if(visit[cnt] != 1 && dungeons[cnt][0] <= curK) {
            visit[cnt] = 1;
            DFS(curK - dungeons[cnt][1], dungeonCnt + 1, depth +1);
            visit[cnt] = 0;
        }
        
        DFS(curK, dungeonCnt , depth + 1);
    }
}

int solution(int k, vector<vector<int>> _dungeons) {
    int answer = -1;
    
    dungeons = _dungeons;
    
    DFS(k, 0, 0);
    
    answer= res;
    
    return answer;
}


/*
k = 현재 유저 피로도
dungeons = 던전의 피로도 [최소 피로도, 소모 피로도]

*/