public class Solution
{
    public int LengthOfLIS(int[] nums)
    {
        int result = 0;
        int[] LISLength = new int[nums.Length];

        for (int i = 0; i < nums.Length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j])
                {
                    LISLength[i] = Math.Max(LISLength[i], LISLength[j] + 1);
                }
            }

            if (LISLength[i] > result)
            {
                result = LISLength[i];
            }
        }

        //자기 자신이 포함되어야 하기에 + 1
        return result + 1;
    }
}