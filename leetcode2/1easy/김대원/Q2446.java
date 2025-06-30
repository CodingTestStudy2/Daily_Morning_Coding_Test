class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        String[] sp1 = event1[0].split(":"), ep1 = event1[1].split(":");
        String[] sp2 = event2[0].split(":"), ep2 = event2[1].split(":");;
        int sm1 = Integer.parseInt(sp1[0]) * 60 + Integer.parseInt(sp1[1]);
        int em1 = Integer.parseInt(ep1[0]) * 60 + Integer.parseInt(ep1[1]);
        int sm2 = Integer.parseInt(sp2[0]) * 60 + Integer.parseInt(sp2[1]);
        int em2 = Integer.parseInt(ep2[0]) * 60 + Integer.parseInt(ep2[1]);

        return (sm1 <= sm2 && sm2 <= em1) || (sm2 <= sm1 && sm1 <= em2);
    }
}