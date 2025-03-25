class Solution {
    public:
    
       int leapYear[13] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
        int leapYearSum[13] = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366};
    
        int normYear[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
        int normYearSum[13] = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
    
        int dayOfYear(string date) {
            vector<int> dateSplit;
            std::stringstream ss(date);
            std::string tmp;
            int tmpInt;
    
            while (std::getline(ss, tmp, '-'))
            {
                tmpInt = std::stoi(tmp);
                dateSplit.push_back(tmpInt);
            }
    
            if ( ((dateSplit[0] % 4 == 0) && (dateSplit[0] % 100 != 0))
                || ((dateSplit[0] % 4 == 0) && (dateSplit[0] % 100 == 0) &&
                    (dateSplit[0] % 400 == 0)) ) // leap year
            {
                return leapYearSum[dateSplit[1]] - ( leapYear[dateSplit[1]] - dateSplit[2] );
            }
            else
            {
                return normYearSum[dateSplit[1]] - ( normYear[dateSplit[1]] - dateSplit[2] );
            }
        }
    };