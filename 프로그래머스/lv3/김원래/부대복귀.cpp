#include <string>
#include <vector>
#include <queue>
#include <string.h>

using namespace std;

int visit[100001];

vector<vector<int>> adj;

int BFS(int start, int dest) {
    queue<pair<int,int>> q;
    
    q.push({start, 0});
    
    while(!q.empty()) {
        pair<int,int> top = q.front();
        q.pop();
        
        int region = top.first;
        int moveCnt = top.second;
        
        if(region == dest) {
            ::memset(visit, 0, sizeof(visit));
            return moveCnt;
        }
        
        for(int cnt = 0 ; cnt < adj[region].size() ; ++cnt) {
            if(visit[adj[region][cnt]] == 0) {
                visit[adj[region][cnt]] = 1;
                q.push({adj[region][cnt], moveCnt + 1});
            }
        }
    }
    
    ::memset(visit, 0, sizeof(visit));
    
    return -1;
}

vector<int> solution(int n, vector<vector<int>> roads, vector<int> sources, int destination) {
    vector<int> answer;
    
    adj.resize(n + 1, vector<int>());
    
    for(int cnt = 0 ; cnt < roads.size() ; ++cnt) {
        adj[roads[cnt][0]].push_back(roads[cnt][1]);
        adj[roads[cnt][1]].push_back(roads[cnt][0]);
    }
    
    for(int cnt = 0 ; cnt < sources.size() ; ++cnt) {
        int res = BFS(sources[cnt], destination);
        answer.push_back(res);
    }
    
    
    return answer;
}