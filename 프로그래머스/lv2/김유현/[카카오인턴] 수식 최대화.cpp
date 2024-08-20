#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <stack>

using namespace std;

vector<char> opers = {'+', '-', '*'};

bool isNumber(char ch) {
    return '0' <= ch && ch <= '9';
}

int carculate(int a, char oper, int b) {
    if (oper == '*') return a*b;
    else if (oper == '+') return a+b;
    else if (oper == '-') return a-b;
    return 0;
}

long long solution(string expression) {
    long long answer = 0;
    
    // 순열로 우선순위 조합 고르기 
    sort(opers.begin(), opers.end());
    
    do {
        // 연산자 우선순위 따라 계산
        for(char oper : opers) {
            
            // 연산자와 숫자 분리
            stack<char> oper_stack; 
            stack<int> number_stack; 
            
            string number = "";
            for(char ch : expression) {
                if (isNumber(ch)) {
                    number += ch;
                } else {
                    number_stack.push(stoi(number));
                    number = "";       
                    oper_stack.push(ch);
                }
            }
            
            if (number.length() > 0) {
                
                number_stack.push(stoi(number));
                // cout << stoi(number) << "\n";
            }
            
            string new_expression = "";
            
            cout << oper << " >>> \n"; 
            // 숫자 스택이 
            while(!number_stack.empty()) {
        
                int a = number_stack.top(); 
                number_stack.pop(); 
                
                if (oper == oper_stack.top()) {
                    
                    if (!number_stack.empty()) {
                        int b = number_stack.top();
                        number_stack.pop(); 
                        int result = carculate(b, oper, a);
                        cout << b << oper << a << "\n";
                    }
                    
                    // new_expression = to_string(result) + new_expression;
                } else {
                    cout << oper_stack.top() << a << "\n";
                    // new_expression = new_expression + oper_stack.top() + to_string(a);
                }
                
                oper_stack.pop();
            }
            
            expression = new_expression;
            cout << new_expression << "\n";
            
        }
        
    } while(next_permutation(opers.begin(), opers.end()));
    
    
    return answer;
}