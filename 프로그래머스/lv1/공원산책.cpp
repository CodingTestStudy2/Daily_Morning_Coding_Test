#include <string>
#include <vector>
using namespace std;

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    int startX, startY;
    
    // 시작점 찾기
    for(int i = 0; i < park.size(); i++) {
        for(int j = 0; j < park[0].size(); j++) {
            if(park[i][j] == 'S') { // 시작점
                startX = i;
                startY = j;
                break;
            }
        }
    }
    
    // 명령어 처리
    for(int i = 0; i < routes.size(); i++) {
        char direction = routes[i][0];
        int len = routes[i][2] - '0';
        bool stop = false;
        
        if(direction == 'E') {
            if(startY + len < park[0].size()) {
                for(int j = 1; j <= len; j++) {
                    if(park[startX][startY + j] == 'X') {
                        stop = true;
                        break;
                    }
                }
                if(!stop) startY += len;
            }
        } else if(direction == 'W') {
            if(startY - len >= 0) {
                for(int j = 1; j <= len; j++) {
                    if(park[startX][startY - j] == 'X') {
                        stop = true;
                        break;
                    }
                }
                if(!stop) startY -= len;
            }
        } else if(direction == 'S') {
            if(startX + len < park.size()) {
                for(int j = 1; j <= len; j++) {
                    if(park[startX + j][startY] == 'X') {
                        stop = true;
                        break;
                    }
                }
                if(!stop) startX += len;
            }
        } else if(direction == 'N') {
            if(startX - len >= 0) {
                for(int j = 1; j <= len; j++) {
                    if(park[startX - j][startY] == 'X') {
                        stop = true;
                        break;
                    }
                }
                if(!stop) startX -= len;
            }
        }
    }
    
    answer.push_back(startX);
    answer.push_back(startY);
    return answer;
}
