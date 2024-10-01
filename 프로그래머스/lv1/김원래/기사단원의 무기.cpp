#include <string>
#include <vector>

using namespace std;

int numberOfDivision[100001];

int solution(int number, int limit, int power) {
    int answer = 0;
    
    //number 전체를 도는 반복문
    for(int num = 1; num <= number ; ++num)
    {

        //num의 약수를 세는 반목문
        for(int modNum = 1 ; modNum * modNum <= num ; ++modNum)
        {
            if(num % modNum == 0)
            {
                if(modNum * modNum == num)
                {
                    numberOfDivision[num]++;
                }
                else
                {
                    numberOfDivision[num] += 2;
                }
            }
        }
    }

    
    for(int num = 1 ; num <= number ; ++num)
    {
        //printf("%d, ",numberOfDivision[num]);
        
        if(numberOfDivision[num] > limit) answer += power;
        else answer += numberOfDivision[num];
    }
    
    
    return answer;
}