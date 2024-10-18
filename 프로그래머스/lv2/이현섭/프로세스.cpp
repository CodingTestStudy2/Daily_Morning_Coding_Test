#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <stack>
#include <iostream>

using namespace std;


int solution(vector<int> priorities, int location) {
    int answer = 0;
    queue<pair<int,int>> q;
    vector<int> arr;
    
    for(int i=0;i<priorities.size();i++)
    {
        q.push({priorities[i],i});
        arr.push_back(priorities[i]);
    }
    sort(arr.begin(),arr.end());
    int idx = arr.size()-1;
    int max=arr[idx--];

    
    while(!q.empty())
    {
        int now = q.front().first;
        int now_index = q.front().second;
        
        q.pop();
      
        if(now<max)
        {
            q.push({now,now_index});
        }
        else
        {
            max = arr[idx--];
            answer++;
            if(now_index==location)
                return answer;
        }
    }
    
    return answer;
}
