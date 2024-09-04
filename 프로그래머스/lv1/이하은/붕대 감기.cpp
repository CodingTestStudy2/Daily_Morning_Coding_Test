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

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {
    int curEnergy = health;
    
    int t, x, y;
    t = bandage[0]; // 붕대 감는 시간 
    x = bandage[1]; // 1초당 얻는 체력
    y = bandage[2]; // t초 연속으로 붕대 감으면 얻는 체력 

    map<int, int> m;
    for(auto attack: attacks){ 
        m[attack[0]] = attack[1];
    }
    
    int lastAttackTime = m.rbegin()->first;
    int contiSuccessTime = 0;
    
    for(int time = 1; time <= lastAttackTime; time++){
        if(m.find(time) != m.end()){
            curEnergy -= m[time];
            contiSuccessTime = 0;

            // for문 돌다가 0 이하가 되면 바로 리턴 (오답 포인트 1)
            if(curEnergy <= 0) return -1;
            else continue;
        }
    
        curEnergy += x;
        contiSuccessTime++;
        
        if(contiSuccessTime == t){
            curEnergy += y;
            contiSuccessTime = 0;
        }
        
        // 마지막에 한꺼번에 최댓값 처리 
        // 반드시 x, y만큼 말고도 부분적으로도 체력 증가할 수 있음. (오답 포인트 2)
        if(curEnergy > health){
            curEnergy = health;
        }
    }
    
    if(curEnergy <= 0) return -1;
    else return curEnergy;
}