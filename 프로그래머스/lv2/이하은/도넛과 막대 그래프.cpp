
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

const int MAX = 1000001;
vector<int> graph[MAX];
int in[MAX];
int out[MAX];
int N;
int t0, t1, t8;

int findCreatedNode(){
    for(int i = 1; i <= N; i++){
        if(in[i] == 0 && out[i] >= 2){
            return i;
        }
    }
    return -1;
}

// 도넛: 사이클 형성 (이동하다가 시작점으로 돌아옴.)
// 막대: 이동하다가 끊어짐.
// 8자: 사이클 형성 & 진입, 진출 차수 2인 가운데 노드가 있음. 
void dfs(int start, int now){
    if(in[now] == 0 && out[now] == 0){
        t1++;
        return;
    }
    
    if(in[now] == 1 && out[now] == 0){
        t1++;
        return;
    }
    
    if(in[now] == 2 && out[now] == 2){
        t8++;
        return;
    }
    
    for(int i = 0; i < graph[now].size(); i++){
        int adj = graph[now][i];
        
        if(out[adj] == 0){
            t1++;
            return;
        }

        if(start == adj){
            t0++;
            return;
        }
        
        dfs(start, adj);
    }
}

void removeEdges(int now){
    // 연결된 노드의 진입 차수 -1
    for(int i = 0; i < graph[now].size(); i++){
        int adj = graph[now][i];
        in[adj]--;
        
        // 연결된 그래프 종류 구분
        dfs(adj, adj);
    }
}

vector<int> solution(vector<vector<int>> edges) {
    vector<int> answer;
    
    for(auto v: edges){
        graph[v[0]].push_back(v[1]);
        in[v[1]]++;
        out[v[0]]++;
        
        // 전체 노드 개수 구하기 
        N = max(N, v[0]);
        N = max(N, v[1]);
    }
    
    int nodeNum = findCreatedNode();
    removeEdges(nodeNum);
    
    answer.push_back(nodeNum);
    answer.push_back(t0);
    answer.push_back(t1);
    answer.push_back(t8);
    
    return answer; 
}