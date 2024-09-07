#include <string>
#include <vector>
#include <list>
#include <algorithm>
#include <iostream>
using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    list<int> q;
    
    for(int i=0; i<operations.size(); i++){
        if(operations[i][0] == 'I'){
            int num = stoi(operations[i].substr(2));
            q.push_front(num);
            q.sort();
        }else if(operations[i][0] == 'D'){
            if(q.empty()){
                continue;
            }else{
                if(operations[i][2] == '-'){
                    q.pop_front();
                }else{
                    q.pop_back();
                }
            }
        }
    }
    
    if(q.empty()){
        answer.push_back(0);
        answer.push_back(0);
    }else{
        answer.push_back(q.back());
        answer.push_back(q.front());
    }
    return answer;
}
