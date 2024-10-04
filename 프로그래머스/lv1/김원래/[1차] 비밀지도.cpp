#include <string>
#include <vector>
#include <list>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    
    for(int row = 0 ; row < arr1.size() ; ++row) {
        int num = arr1[row] | arr2[row];
        
        list<char> li;
        
        int cnt = 0;
        
        while(num > 0) {
            if((num & 1) == 1) li.push_front('#');
            else li.push_front(' ');
        
            num >>= 1;
            cnt++;
        }
        
        int zeroCnt = n - cnt;
        
        while(zeroCnt--) {
            li.push_front(' ');
        }
        
        printf("\n");
        string str;
        
        for(auto iter = li.begin() ; iter != li.end() ; ++iter) {
            str.push_back(*iter);
        }
        
        answer.push_back(str);
    }
    
    return answer;
}

/*

# = 1
' ' = 0



*/