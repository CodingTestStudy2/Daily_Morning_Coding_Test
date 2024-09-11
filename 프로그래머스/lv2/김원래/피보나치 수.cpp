#include <string>
#include <vector>

using namespace std;

int d[100001];

int DFS(int n)
{
    if(d[n] != -1) return d[n];
    
    return d[n] = (DFS(n-1) + DFS(n-2)) % 1234567;
}

int solution(int n) {
    long long answer = 0;
    
    for(int cnt = 0 ; cnt <= n ; ++cnt)
    {
        d[cnt] = -1;   
    }
    
    d[0] = 0;
    d[1] = 1;
    
    
    answer = DFS(n);
    
    return answer;
}

/*

피보나치 수 = F(n)

F(0) = 0;
F(1) = 1; 
F(n) = F(n-1) + F(n - 2);

*/