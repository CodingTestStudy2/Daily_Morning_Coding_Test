import java.util.*;

public class LC_1656 {
    class OrderedStream {
        String[] arr;
        int ptr = 1;
    
        public OrderedStream(int n) {
            arr = new String[n+1];
        }
        
        public List<String> insert(int idKey, String value) {
            List<String> ans = new ArrayList<>();
            arr[idKey] = value;
    
            if(ptr != idKey) return ans;
    
            for(int i=ptr; i<arr.length && arr[i]!= null; i++){
                ans.add(arr[i]);
                ptr++;
            }
            return ans;
        }
    }
    
    /**
     * Your OrderedStream object will be instantiated and called as such:
     * OrderedStream obj = new OrderedStream(n);
     * List<String> param_1 = obj.insert(idKey,value);
     */
    

}