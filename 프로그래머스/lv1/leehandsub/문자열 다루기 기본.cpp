#include <string>
#include <vector>
#include <stdio.h>
using namespace std;

bool solution(string s) {
    bool answer = true;  
    for(int i=0;i<s.size();i++)
    {
        if(s[i]-'0'<0||s[i]-'0'>9)
        {
            //printf("%d ",s[i]-'0');
            return false;
        }
    }
    if(s.size()==4||s.size()==6)
        return answer;
    else
        return false;
}
