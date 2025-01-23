#include<vector>
#include<string>

using namespace std;

class OrderedStream {
private:
  vector <string> stream;
  int pointer;
public:
  OrderedStream(int n) {
    stream.resize(n);
    pointer = 0;
  }

  vector<string> insert(int idKey, string value) {
    stream[idKey - 1] = value;
    vector<string> result;
    while (pointer < stream.size() && !stream[pointer].empty())
    {
      result.push_back(stream[pointer]);
      pointer++;
    }
    return result;
  }
};
