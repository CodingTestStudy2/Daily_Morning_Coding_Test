#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {
    int answer = health;
    int idx=0;
    int time = bandage[0];
    int plus = bandage[1];
    int bonus = bandage[2];
    int now = 0;//연속성공
    
    
    for(int i=1;i<=attacks[attacks.size()-1][0];i++)
    {
        if(attacks[idx][0]==i)
        {
            now=0;
            answer-=attacks[idx++][1];
            if(answer<=0)
            {
                return -1;
            }
        }
        else
        {
            now++;
            answer+=plus;
            if(now==time)
            {
                answer+=bonus;
                now=0;
            }
            answer = min(answer,health);
        }
    }

    
    return answer;
}
