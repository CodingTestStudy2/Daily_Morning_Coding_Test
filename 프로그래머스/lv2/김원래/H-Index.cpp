#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    
    sort(citations.begin(), citations.end());
    
    int n = citations.size();
    
    int h = 0;
    
    while(h <= citations.back()) {
        
        for(int cnt = 0 ; cnt < citations.size() ; ++cnt) {
            if(h <= citations[cnt]) {
                if(h <= (n-cnt) && h >= cnt) answer = max(answer, h);
            }
        }
        
        h++;
    }
    
    return answer;
}

/*

h인덱스 : n개 중 h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용 됐다면 h의 최댓값이 H-index

ex) 배열 중 값이 h인게 h 이상이어야 한다. 나머지는 h번 이하여야 한다.


*/