#include <string>
#include <vector>

using namespace std;

int minRes = 2100000000;
int maxRes = -2100000000;

string solution(string s) {
    string answer = "";
    
    int point = 0;
    
    string curNum;
    
    
    while(point != s.size())
    {
        if(s[point] == ' ')
        {
            int num = stoi(curNum);
            minRes = min(minRes, num);
            maxRes = max(maxRes, num);
            
            curNum = "";
        }
        else
        {
            curNum += s[point];
        }
        
        ++point;
    }
    
    
    int num = stoi(curNum);
    minRes = min(minRes, num);
    maxRes = max(maxRes, num);
    
    answer += to_string(minRes);
    answer += ' ';
    answer += to_string(maxRes);
    
    return answer;
}


/*

공백으로 구분된 숫자들이 주어짐

파싱 후 파싱한 결과를 가지고 minRes, maxRes에 반영함

*/