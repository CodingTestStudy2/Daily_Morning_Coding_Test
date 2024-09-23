#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;


bool compare(pair<int,int>& a, pair<int,int>& b)
{
    if(a.second == b.second)
        return a.first < b.first;
    return a.second > b.second;
}


//genre별 인덱스
int NextIdx = 0;
unordered_map<string, int> GenresIdx;

//{고유 번호, plays}[2]를 value로 // value에는 plays가 높은 값이 들어간다. //
// 한개의 데이터만 추가가 된 경우도 있을 것이기 때문에, map에 처음 추가 될 때 배열 2번쨰 항목을 -1로 초기화 한다.
vector<vector<pair<int, int>>> maxPlays;

//Genre별 수록된 곡 수
vector<pair<int,int>> numOfGenres;

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    
    for(int cnt = 0 ; cnt < genres.size() ; ++cnt)
    {
        int idx;
        if(GenresIdx.find(genres[cnt]) != GenresIdx.end()) idx = GenresIdx[genres[cnt]];
        else {
            GenresIdx.insert({genres[cnt], NextIdx++});
            idx = NextIdx - 1;
            
            maxPlays.push_back(vector<pair<int,int>>());
            numOfGenres.push_back({idx, 0});
        }

        maxPlays[idx].push_back({cnt, plays[cnt]});
        numOfGenres[idx].second += plays[cnt];
    }
    
    for(int cnt = 0 ; cnt < NextIdx ; ++cnt)
        sort(maxPlays[cnt].begin(), maxPlays[cnt].end(), compare);
    
    sort(numOfGenres.begin(), numOfGenres.end(), compare);

    for(int i = 0 ; i < numOfGenres.size() ; ++i)
    {
        int idx = numOfGenres[i].first;
        
        int size;
        if(maxPlays[idx].size() >= 2) size = 2;
        else size = 1;
        
        for(int j = 0 ; j < size ; ++j)
            answer.push_back(maxPlays[idx][j].first);
    }
    
    return answer;
}


/*

장르 별 가장 많이 재생된 노래 두 개씩을 모은다.
그리고 그거를 하나의 앨범으로 낸다.

1. 속한 노래가 많이 재생된 장르를 먼저 수록한다.
2. 장르 내에서 많이 재생된 노래를 먼저 수록한다.
3. 장르 내에서 재생 횟수가 같다면, 고유 번호가 낮은게 먼저 수록


*/