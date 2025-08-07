public class Solution
{
    public int[] GetNoZeroIntegers(int n)
    {
        int[] result = new int[2];

        for (int i = 1; i < n; i++)
        {
            if (!ContainsZero(i) && !ContainsZero(n - i))
            {
                result[0] = i;
                result[1] = n - i;
                break;
            }
        }

        return result;
    }

    private bool ContainsZero(int number)
    {
        while (number > 0)
        {
            if (number % 10 == 0)
            {
                return true;
            }
            number /= 10;
        }

        return false;
    }
}