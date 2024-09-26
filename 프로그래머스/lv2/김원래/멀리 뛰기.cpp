#include <string>
#include <vector>

using namespace std;

int dp[2001];

long long solution(int n) {
    long long answer = 0;
    
    dp[1] = 1;
    dp[2] = 2;
    
    for(int pos = 3 ; pos <= n ; ++pos)
    {
        dp[pos] = (dp[pos - 1] + dp[pos - 2]) % 1234567;
    }
    
    answer = dp[n];
    
    return answer;
}


/*

1칸 또는 2칸을 이동한다.

1칸 or 2칸을 이동한다.
어차피 수직선 상이기 때문에, k위치에 오는 방법은 k -1 위치에서 오는 방법과 k - 2 위치에서 오는 방법이 있다.

dp배열은 해당 위치에 오는 방법의 수를 지정함.

dp라기 보다는 누적합의 문제가 아닌가?

*/