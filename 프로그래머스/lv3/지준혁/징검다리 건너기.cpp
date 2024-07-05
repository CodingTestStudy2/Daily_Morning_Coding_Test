#include <string>
#include <vector>
#include <iostream>

using namespace std;

// 못품
bool cross_stones(vector<int>& stones, int k) {
    int cur_stone = 0;
    int nxt_stone = 0;
    int ans = 0;
    while (true) {
        if (cur_stone == stones.size()) 
            return false;
        nxt_stone = cur_stone + 1;
        while (stones[nxt_stone] == 0) {
            ++nxt_stone;
            if (nxt_stone == stones.size()) {
                break;
        }
        if (nxt_stone - cur_stone > k) return false;
        cur_stone = nxt_stone;
        ++ans;
        if (ans == 20)
            return false;
    }
}

int solution(vector<int> stones, int k) {
    vector<int> s(stones);
    s.push_back(0);
    
    int ans = 0;
    while (true) {
        if (!cross_stones(s, k)) {
            break;
        }
        ++ans;
    }
    return ans;
}
