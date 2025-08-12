public class Solution
{
    public bool ValidTicTacToe(string[] board)
    {
        int o = 0, x = 0, empty = 0, oHit = 0, xHit = 0;

        bool isValid = true;

        char[] input = new char[9];

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                char cell = board[i][j];
                input[i * 3 + j] = cell;
                if (cell == 'X')
                {
                    x++;
                }
                else if (cell == 'O')
                {
                    o++;
                }
                else if (cell == ' ')
                {
                    empty++;
                }
            }
        }

        int[][] winPatterns =
        [
                [0, 1, 2],
                [3, 4, 5],
                [6, 7, 8],
                [0, 3, 6],
                [1, 4, 7],
                [2, 5, 8],
                [0, 4, 8],
                [2, 4, 6]
        ];

        foreach (var pattern in winPatterns)
        {
            if (input[pattern[0]] == input[pattern[1]] &&
                input[pattern[1]] == input[pattern[2]])
            {
                if (input[pattern[0]] == 'X')
                {
                    xHit++;
                }
                else if (input[pattern[0]] == 'O')
                {
                    oHit++;
                }
            }
        }

        if (xHit != 0)
        {
            if (x != o + 1)
            {
                isValid = false;
            }
            if (oHit != 0)
            {
                isValid = false;
            }
        }
        else if (oHit != 0)
        {
            if (o != x)
            {
                isValid = false;
            }
        }
        else
        {
            if (empty == 0)
            {
                if (x != o + 1)
                {
                    isValid = false;
                }
            }
            else
            {
                if (x != o + 1 && x != o)
                {
                    isValid = false;
                }
            }
        }

        return isValid;
    }
}
