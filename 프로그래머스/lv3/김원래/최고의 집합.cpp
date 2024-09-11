#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, int s) {
    vector<int> answer;
    
    if(s % n == 0)
    {
        if(s / n == 0) answer.push_back(-1);
        else
        {
            int val = s / n;
        
            for(int cnt = 0 ; cnt < n ; ++cnt)
            {
                answer.push_back(val);
            }
        }
    }
    else
    {
        if(s / n == 0) answer.push_back(-1);
        else
        {
            int leaveVal = s % n;
         
            int val = s / n;
        
            for(int cnt = 0 ; cnt < n - leaveVal; ++cnt)
            {
                answer.push_back(val);
            }
            
            for(int cnt = 0 ; cnt < leaveVal ; ++cnt)
            {
                answer.push_back(val + 1);
            }
        }
        
    }
    
    return answer;
}


/*

1. 각 원소의 합이 S가 되는 집합
2. 각 원소의 곱이 최대가 되는 집합

17
26
35
44


*/