import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        System.out.println(ext);
        List<int[]> list = new ArrayList<>();
        
        
        for(int i=0; i<data.length; i++){
            switch(ext){
                case "date":
                    if(data[i][1]<val_ext) list.add(data[i]);
                    break;
                case "code":
                    if(data[i][0]<val_ext) list.add(data[i]);
                    break;
                case "maximum":
                    if(data[i][2]<val_ext) list.add(data[i]);
                    break;
                case "remain":
                    if(data[i][3]<val_ext) list.add(data[i]);
                    break;
                default:
                    System.out.println("default");
                    break;
            }
        }
        
        answer= new int[list.size()][4];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        switch(sort_by){
            case "date":
                System.out.println("date");
                Arrays.sort(answer, (o1,o2)-> o1[1]-o2[1]);
                break;
            case "code":
                Arrays.sort(answer, (o1,o2)-> o1[0]-o2[0]);
                break;
            case "maximum":
                Arrays.sort(answer, (o1,o2)-> o1[2]-o2[2]);
                break;

            case "remain":
                Arrays.sort(answer, (o1,o2)-> o1[3]-o2[3]);
                break;
            default:
                break;
        }
        
        
        return answer;
    }
}
