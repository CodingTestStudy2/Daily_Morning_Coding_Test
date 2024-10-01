#include <string>
#include <vector>
#include <algorithm>
// 12233455

// 서로 다른 종류를 최소화 => 최빈값 체크 
using namespace std;

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    
    int m = *max_element(tangerine.begin(), tangerine.end());
    vector<int> size(m+1,0);

    for(int i=0; i<tangerine.size(); i++) {
        size[tangerine[i]]++;
    }
    
    sort(size.begin(), size.end(), greater<int>());
    
    int idx=0;
    while(k>=1) {
        k -=size[idx];
        answer++;
        idx++;
    }
    
    return answer;
}
