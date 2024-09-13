#include <string>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

int HalfBrownSize;
int YellowSize;

int width;
int height;

bool IsPossible(int curR)
{   
    int curC = HalfBrownSize - curR;
 
    if(curC > curR) return false;
    
    int curYellow = (curR - 2) * curC;
    
    //printf("R : %d / C : %d / Yellow : %d\n",curR, curC, curYellow);
    
    if(YellowSize == curYellow)
    {
        width = curR;
        height = curC + 2;
        return true;
    }
    else return false;
}

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    
    HalfBrownSize = brown / 2;
    YellowSize = yellow;
    
    vector<int> nums;
    
    int _halfBrown = HalfBrownSize;
    
    for(int r = HalfBrownSize - 1 ; r >= 1 ; --r)
    {
        if(IsPossible(r)) break;
    }
    
    answer.push_back(width);
    answer.push_back(height);
    
    return answer;
}

/*

brown = 2r + 2c = 2(r + c)
yellow = (r - 2) * c

brown을 소인수 분해해서 배열에서 관리를 하고,
카펫의 가로 길이가 세로길이보다 길거나 같다는 조건만 만족하면서 모든 경우에 대해서 r을 만든다.

*/