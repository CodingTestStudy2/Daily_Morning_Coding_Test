#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    int now=-1;

    for(int i=0;i<arr.size();i++)
    {
        if(now!=arr[i])
        {
            now=arr[i];
            answer.push_back(now);
        }
        else
            continue;
        
    }
    
    
    return answer;
}
