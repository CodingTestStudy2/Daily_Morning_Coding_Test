#include <unordered_map>

class Solution {
public:
    int numRabbits(vector<int>& answers) {
       unordered_map<int, int> count;
       for (int ans: answers)
       {
            count[ans]++;
       }

       int total = 0;
       for (auto &[x, freq]: count)
       {
            int groupSize = x + 1;
            int groups = std::ceil((double)freq / groupSize);
            total += groups * groupSize;

            std::cout << "raw: " << (double)freq / groupSize << '\n';
            std::cout << "groups: " << groups << '\n';
       }

       return total;
    }
};