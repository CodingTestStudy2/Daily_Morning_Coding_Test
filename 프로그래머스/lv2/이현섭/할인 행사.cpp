#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    int total = 10;
    int i=0,j=0;
    map<string,int> m;
    for(int i=0;i<want.size();i++)
    {
        m.insert({want[i],number[i]});
    }
    
    while(j<discount.size())
    {
        if(j-i!=9)
        {
            if(m.count(discount[j])==1)
                m[discount[j]]--;
            j++;
        }
        else
        {
            if(m.count(discount[j])==1)
                m[discount[j]]--;
            int flag=0;
            for(auto iter=m.begin();iter!=m.end();iter++)
            {
                if(iter->second>0)
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                answer++;
            if(m.count(discount[i])==1)
                m[discount[i]]++;
            i++;
            j++;
            
        }
    }
    return answer;
}
