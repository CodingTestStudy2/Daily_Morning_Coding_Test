#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    if(cacheSize==0)
        return cities.size()*5;
    
    for(int i=0;i<cities.size();i++)
    {
        for(int j=0;j<cities[i].size();j++)
        {
            cities[i][j]=tolower(cities[i][j]);
        }
    }
    vector<string> cache;
    for(int i=0;i<cities.size();i++)
    {
        auto temp = find(cache.begin(), cache.end(), cities[i]);
        if(temp!=cache.end())
        {
            cache.erase(temp);
            cache.push_back(cities[i]);
            answer+=1;
        }
        else
        {
            if(cache.size()!=cacheSize)
            {
                cache.push_back(cities[i]);
            }
            else
            {
                cache.erase(cache.begin());
                cache.push_back(cities[i]);
            }
            answer+=5;
        }
    }
    
    return answer;
}
