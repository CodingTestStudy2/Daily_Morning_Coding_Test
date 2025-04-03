class Solution {
    public:
        vector<vector<string>> displayTable(vector<vector<string>>& orders) {
            map< int, unordered_map<string, int> >db;
            unordered_map< string, bool> uniqueFood;
            vector<string> topRow;
            vector<vector<string>> output(1);
            
            for (vector<string> order : orders) // 0 for name, 1 for table num, 2 for food
            {
                if (uniqueFood[order[2]] == false)
                {
                    topRow.push_back(order[2]);
                    uniqueFood[order[2]] = true;
                }
                db[std::stoi(order[1])][order[2]]++;
            }
    
            sort(topRow.begin(), topRow.end());
            topRow.insert(topRow.begin(), "Table");
            output[0] = topRow;
    
            for (auto it = db.begin(); it != db.end(); it++)
            {
                vector<string> tmp(1);
                unordered_map<string, int> tableOrder = it->second;
    
                tmp[0] =  std::to_string(it->first);
                for (int j = 1; j < topRow.size(); j++)
                {
                    tmp.push_back(std::to_string(tableOrder[topRow[j]]));
                }
    
                output.push_back(tmp);
                tmp.clear();
            }
    
            return output;
        }
    };