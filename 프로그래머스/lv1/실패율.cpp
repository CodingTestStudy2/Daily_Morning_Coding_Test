#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
bool compare(pair<int, double> v1, pair<int, double> v2) {
    if (v1.second == v2.second) {
        return v1.first < v2.first; 
    } else {
        return v1.second > v2.second;
    }
}
vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<pair<int,int>> count(N+1, make_pair(0,0)); 
    vector<pair<int,double>> result(N+1, make_pair(0,0.0));
    for(int i=0; i<stages.size(); i++){
        int now = stages[i];
        for(int j=1; j<count.size(); j++){
           if(now >= j){
               count[j].second += 1;
               if(now == j){
                   count[j].first += 1;
               }
           }else{
               continue;
           }
        }
    }
    
    for(int i=1; i<count.size(); i++){
        result[i].first = i;
        if(count[i].first == 0){
            result[i].second = 0.0;
        }else{
            result[i].second = double(count[i].first)/count[i].second;
        }
    }
    
    sort(result.begin()+1, result.end(), compare);
    
    for(int j=1; j<result.size(); j++){
        answer.push_back(result[j].first);
    }
    
    
    return answer;
}
