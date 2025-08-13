public class Solution
{
    public int SumCounts(IList<int> nums)
    {
        int total = 0;
        for (int i = 0; i < nums.Count; i++)
        {
            HashSet<int> set = [];
            for (int j = i; j < nums.Count; j++)
            {
                set.Add(nums[j]);
                total += set.Count * set.Count;
            }
        }

        return total;
    }
}