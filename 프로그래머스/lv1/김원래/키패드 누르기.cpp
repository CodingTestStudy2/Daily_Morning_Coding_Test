#include <string>
#include <vector>
#include <cmath>

using namespace std;

struct Pos
{
    int y;
    int x;
};


int dy[4] = { -1, 1, 0, 0};
int dx[4] = { 0, 0, -1, 1};

int mainHand; // 1 = left, 2 = right
Pos numberPos[10] = { {3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2} };
Pos leftHandPos = {3, 0};
Pos rightHandPos = {3, 2};

int GetHand(int number)
{
    int retVal;

    int numberPosIdx = number;
    
    int numberY = numberPos[numberPosIdx].y;
    int numberX = numberPos[numberPosIdx].x;
    
    if(number == 1 || number == 4 || number == 7)
        retVal = 1; 
    else if(number == 3 || number == 6 || number == 9)
        retVal = 2;   
    else
    {
        //왼손과 distance 계산
        
        int leftDistance = abs(leftHandPos.y - numberY) + abs(leftHandPos.x - numberX);
        
        int rightDistance = abs(rightHandPos.y - numberY) + abs(rightHandPos.x - numberX);
        
        if(rightDistance < leftDistance)
            retVal = 2;
        else if(leftDistance < rightDistance)
            retVal = 1;
        else
        {
            if(mainHand == 1)
                retVal = 1;
            else
                retVal = 2;
        }
    }
    
    
    if(retVal == 1)
        leftHandPos = numberPos[numberPosIdx];
    else
        rightHandPos = numberPos[numberPosIdx];
    
    return retVal;
}

string solution(vector<int> numbers, string hand) {
    string answer = "";
    
    if(hand == "right") mainHand = 2;
    else mainHand = 1;
    
    for(int cnt = 0 ; cnt < numbers.size() ; cnt++)
    {
        int ret = GetHand(numbers[cnt]);
        
        if(ret == 1) answer += 'L';
        else answer += 'R';
    }
    
    return answer;
}