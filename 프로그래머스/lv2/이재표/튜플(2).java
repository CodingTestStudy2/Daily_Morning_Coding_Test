import java.util.*;
class Solution {
    public int[] solution(String s) {
        s=s.substring(1,s.length()-1);
        String[]split=s.split(",");
        List<String>list=new ArrayList<>();
        int start=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{'){
                start=i;
            }else if(s.charAt(i)=='}'){
                list.add(s.substring(start+1,i));
            }
        }
        int[] answer=new int[list.size()];
        int idx=0;
        HashMap<String,Boolean>map=new HashMap<>();
        Collections.sort(list,new Comparator<String>(){
            @Override
            public int compare(String o1,String o2){
                return o1.length()-o2.length();
            }
        });
        for(int i=0;i<list.size();i++){
            String current=list.get(i);
            String[] tuple=current.split(",");
            for(int j=0;j<tuple.length;j++){
                if(!map.getOrDefault(tuple[j],false)){
                    map.put(tuple[j],true);
                    answer[idx++]=Integer.parseInt(tuple[j]);
                }
            }
        }
        return answer;
    }
}
