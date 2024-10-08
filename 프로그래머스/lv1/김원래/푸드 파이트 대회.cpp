#include <string>
#include <vector>
#include <stack>

using namespace std;

string solution(vector<int> food) {
    string answer = "";
    
    stack<int> st;
    
    for(int cnt = 1 ; cnt < food.size() ; ++cnt) {
        int curFood = food[cnt]/2;
        
        while(curFood--) {
            st.push(cnt);
            answer += to_string(cnt);
        }

    }
    
    answer += '0';
    
    while(!st.empty()) {
        answer += to_string(st.top());
        st.pop();
    }

    return answer;
}

/*

*/