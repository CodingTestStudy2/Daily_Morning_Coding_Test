#include <iostream>
using namespace std;

int solution(int n)
{
    int ans = 0;

    while(n > 0)
    {
        if((n & 0x1) == 0x1) ++ans;
        n >>= 1;   
    }

    return ans;
}


/*

K칸 앞으로 간다. - 건전지 K만큼 달음
현재까지 온 거리 *2에 해당하는 위치로 이동한다. - 건전시 사용 x

N만큼 거리를 간다고 할 때, 건전지는 최소로 쓰려고 한다.

101
110
111
1000
1001
1의 개수가 정답이 된다 라는 규칙이 있다.

*/