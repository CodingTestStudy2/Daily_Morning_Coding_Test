#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    map<int, int> m;
    vector<int> arr;
    for(int i=0;i<tangerine.size();i++)
    {
        m[tangerine[i]]++;
    }
    
    for(auto iter = m.begin();iter!=m.end();iter++)
    {
        arr.push_back(iter->second);
    }
    sort(arr.begin(),arr.end(),greater<int>());
    for(int i=0;i<arr.size();i++)
    {
        answer++;
        if(arr[i]>=k)
        {
            break;
        }
        k-=arr[i];
    }
    
    
    return answer;
}
