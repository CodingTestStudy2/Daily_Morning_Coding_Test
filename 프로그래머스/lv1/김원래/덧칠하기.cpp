#include <string>
#include <vector>

using namespace std;

int solution(int n, int m, vector<int> section) {
    int answer = 0;
    
    
    
    int sectionIdx = 0;
    
    
    while(sectionIdx < section.size())
    {
        ++answer;
        int start = section[sectionIdx];
        int end = start + m;
        
        for(int pos = start ; pos < end ; ++pos)
        {
            if(pos == section[sectionIdx]) ++sectionIdx;
        }
    }
    
    
    
    return answer;
}


/*

길이가 n미터인 벽이 있따.

벽을 1미터 길이의 구역 n개로 나눈다.

롤러의 길이는 m미터
1. 롤러가 벽에서 벗어나면 안된다.
2. 구역의 일부분만 포함되도록 칠하면 안된다.

페인트 칠을 최소화 하려고 한다.


*/