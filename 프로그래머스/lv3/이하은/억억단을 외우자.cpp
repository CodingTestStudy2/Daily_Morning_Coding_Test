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

// s <= x <= e 중에서 
// 억억단에서 가장 '많이' 등장한 수
// 가장 많이 등장한 수가 여러 개면, 그 중 가장 '작은' 수

/*
크기는 최대 500만 
억억단에서 특정 숫자가 등장한 횟수 구하는 방법

1 -> 1번 
2 3 5 7 -> 소수여서 2번 
4 / 1 * 4 / 2 * 2 / 4 * 1 -> 3 
6 / 1 * 6 / 2 * 3 / 3 * 2 / 6 * 1 -> 4 
8 / 1 * 8 / 2 * 4 / 4 * 2 / 8 * 1 -> 4 

9 / 1 * 9 / 3 * 3 
16 / 1 * 16 / 2 * 8 / 4 * 4 
*/

map<int, vector<int>> m; // 등장 횟수, 해당하는 숫자들 

bool isPrime(int x) {
    if (x < 2) return false;
    for (int i = 2; i * i <= x; i++) {
        if (x % i == 0) {
            return false; 
        }
    }
    return true;
}

bool isSquare(int n) {
    int sqrtN = sqrt(n);
    return sqrtN * sqrtN == n;
}

vector<int> solution(int e, vector<int> starts) {
    vector<int> answer;
    int minStart = *min_element(starts.begin(), starts.end());
    
    // minStart <= x <= e 범위의 숫자에 대해 
    // 억억단에 나타난 횟수 구해서 저장해두기 
    int cnt = 0;
    for(int x = minStart; x <= e; x++){ // N 
        if(x == 1){
            cnt = 1;
            m[cnt].push_back(x);
            continue;
        }
        
        if(isPrime(x)){
            cnt = 2;
            m[cnt].push_back(x);
            continue;
        }
        
        for(int i = 1; i * i <= x; i++){ // 루트 N 
            cnt++;
        }
        
        if(isSquare(x)){
            cnt = (cnt - 1) * 2 + 1;
        }else{
            cnt *= 2;
        }
        
        m[cnt].push_back(x);
    }
    
    // s <= x <= e 범위의 숫자 중에서 
    // 억억단에 가장 많이 등장한 숫자 
    // 등장 횟수가 같으면, 가장 작은 숫자 
    for(auto s: starts){
        bool found = false;
        
        // map의 뒤쪽부터 순회 (등장 횟수가 많은 순으로)
        for(auto it = m.rbegin(); it != m.rend(); ++it){
            for(auto x: it->second){
                // 숫자 범위 체크 
                if(x >= s && x <= e){
                    found = true;
                    answer.push_back(x);
                    break;
                }
            }
            
            if(found) break;
        }
    }
    
    return answer;
}