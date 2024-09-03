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

vector<int> solution(int e, vector<int> starts) {
    vector<int> answer;
    
    // 억억단에서 특정 숫자의 등장 횟수 구하기 (약수 개수)
    vector<int> arr(e + 1, 0);
    for(int i = 1; i <= e; i++){
        for(int j = i; j <= e; j += i){
            arr[j]++;
        }
    }
    
    vector<int> dp(e + 1, 0);
    int minStart = *min_element(starts.begin(), starts.end());
    
    // dp[i]: [i, e] 범위에서 가장 많이 등장한 수 (minStart <= i <= e)
    // [e, e]
    // [e - 1, e]
    // ...
    // [minStart, e]
    // start 위치가 뒤에서 앞으로 이동하며 범위가 점점 넓어짐. 
    
    dp[e] = e;
    for(int i = e - 1; i >= minStart; i--){
        // 바로 이전 범위 내에서 가장 많이 등장한 숫자보다
        // 현재 숫자의 등장 횟수가 더 크거나 같은 경우 dp 테이블 갱신
        // 등호를 포함시켜서 dp 테이블에 더 작은 숫자 저장하도록 
        if(arr[i] >= arr[dp[i + 1]]) dp[i] = i; 
        
        // 그렇지 않으면, 바로 이전 범위 내의 최대 등장 숫자 유지
        else dp[i] = dp[i + 1];
    }
    
    for(auto s: starts){
        answer.push_back(dp[s]);
    }
    
    return answer;
}