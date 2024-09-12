#include <string>
#include <vector>
#include <list>
#include <algorithm>

using namespace std;

bool compare(vector<int>& a, vector<int>& b)
{
    if(a[0] > b[0]) return false;
    else if(a[0] < b[0]) return true;
    else
    {
        if(a[1] > b[1]) return false;
        else return true;
    }
}

int solution(vector<vector<int>> routes) {
    int answer = 0;
    
    list<vector<int>> _routes;
    
    sort(routes.begin(), routes.end(), compare);
    
    for(int cnt = 0 ; cnt < routes.size() ; ++cnt)
    {
        _routes.push_back(routes[cnt]);
    }
    
    while(!_routes.empty())
    {
        auto beginIter = _routes.begin();
        int p2 = (*beginIter)[1];
        
        _routes.erase(beginIter);
        
        for(auto iter = _routes.begin() ; iter != _routes.end() ; )
        {
            if((*iter)[0] <= p2)
            {
                p2 = min(p2, (*iter)[1]);
                iter = _routes.erase(iter);
            }
            else
                ++iter;
        }
        
        ++answer;
    }

    
    return answer;
}

/*

모든 차량이 고속도를 이용하면서 단속용 카메라를 한 번은 만나도록 카메라를 설치하려고 한다.

-30000 ~ 30000 수직선에 카메라를 둔다. 최대한 적게 두면 몇 개 둘 수 있는가?


*/