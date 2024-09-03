#include<string>
#include <iostream>
#include <stack>

using namespace std;

stack<int> st;

bool solution(string s)
{
    bool answer = true;

    for(int cnt = 0 ; cnt < s.size() ; ++cnt)
    {
        if(s[cnt] == '(')
        {
            st.push(1);
        }
        else
        {
            if(st.empty())
            {
                answer = false;
                return answer;
            }
            st.pop();
        }
    }
    
    if(!st.empty()) answer = false;
    else answer = true;

    return answer;
}