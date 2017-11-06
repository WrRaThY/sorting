package priv.rdo.sorting;

import java.util.Collections;
import java.util.List;

/**
    Find the smallest element using a linear scan and move it to the front.
    Then, find the second smallest and move it, again doing a linear scan.
    Continue doing this until all the elements are in place.

    Time Complexity: O(n^2)
    Space Complexity: O(1)

    https://en.wikipedia.org/wiki/Selection_sort
 */
public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

    public List<T> sort(List<T> input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        for (int currentIndex = 0; currentIndex < input.size(); currentIndex++) {
            int smallestIndex = indexOfTheSmallestElement(input, currentIndex);
            Collections.swap(input, currentIndex, smallestIndex);
        }
        return input;
    }

    private int indexOfTheSmallestElement(List<T> input, int startIndex) {
        if (startIndex == input.size() - 1) {
            return startIndex;
        }

        T smallest = null;
        int smallestIndex = -1;

        for (int i = startIndex; i < input.size(); i++) {
            T item = input.get(i);
            if (smallest == null || smallest.compareTo(item) >= 0) {
                smallest = item;
                smallestIndex = i;
            }
        }

        if (smallestIndex == -1) {
            throw new IllegalStateException();
        }

        return smallestIndex;
    }
}
