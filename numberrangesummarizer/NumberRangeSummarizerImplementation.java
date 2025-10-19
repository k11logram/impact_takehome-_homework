package numberrangesummarizer;

import java.util.*;
import java.util.stream.Collectors;

public class NumberRangeSummarizerImplementation implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        // Handle empty or null input safely
        if (input == null || input.trim().isEmpty()) {
            return new ArrayList<>();
        }

        // Split and parse integers, ignoring blanks
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty()) // avoid NumberFormatException
                .map(Integer::parseInt)
                .sorted()
                .distinct() // remove duplicates
                .collect(Collectors.toList());
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        List<Integer> numbers = new ArrayList<>(input);
        StringBuilder result = new StringBuilder();

        int start = numbers.get(0);
        int prev = start;

        for (int i = 1; i < numbers.size(); i++) {
            int current = numbers.get(i);
            if (current != prev + 1) {
                appendRange(result, start, prev);
                result.append(", "); // add comma + space between ranges
                start = current;
            }
            prev = current;
        }

        // Append the final range
        appendRange(result, start, prev);

        return result.toString();
    }

    // Helper to append "start" or "start-end"
    private void appendRange(StringBuilder sb, int start, int end) {
        if (start == end) {
            sb.append(start);
        } else {
            sb.append(start).append("-").append(end);
        }
    }
}
