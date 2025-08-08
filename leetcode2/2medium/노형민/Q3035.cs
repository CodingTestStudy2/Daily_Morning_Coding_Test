public class Solution
{
    int[] _segmentTree;

    public int NumOfUnplacedFruits(int[] fruits, int[] baskets)
    {
        _segmentTree = new int[baskets.Length * 4];

        int unplacedCount = 0;

        BuildSegmentTree(baskets, 0, baskets.Length - 1, 0);
        for (int i = 0; i < fruits.Length; i++)
        {
            int basketIndex = FindBasket(fruits[i]);
            if (basketIndex != -1)
            {
                Update(basketIndex, 0);
            }
            else
            {
                unplacedCount++;
            }
        }

        return unplacedCount;
    }

    private int BuildSegmentTree(int[] baskets, int start, int end, int index)
    {
        if (start == end)
        {
            _segmentTree[index] = baskets[start];
            return _segmentTree[index];
        }

        int mid = (start + end) / 2;
        _segmentTree[index] = Math.Max(
            BuildSegmentTree(baskets, start, mid, 2 * index + 1),
            BuildSegmentTree(baskets, mid + 1, end, 2 * index + 2)
        );

        return _segmentTree[index];
    }

    public void Update(int index, int val)
    {
        Update(0, _segmentTree.Length / 4 - 1, 0, index, val);
    }

    private void Update(int start, int end, int index, int targetIndex, int val)
    {
        if (start == end)
        {
            _segmentTree[index] = val;
            return;
        }

        int mid = (start + end) / 2;
        if (targetIndex <= mid)
        { 
            Update(start, mid, 2 * index + 1, targetIndex, val);
        }
        else
        {
            Update(mid + 1, end, 2 * index + 2, targetIndex, val);
        }

        _segmentTree[index] = Math.Max(_segmentTree[2 * index + 1], _segmentTree[2 * index + 2]);
    }

    private int FindBasket(int val)
    {
        return FindBasket(0, _segmentTree.Length / 4 - 1, 0, val);
    }

    private int FindBasket(int start, int end, int index, int val)
    {
        if (_segmentTree[index] < val)
        { 
            return -1;
        }

        if (start == end)
        { 
            return start;
        }

        int mid = (start + end) / 2;

        int leftResult = FindBasket(start, mid, 2 * index + 1, val);
        // 왼쪽 우선
        if (leftResult != -1)
        { 
            return leftResult;
        }

        return FindBasket(mid + 1, end, 2 * index + 2, val);
    }

}
