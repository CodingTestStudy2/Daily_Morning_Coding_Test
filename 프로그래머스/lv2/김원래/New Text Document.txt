#include <iostream>
#include<string>
#include<stack>
using namespace std;

int solution(string s)
{
    int answer = -1;

    stack<char> st;
    
    for(int cnt = 0 ; cnt < s.size() ; ++cnt)
    {
        if(st.empty()) st.push(s[cnt]);
        else
        {
            char _top = st.top();
            if(s[cnt] == _top) st.pop();
            else st.push(s[cnt]);
        }
    }
    
    if(st.empty()) answer = 1;
    else answer = 0;

    return answer;
}

/*

알파벳 소문자로 이루어진 문자열이 입력으로 주어진다. = s

1. 같은 알파벳 두 개가 붙어있는 거를 제거한다.
2. 그리고 이어 붙인다.

위의 1,2 과정을 반복해서 문자열 s가 온전히 삭제되면 1, 아니면 0을 리턴.

스택 자료구조를 이용하면 되지 않을까?

*/