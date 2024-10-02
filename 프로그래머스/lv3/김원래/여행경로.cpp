#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <iostream>

using namespace std;

unordered_map<string, vector<string>> map;
unordered_map<string, vector<int>> visit;
int n;

bool backtrack(string& curPos, vector<string>& curRes) { // 처음에 ICN에 push된 curRes에서 시작한다.
    curRes.push_back(curPos);
    
    //종료조건
    if(curRes.size() == n) return true;
    
    vector<string>& _paths = map[curPos];
    vector<int>& _visit = visit[curPos];
    
    for(int cnt = 0 ; cnt < _paths.size() ; ++cnt){
        if(_visit[cnt] == 1) continue;
        
        _visit[cnt] = 1;
        
        if(backtrack(_paths[cnt], curRes) == true) return true;
        
        _visit[cnt] = 0;
        curRes.pop_back();
    }
    
    return false;
}


vector<string> solution(vector<vector<string>> tickets) {
    vector<string> answer;
    
    n = tickets.size() + 1;
    
    for(vector<string> ticket : tickets) {
        if(map.find(ticket[0]) == map.end()) {
            map.insert({ticket[0], vector<string>()});
            visit.insert({ticket[0], vector<int>()});
        }
        map[ticket[0]].push_back(ticket[1]);
        visit[ticket[0]].push_back(0);
    }
    
    for(auto iter = map.begin() ; iter != map.end() ; ++iter) {
        vector<string>& adj = (*iter).second;
        sort(adj.begin(), adj.end());
    }
    
    string start = "ICN";
    
    backtrack(start, answer);
    
    return answer;
}