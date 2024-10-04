#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

unordered_map<string, int> map;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    
    vector<int> counts(want.size(), 0);
    
    for(int cnt = 0 ; cnt < want.size() ; ++cnt) {
        map.insert({want[cnt], cnt});
    }    
    
    for(int cnt = 0 ; cnt < discount.size() ; ++cnt) {
        if(cnt >= 10) {
            if(map.find(discount[cnt - 10]) != map.end()) {
                counts[map[discount[cnt - 10]]]--;
            }
        }
        
        if(map.find(discount[cnt]) != map.end()) {
            counts[map[discount[cnt]]]++;
        }
        
        if(cnt < 9) continue;
        
        bool flag = true;
        for(int cnt = 0 ; cnt < counts.size() ; ++cnt) {
            if(counts[cnt] < number[cnt]) {
                flag = false;
                break;
            }
        }
        
        if(flag) ++answer;
        
    }
    
    return answer;
}

/*

10일 동안 회원자격을 부여
회원은 매일 한 가지 제품을 할인함
할인 제품은 하나씩만 구매 가능

할인 받을 수 잇는 회원등록 날짜의 총 일수를 리턴

*/