class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> bfsQ = new ArrayDeque<>();
        int[] courseOrder = new int[numCourses];
        int[] check = new int[numCourses];
        int index = 0;
        for(int i = 0; i<numCourses; i++){
            if(indegree[i] == 0){
                check[i] = 1;
                bfsQ.add(i);
                courseOrder[index++] = i;
            }
        }
        while(!bfsQ.isEmpty()){
            int now = bfsQ.poll();
            for(int i = 0; i<graph.get(now).size(); i++){
                int next = graph.get(now).get(i);
                if(check[next] != 0)continue;
                indegree[next]--;
                if(indegree[next] == 0){
                    bfsQ.add(next);
                    check[next] = 1;
                    courseOrder[index++] = next;
                }
            }
        }
        if(index != numCourses) return new int[0];
        return courseOrder;
    }
}