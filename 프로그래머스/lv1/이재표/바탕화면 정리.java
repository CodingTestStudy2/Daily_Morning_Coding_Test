import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        char[][]paper=new char[wallpaper.length][wallpaper[0].length()];
        int row=wallpaper.length;
        int col=wallpaper[0].length();
        for(int i=0;i<row;i++){
            paper[i]=wallpaper[i].toCharArray();
        }
        int startr=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(paper[i][j]=='#'){
                    startr=i;
                    break;
                }
            }
        }
        int startc=0;
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){
                if(paper[j][i]=='#'){
                    startc=i;
                    break;
                }
            }
        }
        
        int endr=0;
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                if(paper[i][j]=='#'){
                    endr=i;
                    break;
                }
            }
        }
        int endc=0;
        for(int i=col-1;i>=0;i--){
            for(int j=row-1;j>=0;j--){
                if(paper[j][i]=='#'){
                    endc=i;
                    break;
                }
            }
        }
        System.out.println("startr:"+startr+" startc:"+startc+" endr:"+endr+" endc"+endc);
        int[] answer = new int[]{endr, endc, startr + 1, startc + 1};
        return answer;
    }
}
