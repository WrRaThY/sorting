package priv.rdo.sorting;

import java.util.Collections;
import java.util.List;

/**
    Start at the beginning of an array and swap the first two elements if the first is bigger than the second.
    Go to the next pair, etc, continuously making sweeps of the array until sorted.

    Time Complexity: O(n^2)
    Space Complexity: O(1)

    https://en.wikipedia.org/wiki/Bubble_sort
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public List<T> sort(List<T> input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        for (int currentIndex = 0; currentIndex < input.size(); currentIndex++) {
            bubbleToTheRight(input, currentIndex);
        }
        return input;
    }

    private void bubbleToTheRight(List<T> input, int placesSortedAtTheEnd) {
        int maxIndex = input.size() - placesSortedAtTheEnd;

        for (int currentIndex = 1; currentIndex < maxIndex; currentIndex++) {
            int indexBeforeCurrent = currentIndex - 1;
            if (input.get(indexBeforeCurrent).compareTo(input.get(currentIndex)) > 0){
                Collections.swap(input, indexBeforeCurrent, currentIndex);
            }
        }
    }
}
