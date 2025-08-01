public class Solution
{
    public int NumOfMinutes(int n, int headID, int[] manager, int[] informTime)
    {
        int time = 0;

        Queue<int> queue = new();
        queue.Enqueue(headID);

        int[] timePerNode = new int[n];
        timePerNode[headID] = 0;

        Dictionary<int, List<int> >subordinates = new();

        //한 번 미리 정리하지 않으면 시간 복잡도가 n^2
        for (int i = 0; i < n; i++)
        {
            if (manager[i] == -1)
            {
                continue;
            }

            if (!subordinates.ContainsKey(manager[i]))
            {
                subordinates[manager[i]] = [];
            }
            subordinates[manager[i]].Add(i);
        }

        while (queue.Count > 0)
        {
            int current = queue.Dequeue();
            int currentInformTime = informTime[current];
            
            //리프 노드임을 의미
            if (currentInformTime == 0)
            {
                if (timePerNode[current] > time)
                { 
                    time = timePerNode[current];
                }
                continue;
            }

            foreach (int i in subordinates[current])
            {
                if (manager[i] == current)
                {
                    queue.Enqueue(i);
                    timePerNode[i] = timePerNode[current] + currentInformTime;
                }
            }
        }

        return time;
    }
}