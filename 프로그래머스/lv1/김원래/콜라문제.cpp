#include <string>
#include <vector>

using namespace std;

int solution(int a, int b, int n) {
    int answer = 0;
    
    while(n >= a)
    {
        answer += b;
        n -= a;
        n += b;
    }
    
    return answer;
}

/*

빈병 a개를 가져다주면 콜라 b병을 준다.
빈병 n개를 가져다주면 총 몇 명의 콜라를 얻을 수 있는가?


*/