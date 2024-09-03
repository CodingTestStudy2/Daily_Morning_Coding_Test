#include <string>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

string solution(string s) {
    string answer = "";
    bool isMinus = false;
    int minResult = 999999;
    int maxResult = -999999;
    string temp = "";
    
    for(int i=0; i<s.length(); i++){ 
        cout<<s[i]<<"\n";
        if(s[i]==' '){
            int num = stoi(temp);
            minResult = min(minResult, num);
            maxResult = max(maxResult, num);
            temp = ""; //초기화
            
        }else if(i == s.length()-1){
            temp += s[i];
            int num = stoi(temp);
            minResult = min(minResult, num);
            maxResult = max(maxResult, num);
            
        }else{
            temp += s[i];
        }
        
    }
    
    answer = to_string(minResult)+ " " + to_string(maxResult);
    return answer;
}
