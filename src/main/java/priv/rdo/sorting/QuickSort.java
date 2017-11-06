package priv.rdo.sorting;

import java.util.Collections;
import java.util.List;

/**
    Pick an element (pivot) and partition the array, such that all numbers that are less than it come before all elements that are greater than it.
    Then do that recursively for each half, then each quarter, etc.
    stop when there is only one element in a sub-list, meaning that it's sorted

    Time Complexity: from O(n log(n)) to O(n^2), where the avg outcome is O(n log(n))
    Space Complexity: O(1)

    https://en.wikipedia.org/wiki/Quicksort
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public List<T> sort(List<T> input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        quicksort(input, 0, input.size() - 1);

        return input;
    }

    private void quicksort(List<T> input, int startingLowIndex, int startingHighIndex) {
        int currentLowIndex = startingLowIndex;
        int currentHighIndex = startingHighIndex;

        T pivot = input.get(pivotIndex(startingLowIndex, startingHighIndex));

        while (currentLowIndex <= currentHighIndex) {
            while (input.get(currentLowIndex).compareTo(pivot) < 0) {
                currentLowIndex++;
            }

            while (input.get(currentHighIndex).compareTo(pivot) > 0) {
                currentHighIndex--;
            }

            if (currentLowIndex <= currentHighIndex) {
                Collections.swap(input, currentLowIndex, currentHighIndex);
                currentLowIndex++;
                currentHighIndex--;
            }
        }

        if (startingLowIndex < currentHighIndex) {
            quicksort(input, startingLowIndex, currentHighIndex);
        }
        if (currentLowIndex < startingHighIndex) {
            quicksort(input, currentLowIndex, startingHighIndex);
        }

    }

    /**
     * somewhere around the middle of current window
     */
    private int pivotIndex(int startingLowIndex, int startingHighIndex) {
        return startingLowIndex + (startingHighIndex - startingLowIndex) / 2;
    }


}
