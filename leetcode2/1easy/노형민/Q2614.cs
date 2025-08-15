public class Solution
{
    public int DiagonalPrime(int[][] nums)
    {
        int maxPrime = 0;

        for (int i = 0; i < nums.Length; i++)
        {
            int diagonalValue1 = nums[i][i];
            int diagonalValue2 = nums[i][nums.Length - 1 - i];

            if (diagonalValue1 > maxPrime && IsPrime(diagonalValue1))
            {
                maxPrime = Math.Max(maxPrime, diagonalValue1);
            }

            if (diagonalValue2 > maxPrime && IsPrime(diagonalValue2))
            {
                maxPrime = Math.Max(maxPrime, diagonalValue2);
            }
        }

        return maxPrime;
    }

    private bool IsPrime(int num)
    {
        int sqrt = (int)Math.Sqrt(num);
        if (num == 1)
        {
            return false;
        }

        for (int i = 2; i <= sqrt; i++)
        {
            if (num % i == 0)
            {
                return false;
            }
        }

        return true;
    }
}