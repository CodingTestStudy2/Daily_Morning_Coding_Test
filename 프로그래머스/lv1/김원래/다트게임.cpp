#include <string>
#include <cmath>

using namespace std;

int solution(string dartResult) {
    int answer = 0;
    
    int dartResultPoint = 0;
    
    int prevScore = 0;
    int curScore = 0;
    int totalScore = 0;
    
    while(dartResultPoint != dartResult.size())
    {
        if(dartResult[dartResultPoint] >= '0' && dartResult[dartResultPoint] <= '9')
        {
            totalScore += curScore;
            prevScore = curScore;
            curScore = 0;
            if(dartResult[dartResultPoint + 1] == '0')
            {
                curScore = stoi(dartResult.substr(dartResultPoint, dartResultPoint+2));
               dartResultPoint++;
            }
            else curScore = stoi(dartResult.substr(dartResultPoint, dartResultPoint+1));
        }
        else if(dartResult[dartResultPoint] == 'S' || dartResult[dartResultPoint] == 'D' || dartResult[dartResultPoint] == 'T')
        {
            if(dartResult[dartResultPoint] == 'D')
            {
                curScore = pow(curScore, 2);
            }
            
            if(dartResult[dartResultPoint] == 'T')
            {
                curScore = pow(curScore, 3);
            }
        }
        else
        {
            if(dartResult[dartResultPoint] == '*')
            {
                totalScore += prevScore;
                curScore *= 2;
            }
            else
            {
                curScore *= -1;
            }
        }
         printf("prev : %d / cur : %d / total %d\n",prevScore, curScore, totalScore);
        dartResultPoint++;
    }
    totalScore += curScore;
    
    answer = totalScore;
    return answer;
}

/*

3번의 기회
0~10점
싱글 더블 트리플, 제곱하여 점수 계산
스타상? 아차상 ?
스타상: 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. * 
아차상 : 당첨시 해당 점수는 마이너스된다. #


*/