#include <string>
#include <cmath>
#include <vector>
using namespace std;

int solution(string dartResult) {
    int answer = 0;
    vector<int> temp;
    int now=0;
    
    for(int i=0;i<dartResult.size();i++)
    {
        if(dartResult[i]>='0'&&dartResult[i]<='9')
        {
            if(i+1<=dartResult.size()&&dartResult[i+1]=='0')
            {
                i++;
                now=10;
            }
            else
            {
                now=dartResult[i]-'0';
            }
        }
        else
        {
            if(dartResult[i]=='S')
            {
                now=pow(now,1);
                temp.push_back(now);
            }
            else if(dartResult[i]=='D')
            {
                now=pow(now,2);
                temp.push_back(now);
            }
            else if(dartResult[i]=='T')
            {
                now=pow(now,3);
                temp.push_back(now);
            }
            else if(dartResult[i]=='*')
            {
                temp[temp.size()-1]*=2;
                if(temp.size()>=2)
                {
                    temp[temp.size()-2]*=2;
                }
            }
            else if(dartResult[i]=='#')
            {
                temp[temp.size()-1]*=-1;
            }
        }
    }
    for(int i=0;i<temp.size();i++)
    {
        answer+=temp[i];
    }
    
    return answer;
}
