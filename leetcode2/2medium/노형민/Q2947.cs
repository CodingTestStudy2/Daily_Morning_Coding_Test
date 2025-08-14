public class Solution
{
    public int BeautifulSubstrings(string s, int k)
    {
        int result = 0;

        for (int i = 0; i < s.Length; i++)
        {
            int vowelCount = 0;
            int consonantCount = 0;
            for (int j = i; j < s.Length; j++)
            {
                char c = s[j];
                if ("aeiou".Contains(c))
                {
                    vowelCount++;
                }
                else
                {
                    consonantCount++;
                }

                if (vowelCount == consonantCount &&
                    (vowelCount * consonantCount) % k == 0)
                {
                    result += 1;
                }
            }
        }

        return result;
    }
}