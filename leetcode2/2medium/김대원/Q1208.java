class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int lt = 0;
        int cost = 0;
        int answer = 0;
        for (int rt = 0; rt < s.length(); rt++) {
            cost += Math.abs(s.charAt(rt) - t.charAt(rt));
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(lt) - t.charAt(lt));
                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }
}

// int answer = 0;
// int[] sPos = new int[2];
// int[] tPos = new int[2];
// int sMax = 0;
// int tMax = 0;
// int[] sPosMax = new int[2];
// int[] tPosMax = new int[2];
// for (int i = 1; i < s.length(); i++) {
//     if (s.charAt(i) - s.charAt(i - 1) == 1) {
//         sPos[1]++;

//         if (sPos[1] - sPos[0] > sMax){
//             sPosMax[0] = sPos[0];
//             sPosMax[1] = sPos[1];
//             sMax = sPos[1] - sPos[0];
//         }
//     } else {
//         sPos[0] = i;
//         sPos[1] = sPos[0];
//     }

//     if (t.charAt(i) - t.charAt(i - 1) == 1) {
//         tPos[1]++;

//         if (tPos[1] - tPos[0] > tMax){
//             tPosMax[0] = tPos[0];
//             tPosMax[1] = tPos[1];
//             tMax = tPos[1] - tPos[0];
//         }
//     } else {
//         tPos[0] = i;
//         tPos[1] = tPos[0];
//     }
// }

// int cost = 0;
// if (sPosMax[1] - sPosMax[0] > tPosMax[1] - tPosMax[0]) {
//     int gap = Math.abs(s.charAt(sPosMax[0]) - t.charAt(tPosMax[0]));
//     int length = 0;
//     while (gap <= maxCost && cost + gap <= maxCost && length <= tPosMax[1]) {
//         cost += gap;
//         length++;
//         answer = length;
//     }
// } else {
//     int gap = Math.abs(s.charAt(sPosMax[0]) - t.charAt(tPosMax[0]));
//     int length = 0;
//     while (gap <= maxCost && cost + gap <= maxCost && length <= sPosMax[1]) {
//         cost += gap;
//         length++;
//         answer = length;
//     }
// }