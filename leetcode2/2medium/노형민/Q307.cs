public class NumArray
{
    int[] _segmentTree;

    public NumArray(int[] nums)
    {
        _segmentTree = new int[nums.Length * 4];

        BuildSegmentTree(nums, 0, nums.Length - 1, 0);
    }

    private int BuildSegmentTree(int[] nums, int start, int end, int index)
    {
        if (start == end)
        {
            _segmentTree[index] = nums[start];

            return _segmentTree[index];
        }

        int mid = (start + end) / 2;

        _segmentTree[index] = BuildSegmentTree(nums, start, mid, 2 * index + 1) +
                              BuildSegmentTree(nums, mid + 1, end, 2 * index + 2);
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

        _segmentTree[index] = _segmentTree[2 * index + 1] + _segmentTree[2 * index + 2];
    }

    public int SumRange(int left, int right)
    {
        return Sum(0, _segmentTree.Length / 4 - 1, 0, left, right);
    }

    private int Sum(int start, int end, int index, int left, int right)
    {
        if (start > right || end < left)
        {
            return 0;
        }

        if (start >= left && end <= right)
        {
            return _segmentTree[index];
        }

        int mid = (start + end) / 2;
        return Sum(start, mid, 2 * index + 1, left, right) +
               Sum(mid + 1, end, 2 * index + 2, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.Update(index,val);
 * int param_2 = obj.SumRange(left,right);
 */