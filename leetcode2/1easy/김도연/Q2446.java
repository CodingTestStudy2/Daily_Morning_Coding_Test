package Leetcode.김도연;

class Q2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        int h0, h1, h2, h3, m0, m1, m2, m3;

        String[] parts0 = event1[0].split(":");
        h0 = Integer.parseInt(parts0[0]); // 14
        m0 = Integer.parseInt(parts0[1]); // 13

        String[] parts1 = event1[1].split(":");
        h1 = Integer.parseInt(parts1[0]); // 22
        m1 = Integer.parseInt(parts1[1]); // 08

        String[] parts2 = event2[0].split(":");
        h2 = Integer.parseInt(parts2[0]); // 02
        m2 = Integer.parseInt(parts2[1]); // 40

        String[] parts3 = event2[1].split(":");
        h3 = Integer.parseInt(parts3[0]); //08
        m3 = Integer.parseInt(parts3[1]); //08

        if (h1 < h2 || (h1 == h2 && m1 < m2))
            return false;
        if (h3 < h0 || (h3 == h0 && m3 < m0))
            return false;

        return true;
    }
}