#include <string>
#include <vector>
#include <iostream>
#include <map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    map<string, int> clothes_map;
    
    for(int i=0; i<clothes.size(); i++){
        string category = clothes[i][1];
        if(clothes_map.find(category) == clothes_map.end()){
            clothes_map[category]=1;
        }else{
            clothes_map[category] += 1 ;
        }        
    }
    
    for(auto iter = clothes_map.begin(); iter!=clothes_map.end(); iter++){
        answer *= ++(iter->second);
    }
    
    
    
    return --answer;
}
