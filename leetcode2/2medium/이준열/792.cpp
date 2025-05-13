class Solution {
    public:
        int numMatchingSubseq(string s, vector<string>& words) {
            unordered_map<char, queue< pair<int, int> > > curIndexMap;
            // char: curLocation, pair<int, int>: word index, word char index
            int output = 0;
    
            //INIT
            for (int j = 0; j < words.size(); j++)
            {
                curIndexMap[words[j][0]].push(make_pair(j, 0));
            }
    
    
            for (char c: s)
            {
                for (auto it  = curIndexMap.begin(); it != curIndexMap.end(); it++)
                {
                    if (it->first == c)
                    {
                        queue< pair<int, int> >&set = it->second;
                        int cnt = set.size();
    
                        while (cnt--)
                        {
                            int wordIndex = set.front().first;
                            int wordCharIndex = set.front().second + 1;
                            it->second.pop();
    
                            if (wordCharIndex >= words[wordIndex].size())
                            {
                                output++;
                                continue;
                            }
                            curIndexMap[ words[wordIndex][wordCharIndex] ].push(make_pair(wordIndex, wordCharIndex));
                        }
                    }
                }
            }
    
            return output;
        }
    };