#include <iostream>
#include <string> 
#include <cstring>
#include <sstream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <stack>
#include <queue>
#include <map>
#include <set>
#include <unordered_set>
#include <unordered_map>
using namespace std;
typedef long long ll;
typedef pair<int, int> pii;

const int MAX = 100001;
vector<int> graph[MAX];
bool light[MAX];
int answer = 0;

void dfs(int now, int parent){
    for(int i = 0; i < graph[now].size(); i++){
        int child = graph[now][i];
        
        // 잎 노드까지 온 경우 (1 -> 2 -> 3 -> 2)
        if(child == parent){
            // 불을 켜지 않고 다른 자식 노드 탐색으로 넘어감.
            // 바로 리턴하면 안 된다!!
            continue;
        }
        
        // 잎 노드까지 재귀 호출 
        dfs(child, now);
        
        // 자식, 현재 노드 중에 현재 노드부터 불 켠다. 
        if(!light[child] && !light[now]){
            light[now] = true;
            answer++;
        }
    }
}

int solution(int n, vector<vector<int>> lighthouse) {
    // 양방향으로 연결 
    for(auto v: lighthouse){
        graph[v[0]].push_back(v[1]);
        graph[v[1]].push_back(v[0]);
    }
    
    // 루트 노드 1번부터 탐색 시작 
    dfs(1, 1);
    
    return answer;
}