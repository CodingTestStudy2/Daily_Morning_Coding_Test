class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String a=String.valueOf(x);
        int b=0;
        for(int i=0;i<a.length();i++){
            b+=Integer.parseInt(a.substring(i,i+1));
        }
        if(x%b==0){
            return true;
        }
        return false;
    }
}
