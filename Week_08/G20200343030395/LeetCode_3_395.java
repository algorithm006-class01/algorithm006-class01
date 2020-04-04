package Week_08.G20200343030395;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode_3_395 {
    public String reverseWords(String s) {
        // remove leading spaces
        s = s.trim();
        // split by multiple spaces
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
