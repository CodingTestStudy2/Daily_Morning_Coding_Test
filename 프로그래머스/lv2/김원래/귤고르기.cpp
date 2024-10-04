#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> counts(10000001, 0);

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    
    for(int cnt = 0 ; cnt < tangerine.size() ; ++cnt)
    {
        counts[tangerine[cnt]]++;
    }
    
    sort(counts.begin(), counts.end(), greater<int>());
    
    int curK = 0;

    
    for(int cnt = 0 ; cnt < 10000001; ++cnt)
    {
        answer++;
        if(curK + counts[cnt] >= k) break;
        else curK += counts[cnt];
    }
    
    return answer;
}

/*



*/