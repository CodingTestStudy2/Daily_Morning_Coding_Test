#include <string>
#include <vector>
#include <iostream>
using namespace std;

int convert(int n)
{
    int cnt=0;
    while(n>0)
    {
        if(n%2==1)
            cnt++;
        n>>=1;
    }
    return cnt;
}

int solution(int n) {
    int answer = 0;
    int ans=convert(n);
    int now=n+1;
    while(1)
    {
        if(ans==convert(now))
        {
            return now;
        }
        now++;
    }
    
    return answer;
}
