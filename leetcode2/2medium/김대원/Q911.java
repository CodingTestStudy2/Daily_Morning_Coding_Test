class TopVotedCandidate {

    int maxVotes = 0;
    private int[] persons;
    private int[] times;
    private Map<Integer, Integer> score = new HashMap<>();
    private Map<Integer, Integer> result = new HashMap<>();
    private TreeMap<Integer, Integer> timeIdx = new TreeMap<>();

    public TopVotedCandidate(int[] persons, int[] times) {
        int n = times.length;
        this.persons = persons;
        this.times = times;

        for (int i = 0; i < n; i++) {
            timeIdx.put(times[i], i);
        }

        for (int i = 0; i < n; i++) {
            int person = persons[i];
            score.put(person, score.getOrDefault(person, 0) + 1);

            if (score.get(person) >= maxVotes) {
                maxVotes = score.get(person);
                result.put(i, person);
            } else {
                result.put(i, result.get(i - 1));
            }
        }
    }

    public int q(int t) {
        int key = timeIdx.floorKey(t);
        return result.get(timeIdx.get(key));
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */

// person: [0,1,1,0,0,1,0]
// time: [0,5,10,15,20,25,30]

// query: "q","q","q","q","q","q"
// [3],[12],[25],[15],[24],[8]
// q(3): 0
// q(12): 1
// q(25): 1
// q(15): 0
// q(24): 0
// q(8): 1