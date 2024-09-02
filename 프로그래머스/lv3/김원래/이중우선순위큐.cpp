#include <string>
#include <vector>
#include <map>

using namespace std;

map<int, int> nums;

void Oper(string& operation)
{
    char operKind = operation[0];
    int num = stoi(operation.substr(1, operation.size()));
    
    if(operKind == 'I')
    {
        if(nums.find(num) == nums.end()) nums.insert({num, 1});
        else nums[num]++;
    }
    else if(operKind == 'D')
    {
        if(nums.size() == 0) return;
        
        if(num == 1)
        {
            auto endIter = nums.end();
            --endIter;
            
            if(nums[(*endIter).first] > 1) nums[(*endIter).first]--;
            else nums.erase(endIter);
        }
        else
        {
            auto beginIter = nums.begin();
            
            if(nums[(*beginIter).first] > 1) nums[(*beginIter).first]--;
            else nums.erase(beginIter);
        }
    }
}

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    
    for(int cnt = 0 ; cnt < operations.size() ; ++cnt)
    {
        Oper(operations[cnt]);
    }
    
    if(nums.size() > 0)
    {
        auto maxIter= nums.end();
        maxIter--;
        answer.push_back((*maxIter).first);
        
         answer.push_back((*nums.begin()).first);
    }
    else
    {
        answer = { 0, 0};
    }
    
    return answer;
}


/*

1. I 숫자 큐에 주어진 숫자를 삽입
2. D 1 큐에서 최댓값을 삭제
3. D - 1 큐에서 최솟값을 삭제

*/