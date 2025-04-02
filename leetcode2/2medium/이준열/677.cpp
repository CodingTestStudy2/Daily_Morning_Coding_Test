class MapSum {
    public:
        unordered_map<string, int> strMap;
        vector<string> keyVec;
    
        MapSum() {
        }
        
        void insert(string key, int val) {
                if(strMap[key] == 0)
                    keyVec.push_back(key);
                strMap[key] = val;
        
        }
        
        bool isPrefix(string target, string prefix)
        {
            if (target.size() < prefix.size())
                return false;
    
            for (int i = 0; i < prefix.size(); i++)
            {
                if (target[i] != prefix[i])
                    return false;
            }
            return true;
        }
    
        int sum(string prefix) {
            int output = 0;
            for (string key: keyVec)
            {
                if (isPrefix(key, prefix))
                {
                    output += strMap[key];
                }
            }
            return output;
        }
    
    };
    
    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum* obj = new MapSum();
     * obj->insert(key,val);
     * int param_2 = obj->sum(prefix);
     */