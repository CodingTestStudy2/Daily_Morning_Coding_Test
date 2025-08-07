public class Solution
{
    public int NumberOfGoodSubarraySplits(int[] nums)
    {
        const int modulo = 1_000_000_007;
        int dividePoint = 0;
        bool foundOne = false;

        long result = 1;

        for (int i = 0; i < nums.Length; i++)
        {
            if (nums[i] == 1)
            { 
                foundOne = true;

                result = (result * (dividePoint + 1)) % modulo;
                dividePoint = 0;
            }
            else if (foundOne)
            {
                dividePoint++;
            }
        }

        if (!foundOne)
        {
            return 0;
        }

        return (int)(result % modulo);
    }
}