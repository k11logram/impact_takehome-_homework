package numberrangesummarizer;

import java.util.Collection;

public class ManualTestRunner {

    private static final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImplementation();

    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        int passed = 0;
        int failed = 0;

        // Define test cases (input, expected output)
        String[][] tests = {
            {"1,3,6,7,8,12,13,14,15,21,22,23,24,31", "1, 3, 6-8, 12-15, 21-24, 31"},
            {"1,2,3,4,5", "1-5"},
            {"1,3,5,7,9", "1, 3, 5, 7, 9"},
            {"1,2,3,5,6,8,10,11,12,13", "1-3, 5-6, 8, 10-13"},
            {"", ""},
            {"5", "5"},
            {"1,1,2,2,3,3", "1-3"},
            {"10,8,9,7,6,5,4", "4-10"},
            {"100,101,102,150,200,201,202,203", "100-102, 150, 200-203"}
        };

        for (int i = 0; i < tests.length; i++) {
            String input = tests[i][0];
            String expected = tests[i][1];

            Collection<Integer> collected = summarizer.collect(input);
            String actual = summarizer.summarizeCollection(collected);

            boolean success = expected.equals(actual);

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input:    " + (input.isEmpty() ? "(empty)" : input));
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + actual);
            System.out.println(success ? "✅ PASS\n" : "❌ FAIL\n");

            if (success) passed++; else failed++;
        }

        System.out.println("=================================");
        System.out.println("Total: " + (passed + failed) + " | Passed: " + passed + " | Failed: " + failed);
        System.out.println("=================================");
    }
}
