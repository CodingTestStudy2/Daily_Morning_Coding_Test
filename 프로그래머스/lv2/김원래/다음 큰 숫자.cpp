#include <string>
#include <vector>

using namespace std;

int IsPossible(int x, int cnt)
{
    int oneCnt = 0;
    
    while(x > 0)
    {
        int curVal = x & 0x01;
        if(curVal == 1) ++oneCnt;
        
        x = x >> 1;
    }
    
    if(cnt == oneCnt) return true;
    else return false;
}

int solution(int n) {
    int answer = 0;
    
    int oneCnt = 0;
    
    int _n = n;
    
    while(_n > 0)
    {
        int curVal = _n & 0x01;
        if(curVal == 1) ++oneCnt;
        
        _n = _n >> 1;
    }
    
    
    while(1)
    {
        n++;
        if(IsPossible(n, oneCnt))
        {
            return n;    
        }
    }
    
    return answer;
}


/*

n보다 큰 자연수이다.
n을 2진수로 변환 시에 1의 개수가 같다.
n의 다음 큰 숫자는 조건 1,2를 만족하는 가장 작은 수이다.

shift 연산 하면서, 처음 본 1의 위치를 처음 본 0의 위치로 옮겨주면 된다.

*/


// 1001110
// (1)1111