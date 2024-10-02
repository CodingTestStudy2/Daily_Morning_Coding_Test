#include <string>
#include <vector>
#include <set>

using namespace std;

set<int> res;
int n;


int solution(vector<int> elements) {
    int answer = 0;
    
    int sum[2001];
    
    n = elements.size();
    
    for(int cnt = 0 ; cnt < n ; ++cnt) {
        elements.push_back(elements[cnt]);
    }
    
    sum[0] = elements[0];
    
    for(int cnt = 1; cnt < elements.size() ; ++cnt) {
        sum[cnt] = sum[cnt - 1] + elements[cnt];
    }
    

    for(int range = 0 ; range < n ; ++range)
    {
        for(int start = 0 ; start < elements.size() - range; ++start)
        {
            int curSum = 0;
            
            if(start == 0) {
                curSum = sum[start + range];
            }
            else {
                curSum = sum[start + range] - sum[start - 1];
            }
            
            if(res.find(curSum) == res.end()) res.insert(curSum);
        }
    }
    answer = res.size();
    
    return answer;
}



/*

이전에 풀었던 dp문제와 비슷해보인다.
오히려 더 쉬운 문제라고 생각이 듦

dp[n] = 0부터 n까지의 합

*/