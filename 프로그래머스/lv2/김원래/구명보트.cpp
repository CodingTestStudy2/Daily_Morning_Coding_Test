#include <string>
#include <vector>
#include <algorithm>
#include <list>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    
    int begin = 0;
    int last = people.size() - 1;
    
    sort(people.begin(), people.end());
    
    while(begin <= last)
    {
        if(limit - people[last] >= people[begin])
        {
            begin++;
            last--;
        }
        else last--;
        
        ++answer;
    }
    
    
    return answer;
}

/*

구명보트는 2명 탈 수 있다.
구명보트는 무게 제한이 있다.

구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 한다.

1 2 4 5

3

*/