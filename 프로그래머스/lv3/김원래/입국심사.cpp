#include <string>
#include <vector>
#include <algorithm>

using namespace std;


long long biSectLeft(long long left, long long right, int n, vector<int>& times) {
    
    while(left < right) {
        long long mid = (left + right) / 2;
        
        long long personCnt = 0;
        
        for(int cnt = 0 ; cnt < times.size() ; ++cnt) {
            personCnt += mid / times[cnt];
        }
        
        if(personCnt >= n) right = mid;
        else left = mid + 1;
    }
    
    return right;
}

long long solution(int n, vector<int> times) {
    long long answer = 0;
    
    sort(times.begin(), times.end());
    
    //1'000'000'000
    answer = biSectLeft(1, 	times.back() *n, n, times);
    
    return answer;
}

/*



*/