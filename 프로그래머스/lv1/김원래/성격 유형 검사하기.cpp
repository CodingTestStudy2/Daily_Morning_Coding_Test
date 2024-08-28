#include <string>
#include <vector>

using namespace std;

char ch[8] = {'R','T','C','F','J','M','A','N'};
int res[8];//R,T,C,F,J,M,A,N

void Solve(string survey, int choice)
{
    int frontIdx;
    int rearIdx;
    
    switch(survey[0])
    {
         case 'R' :
        {
            frontIdx = 0;
            rearIdx = 1;
            break;
        }
        case 'T' :
        {
            frontIdx = 1;
            rearIdx = 0;
            break;
        }
        case 'C' :
        {
            frontIdx = 2;
            rearIdx = 3;
            break;
        }
        case 'F':
        {
            frontIdx = 3;
            rearIdx = 2;
            break;
        }
        case 'J' :
        {
            frontIdx = 4;
            rearIdx = 5;
            break;
        }
        case 'M' :
        {
            frontIdx = 5;
            rearIdx = 4;
            break;
        }
        case 'A':
        {
            frontIdx = 6;
            rearIdx = 7;
            break;
        }
        case 'N':
        {
            frontIdx = 7;
            rearIdx = 6;
            break;
        }   
    }
    
    //printf("%d %d\n", frontIdx, rearIdx);
    
    if(choice < 4) res[frontIdx] += 4 - choice;
    else res[rearIdx] += choice - 4;
    
    
}

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    
    for(int cnt = 0 ; cnt < survey.size() ; ++cnt)
    {
        Solve(survey[cnt], choices[cnt]);
    }
    
    /*
    for(int cnt = 0 ; cnt < 8 ; ++cnt)
    {
        printf("%d ", res[cnt]);
    }
    */
    
    for(int cnt = 0 ; cnt < 8 ; cnt += 2)
    {
        if(res[cnt] < res[cnt+1])
        {
            answer += ch[cnt + 1];
        }
        else
        {
            answer += ch[cnt];
        }
    }
    
    return answer;
}