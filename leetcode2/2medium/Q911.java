/*
1. 아이디어 :

- 각 시간때마다 vote한 부분을 체크해서 누가 이기고 있는지 topVoteCandidate에 넣어서 보관한다.
- t : time 을 넣었을때 그 시간때를 찾아서 topVoteCandidate에서 바로 값을 반환한다.

2. 시간복잡도 :
O( n  )
3. 자료구조/알고리즘 :
- / n , log n
 */

import java.util.*;

public class Q911 {
    class TopVotedCandidate {
        int numOfPeople;
        int[] topVoteCandidate;
        int[] times;

        public TopVotedCandidate(int[] persons, int[] times) {
            int n = persons.length;

            Map<Integer, Integer> map = new HashMap<>();
            topVoteCandidate = new int[n];
            this.times = times;

            int topPerson = -1;
            int topVotes = 0;

            for(int i = 0; i< n;i++) {
                map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);

                // i = 0
                // persons[0] = 0;
                // topPerson = 0;
                // topVotes = 1;

                // i = 1
                // persons[1] = 1;
                // topPerson = 1;
                // topVotes = 1;

                // i = 2
                // persons[2] = 1;
                // topPerson = 1;
                // topVotes = 2;

                // i = 3
                // persons[3] = 0;
                // topPerson = 0;
                // topVotes = 2;

                // i = 4
                // persons[4] = 0;
                // topPerson = 0;
                // topVotes = 3;

                // i = 5
                // persons[5] = 1;
                // topPerson = 1;
                // topVotes = 3;

                // i = 6
                // persons[6] = 0;
                // topPerson = 0;
                // topVotes = 4;
                if(map.get(persons[i]) >= topVotes) {
                    if(persons[i] != topPerson) {
                        topPerson = persons[i];
                    }
                    topVotes = map.get(persons[i]);
                }
                topVoteCandidate[i] = topPerson;
            }

        }

        public int q(int t) {

            int left = 0;
            int right = times.length-1;


            // 0 5 10 15 20 25 30

            // 3
            // mid = 0 + (6-0) /2 = 3
            // times[3] = 15 > 3
            // right = 2

            // mid = 0 + (2-0) /2 = 1
            // times[1] = 5 > 3
            // right = 0;

            // mid = 0
            // times[0] = 0 <= 3
            // left = 0


            while(left <= right) {
                int mid = left + (right - left) / 2;

                if(times[mid] <= t) {
                    left = mid+1;
                } else {
                    right = mid - 1;
                }
            }

            return topVoteCandidate[right];
        }
    }

}