import java.util.*;
class Solution {
    public String solution(String new_id) {
        return change(new_id);
    }
    
    public String change(String new_id){

        //1단계
        new_id = new_id.toLowerCase();

        //2단계
        new_id = new_id.replaceAll("[^a-z0-9._-]","");

        //3단계
        new_id = new_id.replaceAll("\\.{2,}",".");
       
        //4단계
        new_id = new_id.replaceAll("^\\.|\\.$","");
      
        //5단계
        new_id = new_id.equals("") ? "a" : new_id;
        //6단계
        new_id = new_id.length() >= 16 ? new_id.substring(0,15) : new_id;
        new_id = new_id.replaceAll("^\\.|\\.$","");
        //7단계
        while(new_id.length() < 3){
            String c = Character.toString(new_id.charAt(new_id.length()-1));
            new_id = new_id.concat(c);
        }
        
        return new_id;
        
    }
}
