package priv.rdo.sorting;

import java.util.List;

/**
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * It repeats until no input elements remain.
 * <p>
 * Time Complexity: from O(n) to O(n^2). Generally O(n*k), where k is the avg distance between a checked item and its intended spot in current processing
 * Space Complexity: O(1)
 * <p>
 * https://en.wikipedia.org/wiki/Insertion_sort
 */
public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public List<T> sort(List<T> input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        for (int currentIndex = 1; currentIndex < input.size(); currentIndex++) {
            insertItemInTheCorrectPlaceStartingFromRight(input, currentIndex);
        }
        return input;
    }

    private void insertItemInTheCorrectPlaceStartingFromRight(List<T> input, int currentIndex) {
        T item = input.get(currentIndex);
        int sortedIndex = currentIndex - 1;

        while (sortedIndex >= 0 && input.get(sortedIndex).compareTo(item) > 0) {
            moveRight(input, sortedIndex);
            sortedIndex--;
        }

        input.set(sortedIndex + 1, item); //insert new value in the right spot
        // +1, because we decremented it in a while loop one times too many
    }

    private void moveRight(List<T> input, int sortedIndex) { //to make place for a new value
        input.set(sortedIndex + 1, input.get(sortedIndex));
    }



    }
