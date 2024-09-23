#include <vector>
#include <iostream>
#include <cmath>
using namespace std;

// 세 수가 합이 소수인지 확인하는 함수
bool IsPrimeNumber(int num)
{
    int modNum = 2;
    int sqrtNum = sqrt(num);
    
    while(modNum <= sqrtNum)
    {
        if(num % modNum == 0) return false;
        modNum++;
    }
    
    return true;
}

int solution(vector<int> nums) {
    int answer = 0;
    
    //nums배열을 트래킹 하면서 3개묶음으로 만드는 for문
    for(int i = 0 ; i < nums.size() - 2 ; ++i)
    {
         for(int j = i + 1 ; j < nums.size() - 1 ; ++j)
         {
             for(int k = j + 1 ; k < nums.size() ; ++k)
             {
                 if(IsPrimeNumber(nums[i] + nums[j] + nums[k])) ++answer;
             }
         }
    }
    
    
    return answer;

}