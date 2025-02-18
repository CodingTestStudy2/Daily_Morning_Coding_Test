import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC_126Test {
    @Test
    public void findLadders() {
        LC_126 ladders = new LC_126();
        String[] values = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new ArrayList<>(Arrays.asList(values));

        ladders.findLadders("hit","cog", wordList);
    }
}