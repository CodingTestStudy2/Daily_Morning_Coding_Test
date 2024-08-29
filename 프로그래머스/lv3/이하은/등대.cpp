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

// 양방향, 완전 연결 그래프
// 연결된 등대 중에 적어도 하나는 ON 
// 켜둬야 하는 등대 개수의 최솟값 리턴

// 그리디하게 연결된 간선 개수가 많은 것부터 ON
// 간선 개수가 동일한 경우, 인접 노드가 OFF 된 것부터 ON

const int MAX = 100001;
vector<int> graph[MAX];

int solution(int n, vector<vector<int>> lighthouse) {
    int answer = 0;
    
    for(auto v: lighthouse){
        graph[v[0]].push_back(v[1]);
        graph[v[1]].push_back(v[0]);
    }
    
    vector<pii> edges;
    for(int i = 1; i <= n; i++){
        edges.push_back({graph[i].size(), i});
    }
    
    // 간선 개수 많은 순으로 정렬 (최소 1개)
    sort(edges.begin(), edges.end());
    
    // 각 노드의 ON/OFF 여부는 해시에 저장 
    unordered_map<int, int> um;
    um[edges[0].second] = 1; 
    
    int prevCnt = edges[0].first;
    for(int i = 1; i < edges.size(); i++){
        if(prevCnt == edges[i].first){
            // 인접 노드 검사해서 
            
            // 켜진 등대가 아예 없는 것부터 ON 
            
            // 모든 노드의 인접 노드가 
            // 적어도 하나 켜져있음을 확인한다.  
            
        }else{
            answer++;
        }
    }
    
    return answer;
}