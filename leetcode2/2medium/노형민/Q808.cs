public class Solution
{
    double?[,] possibility;

    public double SoupServings(int n)
    {
        n = (n+24) / 25;
        
        if (n > 4800)
        {
            return 1.0;
        }

        possibility = new double?[n + 1, n + 1];

        return GetPossibility(n, n);
    }

    private double GetPossibility(int i, int j)
    {
        if (i <= 0 && j <= 0)
        {
            return 0.5;
        }
        if (i <= 0)
        {
            return 1.0;
        }
        if (j <= 0)
        {
            return 0.0;
        }

        if (possibility[i, j] != null)
        { 
            return possibility[i, j].Value;
        }

        double result = 0.25 * (
            GetPossibility(i - 4, j) +
            GetPossibility(i - 3, j - 1) +
            GetPossibility(i - 2, j - 2) +
            GetPossibility(i - 1, j - 3)
        );

        possibility[i, j] = result;

        return result;
    }
}