#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    
    int p1 = 1;
    int p2 = 1;
    
    int sum = 0;
    
   while(p1 <= n)
   {
       if(sum < n)
       {
           sum += p2;
           p2++;
       }
       else if(sum > n)
       {
           sum -= p1;
           p1++;
       }
       else
       {
           answer++;
           sum -= p1;
           p1++;
       }
   }
    
    
    return answer;
}


/*
투포인터 문제
더하는 부분에 앞쪽을 p1, 뒤 쪽을 p2로 가리킨다.
이 때, 만약에 p1 ~ p2까지 더한 값이 n보다 크다면 p1을 움직인다.
이게 가능한 이유는 p2를 움직인다면 n이라는 값을 절대로 만들지 못한다.
그렇기에 p1을 움직이는 것이다.


*/