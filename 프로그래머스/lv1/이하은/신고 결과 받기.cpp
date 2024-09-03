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

// 각 유저별로 처리 결과 메일을 받은 횟수
// 한 사람이 동일한 사람을 여러 번 신고해도 1회로 처리 

/*
m -> f
a -> f
f -> n
m -> n
a -> m
a -> m 
a -> m 

--- 각 유저가 신고 당한 횟수 구하기 

set<string> s; -> 동일 유저의 중복 신고에 대한 전처리 
unordered_map[신고 당한 id]++; 

--- 내가 신고한 유저가 k번 이상 신고되었는지 확인 

unordered_map<string, vector<string>> um;

muzi - frodo, neo -> 2
frodo - neo -> 1
apeach - muzi frodo -> 1
neo - x

*/

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;
    
    set<string> s(report.begin(), report.end());
    unordered_map<string, int> reported;
    unordered_map<string, vector<string>> um;
    
    for(auto str: s){
        stringstream ss(str);
        string sender, receiver;
        ss >> sender >> receiver;
        
        reported[receiver]++;
        um[sender].push_back(receiver);
    }
    
    for(int i = 0; i < id_list.size(); i++){
        string userId = id_list[i];
        
        // 신고한 유저가 없으면 해시에 저장이 안 된다.
        if(um.find(userId) == um.end()){
            answer.push_back(0);
            continue;
        }
        
        int cnt = 0;
        for(auto reportId: um[userId]){
            if(reported[reportId] >= k) cnt++;
        }
        answer.push_back(cnt);
    }
    
    return answer;
}