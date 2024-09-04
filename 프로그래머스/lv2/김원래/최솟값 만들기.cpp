#include <iostream>
#include<vector>
#include<algorithm>
using namespace std;

int solution(vector<int> A, vector<int> B)
{
    int answer = 0;

    sort(A.begin(), A.end());
    sort(B.begin(), B.end());
    
    int p1 = 0;
    int p2 = B.size() - 1;
    
    while(p1 < A.size())
    {
        answer += A[p1] * B[p2];
        p1++;
        p2--;
    }

    return answer;
}

/*

길이가 같은 두 배열 A,B가 주어집니다.
두 배열에서 한 개의 숫자를 뽑아서 두 수를 곱합니다.
이러한 과정을 배열의 길이만큼 반복합니다.
두 수를 곱한 값을 누적하여 더합니다.
누적된 값이 최소가 되도록 하는 것이 목표입니다.


*/