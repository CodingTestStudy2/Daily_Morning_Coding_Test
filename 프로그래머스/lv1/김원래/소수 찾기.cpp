#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(int n) {
    int answer = 1;
    
    vector<int> moduleNums;
    
    moduleNums.push_back(2);
    
    for(int num = 3 ; num <= n ; ++num)
    {
        bool flag = true;
        
        for(int modIdx = 0 ; modIdx < moduleNums.size() ; ++modIdx)
        {
            if(sqrt(num) < moduleNums[modIdx]) break;
            
            if(num % moduleNums[modIdx] == 0)
            {
                flag = false;
                break;
            }
        }
        
        if(flag)
        {
            moduleNums.push_back(num);
            ++answer;
        }
    }
    
    return answer;
}

/*

10

1 10

*/