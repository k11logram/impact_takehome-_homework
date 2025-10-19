package numberrangesummarizer;

import java.util.Collection;

public class NumberRangeSummarizerTest {
    public static void main(String[] args) {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImplementation();

        // --- Test Cases ---
        String[] inputs = {
            "1,3,6,7,8,12,13,14,15,21,22,23,24,31", // sample from spec
            "1,2,3,4,5",                            // all sequential
            "1,3,5,7,9",                            // all isolated
            "1,2,3,5,6,8,10,11,12,13",              // mixed ranges
            "",                                     // empty input
            "5",                                    // single number
            "1,1,2,2,3,3",                          // duplicates
            "10,8,9,7,6,5,4",                       // unsorted input
            "100,101,102,150,200,201,202,203"       // large numbers
        };

        // Run each test
        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            System.out.println("Test Case " + (i + 1));
            System.out.println("Input: " + (input.isEmpty() ? "(empty)" : input));

            Collection<Integer> collection = summarizer.collect(input);
            String summarized = summarizer.summarizeCollection(collection);
            System.out.println("Output: " + summarized);
            System.out.println("-----------------------------");
        }
    }
}
