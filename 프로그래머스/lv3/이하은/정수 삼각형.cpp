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

const int MAX = 501;
int dp[MAX][MAX];

/*
7
3 8 
8 1 0 
2 7 4 4 
4 5 2 6 5
*/

int solution(vector<vector<int>> tri) {  
    int answer = 0;
    int n = tri.size();
    
    dp[0][0] = tri[0][0];
    
    for(int i = 1; i < n; i++){
        for(int j = 0; j <= i; j++){
            if(j == 0){
                dp[i][j] += dp[i - 1][j] + tri[i][j];
            }else if(j == i){
                dp[i][j] += dp[i - 1][j - 1] + tri[i][j];
            }else {
                dp[i][j] += max(dp[i - 1][j], dp[i - 1][j - 1]) + tri[i][j];
            }
            
            answer = max(answer, dp[i][j]);
        }
    }
    
    return answer;
}