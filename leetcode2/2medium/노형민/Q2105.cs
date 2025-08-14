public class Solution
{
    public int MinimumRefill(int[] plants, int capacityA, int capacityB)
    {
        int ap = 0;
        int bp = plants.Length - 1;

        int aw = capacityA;
        int bw = capacityB;

        int refills = 0;

        while (true)
        {
            if (ap > bp)
            {
                break;
            }
            if (ap == bp)
            {
                if (aw > bw && aw < plants[ap])
                {
                    refills++;
                }
                else if (bw > aw && bw < plants[bp])
                {
                    refills++;
                }
                else if (aw == bw && bw < plants[bp])
                {
                    refills++;
                }

                break;
            }

            if (aw < plants[ap])
            {
                refills++;
                aw = capacityA;
            }

            aw -= plants[ap];
            ap++;

            if (bw < plants[bp])
            {
                refills++;
                bw = capacityB;
            }

            bw -= plants[bp];
            bp--;
        }

        return refills;
    }
}