#include <string>
#include <sstream>
#include <cctype>
#include <iostream>
using namespace std;

string solution(string s) {
    string answer = "";
    bool word = false; 

    string str = "3efg";
    for (int i = 0; i < s.length(); i++) {
        if (s[i] == ' ') {
            answer += " ";
            word = false; 
        } else {
            if (!word) {
                answer += toupper(s[i]);
                word = true; 
            } else {
                answer += tolower(s[i]);
            }
        }
    }
    
    return answer;
}
