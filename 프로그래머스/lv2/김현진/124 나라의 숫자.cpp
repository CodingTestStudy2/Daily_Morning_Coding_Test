//1을 빼는 아이디어.. 정확히 이해가 안돼요..

#include <string>
#include <vector>
#include<algorithm>

using namespace std;

string solution(int n) {
    string answer = "";
    while(n>0)
    {
        if(n%3==0)
        {
            answer += "4";
            n = n/3 -1;
        }
        else if(n%3==1)
        {
            answer += "1";
            n/=3;
        }
        else if(n%3==2)
        {
            answer += "2";
            n/=3;
        }
    }
    reverse(answer.begin(),answer.end());
    return answer;
}
