public class Solution
{
    public int SumFourDivisors(int[] nums)
    {
        int sum = 0;
        
        foreach (int num in nums)
        {
            int divisorCount = 0;
            int divisorSum = 0;
            int sqrt = (int)Math.Sqrt(num);

            if (sqrt * sqrt == num)
            {
                continue;
            }

            for (int i = 1; i <= sqrt; i++)
            {
                if (num % i == 0)
                {
                    divisorCount += 2;
                    divisorSum += i;
                    divisorSum += num / i;
                }
            }

            if (divisorCount == 4)
            {
                sum += divisorSum;
            }
        }

        return sum;
    }
}