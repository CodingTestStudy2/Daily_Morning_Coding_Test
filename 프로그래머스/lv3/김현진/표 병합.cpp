/*
유니온 파인드 알고리즘 사용
unmerge 시 부모를 계속 타고 들어가서 찾기 때문에 시간복잡도가 증가하는 문제
-> merge 할 때 부모 자식들까지 모두 값 갱신해버리기

표를 1차원 배열로 r*c로 바꿔서 생각하면 부모를 정수로 편하게 관리 가능
부모와 데이터 배열 두 개 만들어서 관리

*/
#include <string>
#include <vector>
#include <sstream>
 
using namespace std;
 
int link[2501];
string value[2501];
 
int flatPos(int r, int c) {
    return (r - 1) * 50 + c;
}
 
vector<string> solution(vector<string> commands) {
    vector<string> answer;
 
    //초기화
    for (int i = 1; i <= 2500; i++) {
        link[i] = i;
        value[i] = "EMPTY";
    }
 
    //해법
    for (string &command : commands) {
        vector<string> v;
        stringstream ss(command);
        string token;
        while (ss >> token) v.push_back(token);
 
        if (v[0] == "UPDATE") {
            if (v.size() == 4) { //1. UPDATE r c value
                int pos = flatPos(stoi(v[1]), stoi(v[2]));
                string val = v[3];
                int parent = link[pos];
                value[parent] = val;
            }
            else { //2. UPDATE value1 value2
                string val1 = v[1], val2 = v[2];
                for (int i = 1; i <= 2500; i++) {
                    if (value[i] == val1) value[i] = val2;
                }
            }
        }
        else if (v[0] == "MERGE") { //3. MERGE r1 c1 r2 c2
            int pos1 = flatPos(stoi(v[1]), stoi(v[2])), pos2 = flatPos(stoi(v[3]), stoi(v[4]));
            int parent1 = link[pos1], parent2 = link[pos2];
            if (parent1 != parent2) {
                for (int i = 1; i <= 2500; i++) {
                    if (link[i] == parent2) link[i] = parent1;
                }
                string val1 = value[parent1], val2 = value[parent2];
                if (val1 == "EMPTY" && val2 != "EMPTY") {
                    value[parent1] = value[parent2];
                }
                else {
                    value[parent2] = value[parent1];
                }
            }
        }
        else if (v[0] == "UNMERGE") { //4. UNMERGE r c
            int pos = flatPos(stoi(v[1]), stoi(v[2]));
            int parent = link[pos];
            string val = value[parent];
            for (int i = 1; i <= 2500; i++) {
                if (link[i] == parent) {
                    link[i] = i;
                    value[i] = "EMPTY";
                }
            }
            value[pos] = val;
        }
        else { //5. PRINT r c
            int pos = flatPos(stoi(v[1]), stoi(v[2]));
            int parent = link[pos];
            answer.push_back(value[parent]);
        }
    }
 
    return answer;
}
 
