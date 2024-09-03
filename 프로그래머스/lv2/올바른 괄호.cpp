#include<string>
#include <iostream>
#include <stack>
using namespace std;

bool solution(string s)
{
    stack<int> st;
    
    for( char c : s ) {
        if(c=='(') {
            st.push(1);
        }
        if(c==')') {
            if(st.empty()) {
                return false;  //단순히 갯수만 맞는게 아니라 )가 먼저 오는 경우가 있으면 안됨
            }
            else {
                 st.pop();
            }
        
        }
    }
    if(st.empty()) {
        return true;
    }
    else {
        return false;
    }

}
