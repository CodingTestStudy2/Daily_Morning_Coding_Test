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

const int MAX = 51;
int N, M;

vector<string> g_park;
vector<string> g_routes;
bool visited[MAX];
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};

int getIdxOfDirention(char dir){
    if(dir == 'E'){
        return 0;
    }else if(dir == 'W'){
        return 1;
    }else if(dir == 'S'){
        return 2;
    }else{
        return 3;
    }
}

pii getNextPos(int x, int y, int idx, int dist){
    int sx = x;
    int sy = y;
    
    int nx, ny;
    for(int i = 0; i < dist; i++){
        nx = x + dx[idx];
        ny = y + dy[idx];

        if(nx < 0 || nx >= N || ny < 0 || ny >= M || 
           g_park[nx][ny] == 'X') {
            return {sx, sy}; // 초기 위치로 리턴
        }
        
        // 위치 갱신 
        x = nx;
        y = ny;
    }
    
    // 최종 변경된 위치로 리턴 
    return {nx, ny};
}

pii moveDog(int x, int y){
    for(int i = 0; i < g_routes.size(); i++){
        char dir = g_routes[i][0];
        int dist = g_routes[i][2] - '0';
        int dirIdx = getIdxOfDirention(dir);
        
        pii nextPos = getNextPos(x, y, dirIdx, dist);
        x = nextPos.first;
        y = nextPos.second;
    }
    
    return {x, y};
}

vector<int> solution(vector<string> park, vector<string> routes) {
    g_park = park;
    g_routes = routes;
    N = park.size(); 
    M = park[0].size(); 
    
    pii ans;
    for(int i = 0; i < park.size(); i++){
        for(int j = 0; j < park[i].size(); j++){
            if(park[i][j] == 'S'){
                ans = moveDog(i, j);
                break;
            }
        }
    }
    
    return {ans.first, ans.second};
}