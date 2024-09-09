#include string
#include vector
#include algorithm

using namespace std;

int solution(vectorint A, vectorint B) {
    int answer = 0;
    
    sort(A.begin(), A.end());
    sort(B.begin(), B.end());
    
    int point = 0;
    
    for(int cnt = 0 ; cnt  A.size() ; ++cnt)
    {
        if(point == B.size()) break;
        
        while(point != B.size())
        {
            if(A[cnt] = B[point]) ++point;
            else
            {
                ++answer;
                ++point;
                break;
            }
        }
    }
    
    return answer;
}




2N명의 사원들이 N명씩 두 팀으로 나눠 숫자 게임을 한다.

규칙
1. 모든 사원은 무작위로 자연수를 하나씩 부여받는다.
2. 각 사원은 딱 한 번씩 경기를 한다.
3. A,B팀 한 명씩 나와서 서로의 수를 공개한다. 그 때 수가 큰 쪽이 승리한다. 승리한 팀이 승점 1점 획득
4. 숫자가 같다면 누구도 승점을 얻지 못한다.

A의 숫자의 순서 배열이 주어질 때,
B가 얻을 수 있는 최대 승점을 리턴해라.

A와 B를 정렬을 하면, 가장 작은 것을 이기기 위해서 가장 작은 것을 찾기에 용이하다.
그리디 방식으로 풀 수 있다고 생각을 했다.
가장 작은 점수를 이기기 위해서 가장 적당한 점수를 이용하는 것이 승점을 얻는 가장 좋은 방안이다.

