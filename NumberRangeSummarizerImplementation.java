package numberrangesummarizer;

import java.util.*;

public class NumberRangeSummarizerImplementation implements NumberRangeSummarizer{
    @Override
    public Collection<Integer> collect(String input) {
        List<Integer> arr = new ArrayList<>();
        String[] numbers = input.split(",");
        for (String number : numbers) {
            arr.add(Integer.parseInt(number.trim())); // I am removing the whitespaces and converting the char /string into a number
        }
        return arr; //I have returned the collection of numbers as an ArrayList
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        List<Integer> sortedList = new ArrayList<>(input); // We want to sort the list
        Collections.sort(sortedList); // now everything is sorted
        StringBuilder result = new StringBuilder(); // Using StringBuilder to build the result string that the function will return
        int start = sortedList.get(0); // starting point of the range
        int end = sortedList.get(0); // ending point of the range
        for (int i = 1; i < sortedList.size(); i++) {
            int current = sortedList.get(i);
            if (current == end + 1) { // Check if the current number is consecutive
                end = current; // Extend the range
            } else {
                // Append the previous range to the result
                if (start == end) {
                    result.append(start).append(","); // Single number
                } else {
                    result.append(start).append("-").append(end).append(","); // Range of numbers
                }
                start = current; // Start a new range
                end = current;
            }
        }
        // Append the last range to the result
        if (start == end) {
            result.append(start);
        } else {
            result.append(start).append("-").append(end);
        }
        return result.toString();
   }
}
