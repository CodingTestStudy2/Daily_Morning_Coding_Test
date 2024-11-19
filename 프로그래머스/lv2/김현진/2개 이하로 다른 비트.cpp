// 규칙 찾아서 비트 계산 하는 문제

#include <string>
#include <vector>

using namespace std;

vector<long long> solution(vector<long long> numbers) {
    vector<long long> answer;
    for(int i=0;i<numbers.size();i++)
    {
        if(numbers[i] %2 ==0)
            answer.push_back(numbers[i] +1);
        else
        {
            long long b = 1;
            while(true)
            {
              //하나씩 왼쪽으로 옮기며 연속된 1찾기
                if((numbers[i] & b) == 0) break; 
                b*=2;
            }
            answer.push_back(numbers[i] + (b/2));
        }
    }
    return answer;
}
