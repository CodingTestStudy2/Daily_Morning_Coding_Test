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

// x 좌표의 최소a 최대c
// y 좌표의 최소b 최대d
// 시작점 (a, b) 끝점 (c, d)

vector<int> solution(vector<string> wallpaper) {
    int minX = 1e9, maxX = -1; // 행 
    int minY = 1e9, maxY = -1; // 열 
    
    for(int i = 0; i < wallpaper.size(); i++){
        for(int j = 0; j < wallpaper[i].size(); j++){
            char ch = wallpaper[i][j];
            if(ch == '#'){
                minX = min(minX, i);
                maxX = max(maxX, i);
                
                minY = min(minY, j);
                maxY = max(maxY, j);
            }
        }
    }
    
    return {minX, minY, maxX + 1, maxY + 1};
}