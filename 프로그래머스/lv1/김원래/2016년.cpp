#include <string>
#include <vector>

using namespace std;

int numberOfDays[12] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
vector<string> Week = {"THU","FRI","SAT", "SUN","MON","TUE","WED"};

string solution(int a, int b) {
    string answer = "";
    
    int totalOfDays = 0;
    
    for(int month = 0; month < a-1 ; ++month)
    {
        totalOfDays += numberOfDays[month];
    }
    
    totalOfDays += b;
    
    
    answer = Week[totalOfDays % 7];
    
    return answer;
}

/*

a/b 는 무슨 요일일까요?

매 월 30, 31, 29 세 개로 일 수가 다르다.

*/