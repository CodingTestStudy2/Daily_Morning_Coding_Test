#include <string>
#include <vector>

using namespace std;

#define MONTH_DAY 28

int termsArr[26];

void dateToDay(int* outDay, string& date)
{
    int year = stoi(date.substr(0, 4));
    int month = stoi(date.substr(5,7));
    int day = stoi(date.substr(8, 10));
    
    //printf("year : %d / month : %d / day : %d\n", year, month, day);
    
    year -= 2000;
    
    *outDay = (year * 12 * MONTH_DAY);
    *outDay += (month * MONTH_DAY);
    *outDay += day;
}
vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    
    for(int cnt = 0 ; cnt < terms.size() ; ++cnt)
    {
        char kind = terms[cnt][0];
        string term = terms[cnt].substr(2, terms.size());
        termsArr[kind - 'A'] = stoi(term);
    }
    
    int todayToDay;
    dateToDay(&todayToDay, today);
    
    //printf("today : %d\n", todayToDay);
    
    for(int cnt = 0 ; cnt < privacies.size() ; ++cnt)
    {
        int startDay;
        dateToDay(&startDay, privacies[cnt]);
        
        int termIdx = privacies[cnt][11] - 'A';
        int endDay = startDay + termsArr[termIdx] * MONTH_DAY;

        if(todayToDay >= endDay) answer.push_back(cnt + 1);
        
        //printf("endDay : %d\n", endDay);
    }
    
    return answer;
}


/*
개인정보 n개 - 약관이 각각 다름 / 유효기간이 정해져있음
유효기간 전까지 보관, 지나면 파기
ex) A약관 유효기간 12달, 2021년 1월 5일에 수집이 됐다면 2022년 1월 5일에 무조건 파기

모든 달은 28일까지 있음

*/