#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string X, string Y) {
    string answer = "";
    vector<int> num(10,0);
    for(char i : X) num[i-'0']++;
    for(char i : Y) {
        if(num[i-'0'] > 0) answer += i;
        num[i-'0']--;
    }
    sort(answer.begin(), answer.end(), greater<>());
    
    if(answer=="") return "-1";
    else if(answer[0] == '0') return "0";
    
    
    return answer;
}