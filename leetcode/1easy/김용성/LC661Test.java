import org.junit.Test;

public class LC661Test {
    @Test
    public void imageSmoother() {
        LC661 lc = new LC661();
        int[][] test = {
                {2,3,4},
                {5,6,7},
                {8,9,10},
                {11,12,13},
                {14,15,16}};
        lc.imageSmoother(test);
    }




}