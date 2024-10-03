#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(string s) {
    int answer = 0;
    
    int n = s.size();
    
    for(int x = 0 ; x < s.size() ; ++x)
    {
        stack<char> st;
        
        int cnt = n;
        
        int pos = x;
        
        bool flag = true;
        
        
        while(cnt--)
        {
            if(s[pos] == '[' || s[pos] == '(' || s[pos] == '{') {
                st.push(s[pos]);
            }
            else {
                if(st.empty()) {
                    flag = false;
                    break;
                }
                
                char top = st.top();
                
                st.pop();
                
                if(top == '[') {
                    if(s[pos] != ']') {
                        flag = false;
                        break;
                    }
                }
                else if(top == '(') {
                    if(s[pos] != ')') {
                        flag = false;
                        break;
                    }
                }
                else {
                    if(s[pos] != '}') {
                        flag = false;
                        break;
                    }
                }
            }
            pos = (pos + 1) % n;
        }
        
        if(!st.empty()) continue;
        
        if(flag == true) ++answer;
    }
    
    return answer;
}

/*


*/