#include <iostream>
#include <vector>
using namespace std;

int solution(int n, vector<int> stations, int w)
{
    int answer = 0;
    int k=1;
    int now=0;
    int i=0,j=1;
    int find=2*w+1;
    while(j<=n)
    {
        if(stations[i]-w<=j&&i<stations.size())
        {
            j=stations[i]+w+1;
            i++;
            continue;
        }
        j+=find;
        answer++;
    }
    return answer;
}
