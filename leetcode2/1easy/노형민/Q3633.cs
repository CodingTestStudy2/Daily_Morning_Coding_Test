public class Solution
{
    public int EarliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration)
    {
        int minTime = 10000;
        for (int i = 0; i < landStartTime.Length; i++)
        {
            for (int j = 0; j < waterStartTime.Length; j++)
            {
                int currentTime = landStartTime[i] + landDuration[i];
                if (waterStartTime[j] <= currentTime)
                {
                    currentTime += waterDuration[j];
                }
                else
                {
                    currentTime = waterStartTime[j] + waterDuration[j];
                }

                if (currentTime < minTime)
                {
                    minTime = currentTime;
                }
            }
        }

        for (int i = 0; i < waterStartTime.Length; i++)
        {
            for (int j = 0; j < landStartTime.Length; j++)
            {
                int currentTime = waterStartTime[i] + waterDuration[i];
                if (landStartTime[j] <= currentTime)
                {
                    currentTime += landDuration[j];
                }
                else
                {
                    currentTime = landStartTime[j] + landDuration[j];
                }

                if (currentTime < minTime)
                {
                    minTime = currentTime;
                }
            }
        }

        return minTime;
    }
}