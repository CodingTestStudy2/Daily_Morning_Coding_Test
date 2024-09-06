#include <string>
#include <vector>

using namespace std;

int zero;

int TransBinary(int input)
{
    int ret = 0;
    
    while(input > 0)
    {
        int rest = input % 2;
        input /= 2;
        
        if(rest == 1)
            ++ret;
        else
            zero++;
    }
    
    return ret;
}

vector<int> solution(string s) {
    vector<int> answer;
    
    int cnt = 0;
    
    for(int i = 0 ; i < s.size() ; ++i)
    {
        if(s[i] == '1') ++cnt;
        else zero++;
    }
    
    int transCnt = 1;
    
    while(cnt != 1)
    {
        transCnt++;
        int res = TransBinary(cnt);
        cnt = res;
    }
    
    
    answer = {transCnt, zero};
    
    return answer;
}


/*



*/