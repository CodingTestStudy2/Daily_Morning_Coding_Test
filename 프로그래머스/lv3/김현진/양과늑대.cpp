//인터넷 참고해서 풀이
//dfs 해주는데 갈 수 있는 노드를 큐에 넣어놓고 가지고 다녀야 하고
//재방문 가능하기 때문에 큐에 한 번 넣기 그리고 방문 확인 필요 없음

#include <string>
#include <vector>
#include <queue>

using namespace std;

vector<vector<int>> vec;
vector<int> _info;
int answer = 0;

void DFS(int cur, int sheep, int wolf, queue<int>q)
{
    if(_info[cur] == 0) sheep++;
    else wolf ++;
    
    if(wolf >= sheep) return;
    
    answer = max(answer, sheep);
    
    for(int i=0;i<vec[cur].size();i++)
    {
        q.push(vec[cur][i]);
    }
    for(int i=0;i<q.size();i++)
    {
        int next = q.front();
        q.pop();
        DFS(next, sheep, wolf, q);
        q.push(next); //다시 돌아와서 재시도 가능!!
    }
}

int solution(vector<int> info, vector<vector<int>> edges) {
    
    vec.resize(info.size());
    _info.assign(info.begin(), info.end()); //dfs에서 쓰려고 전역으로 변경 
    for(int i=0;i<edges.size();i++)
    {
        vec[edges[i][0]].push_back(edges[i][1]);
    }
    queue <int> q;
    DFS(0, 0, 0, q);
    
    return answer;
}
