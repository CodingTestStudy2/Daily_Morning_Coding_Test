#include <string>
#include <vector>

using namespace std;

int dIdx[26];
int dy[4] = { 0, 0, 1, -1 };
int dx[4] = { 1, -1, 0, 0 };

int curY;
int curX;

int parkRow;
int parkCol;

void GetStart(vector<string>& park)
{
    for(int row = 0 ; row < park.size() ; ++row)
    {
        for(int col = 0 ; col < park[row].size() ; ++col)
        {
            if(park[row][col] == 'S')
            {
                curY = row;
                curX = col;
                return;
            }
        }
    }
}

bool isMovable(vector<string>& park, string route)
{
    int dir = dIdx[route[0] - 'A'];
    int moveCnt = stoi(route.substr(2,3));
    
    int nextY = curY;
    int nextX = curX;
    
    while(moveCnt--)
    {
        nextY += dy[dir];
        nextX += dx[dir];
        
        if(nextY < 0 || nextY >= parkRow || nextX < 0 || nextX >= parkCol || park[nextY][nextX] == 'X') return false;
    }
    
    curY = nextY;
    curX = nextX;
    
    return true;
}

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    
    GetStart(park);
    
    dIdx['E' - 'A'] = 0;
    dIdx['W' - 'A'] = 1;
    dIdx['S' - 'A'] = 2;
    dIdx['N' - 'A'] = 3;
    
    parkRow = park.size();
    parkCol = park[0].size();
    
    for(int cnt = 0 ; cnt < routes.size() ; ++cnt)
    {
        isMovable(park, routes[cnt]);
    }
    
    answer.push_back(curY);
    answer.push_back(curX);
    
    return answer;
}

/*

길O 장애물X
명령
동 서 남 북
1. 공원 벗어나면 x
2. 장애물 만나면 x

*/