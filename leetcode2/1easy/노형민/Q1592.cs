using System.Text;

public class Solution
{
    public string ReorderSpaces(string text)
    {
        StringBuilder sb = new();
        int spaceCount = 0;
        int wordCount = 0;
        bool inWord = false;

        foreach (char c in text)
        {
            if (c == ' ')
            {
                spaceCount++;
                inWord = false;
            }
            else
            {
                if (!inWord)
                {
                    wordCount++;
                    inWord = true;
                }
            }
        }

        if (wordCount != 1)
        {
            bool wordStarted = true;
            bool firstWord = true;
            foreach (char c in text)
            {
                if (c == ' ')
                {
                    wordStarted = false;
                }
                else
                {
                    if (!wordStarted && !firstWord)
                    {
                        sb.Append(' ', spaceCount / (wordCount - 1));
                    }

                    sb.Append(c);
                    wordStarted = true;
                    firstWord = false;
                }
            }
            
            sb.Append(' ', spaceCount % (wordCount - 1));
            
            return sb.ToString();
        }
        else
        {
            sb.Append(text.Trim());
            sb.Append(' ', spaceCount);
            return sb.ToString();
        }
    }
}