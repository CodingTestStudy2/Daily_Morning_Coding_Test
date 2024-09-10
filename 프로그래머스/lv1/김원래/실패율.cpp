#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int StageCnt[503]; // 현재 위치한 stage 실패한 사람의 수
int PreSum[503]; // 몇 명이 시도 했는지

bool compare(pair<double, int>& a, pair<double, int>& b)
{
    if(a.first > b.first) return true;
    else if(a.first < b.first) return false;
    else
    {
        if(a.second > b.second) return false;
        else return true;
    }
    
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    
    for(int cnt = 0 ; cnt < stages.size() ; ++cnt)
    {
        StageCnt[stages[cnt]]++;
    }
    
    for(int cnt = N + 1 ; cnt >= 1 ; --cnt)
    {
        PreSum[cnt] = PreSum[cnt + 1] + StageCnt[cnt];
    }
    
    
    
    vector<pair<double, int>> fails;
    
    for(int cnt = 1 ; cnt <= N ; ++cnt)
    {
        if(StageCnt[cnt] == 0) fails.push_back({0, cnt});
        else fails.push_back({(double)StageCnt[cnt] / PreSum[cnt], cnt});
        
        printf("%lf\n", fails[cnt - 1].first);
    }
    
    sort(fails.begin(), fails.end(), compare);
    
    for(int cnt = 0 ; cnt < fails.size() ; ++cnt)
    {
        answer.push_back(fails[cnt].second);
    }
    
    return answer;
}