#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

unordered_map<long long, long long> uMap;

long long Find(long long num)
{
    if(uMap.find(num) == uMap.end())
    {
        long long nextNum = num + 1;
        while(uMap.find(nextNum) != uMap.end())
        {
            nextNum = uMap[nextNum];
        }
        
        uMap.insert({num, nextNum});
    }
    else
    {
        uMap[num] = Find(uMap[num]);
    }
    
    return uMap
}

vector<long long> solution(long long k, vector<long long> room_number) {
    vector<long long> answer;
    
    for(int cnt = 0 ; cnt < room_number.size() ; ++cnt)
    {
        long long selectRoom = room_number[cnt];
        if(uMap.find(selectRoom) == uMap.end())
        {
            uMap.insert({selectRoom, selectRoom + 1});   
        }
        else
        {
            long long nearRoom = uMap[selectRoom];
            while(uMap.find(nearRoom) != uMap.end())
            {
                nearRoom = uMap[nearRoom];
                uMap[nearRoom]
            }
        }
    }
    
    
    return answer;
}

/*
호텔의 방은 k개 있고, 고객들에게 방을 배정하는 상황이다.
처음에 모든 방은 비어있다.
규칙에 맞춰 방을 배정한다.
1. 신청한 순서대로 방을 배정한다.
2. 고객은 원하는 방 번호를 제출
3. 고객이 원하는 방이 있다면 즉시 배정
4. 배정불가 시 원하는 방보다 번호가 크면서 비어있는 방 중 가장 번호가 작은 방을 배정

k가 너무 크기 때문에
우리는 빈방을 찾는 것이 아니라 사람이 배정 된 방을 관리해야 한다.

가장 먼저 생각나는 방법은
원하는 방을 파라미터로 넣었을 때,
이 방이 사람이 배정된 방인지 확인을 한다.
그리고 배정된 방이라면 방의 값을 하나씩 증가시키면서
이방이 사람이 배정된 방인지를 확인한다.

이렇게 되면, 20만명이 주루루룩 배정이 된다 했을 때 20만 * 20만 정도의 시간이 걸릴 것이다.

그렇다면 데이터를 하나 더 쓴다?
k개가 주루룩 있다고 했을 때 그 중 하나를 배정을 한다하면 두 뭉치로 잘라질 것이다.
0시작점과 하나를 배정한 그 앞으로
이제 방을 배정 할 때, 배정한 방이 있다라면
이 데이터구조에서 찾는다.
현재 배정하려는 방 보다 크면서 가장 작은 것을 찾는다.

union-find를 쓰면 되지 않을까?
선택한 방이 빈 방이었을 때,
그 빈 방을 선택하고 다시 그 빈방을 선택하게 되면 다음 방을 선택 할 수 있도록 값으로 선택한 방 + 1을 한다.

*/