public class Solution
{
    public int NumOfUnplacedFruits(int[] fruits, int[] baskets)
    {
        for (int i = 0; i < fruits.Length; i++)
        {
            for (int j = 0; j < baskets.Length; j++)
            {
                if (baskets[j] == 0)
                {
                    continue;
                }

                if (fruits[i] <= baskets[j])
                {
                    baskets[j] = 0;
                    fruits[i] = 0;
                    break;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < fruits.Length; i++)
        {
            if (fruits[i] != 0)
            {
                result++;
            }
        }

        return result;
    }
}