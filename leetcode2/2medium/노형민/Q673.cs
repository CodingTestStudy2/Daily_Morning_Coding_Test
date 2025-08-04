public class Solution
{
    public int FindNumberOfLIS(int[] nums)
    {
        int maxLength = 0;

        //n번째 원소가 마지막인 LIS의 길이
        int[] LISLength = new int[nums.Length];
        //n번째 원소가 마지막인 LIS의 개수
        int[] LISCount = new int[nums.Length];
        int result = 0;

        for (int i = 0; i < nums.Length; i++)
        {
            LISCount[i] = 1;
            LISLength[i] = 1;

            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j])
                {
                    if (LISLength[i] < LISLength[j] + 1)
                    {
                        LISLength[i] = LISLength[j] + 1;
                        LISCount[i] = LISCount[j];
                    }
                    else if (LISLength[i] == LISLength[j] + 1)
                    {
                        LISCount[i] += LISCount[j];
                    }
                }
            }

            if (LISLength[i] > maxLength)
            {
                maxLength = LISLength[i];
                result = LISCount[i];
            }
            else if (LISLength[i] == maxLength)
            {
                result += LISCount[i];
            }
        }

        return result;
    }
}