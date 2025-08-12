public class Solution
{
    public int MaximumLength(string s)
    {
        int result = -1;

        for (int i = 0; i < s.Length - 2; i++)
        {
            int start = i;

            for (int j = i; j < s.Length; j++)
            {
                int end = j;

                for (int k = start; k <= end; k++)
                {
                    if (s[k] != s[start])
                    {
                        start = k;
                        break;
                    }
                }

                int distinctCount = 0;

                for (int k = start; k < s.Length - (end - start); k++)
                {
                    bool isDistinct = true;

                    for (int l = 0; l <= end - start ; l++)
                    {
                        if (s[k + l] != s[start + l])
                        { 
                            isDistinct = false;
                            break;
                        }
                    }

                    if (isDistinct)
                    {
                        distinctCount++;
                        if (distinctCount == 3)
                        {
                            if (end - start + 1 > result)
                            {
                                result = end - start + 1;s
                            }
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }
}