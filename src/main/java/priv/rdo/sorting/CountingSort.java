package priv.rdo.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
    It operates by counting the number of objects that have each distinct key value
    and using arithmetic on those counts to determine the positions of each key value in the output sequence

    The original version works for items that can be arranged in advance (like integers or letters [which can be perceived as ints])
    I tried to generify that, but I need to additionally sort *m* distinct objects, so time complexity gets worse... (used javas quicksort)

    Time Complexity: O(n + m*log(m))
    Space Complexity: O(n + m)

    So given that the dictionary is small (for example english letters), it's actually not that bad
    Given that the dictionary is big (there are almost no duplicates), then we don't gain anything special and we lose a lot of space
    that means...
    USE WITH CAUTION

    https://en.wikipedia.org/wiki/Counting_sort
 */
public class CountingSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public List<T> sort(List<T> input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        Map<T, Integer> countedItems = new HashMap<>();

        for (T item : input) {
            incrementItemCounter(countedItems, item);
        }

        return buildResultList(countedItems);
    }

    private void incrementItemCounter(Map<T, Integer> countedItems, T item) {
        if (!countedItems.containsKey(item)) {
            countedItems.put(item, 0);
        }
        countedItems.put(item, countedItems.get(item) + 1);
    }

    private List<T> buildResultList(Map<T, Integer> countedItems) {
        List<T> sortedKeys = new ArrayList<>(countedItems.keySet());
        Collections.sort(sortedKeys);

        List<T> output = new ArrayList<>();

        for (T key : sortedKeys) {
            Integer count = countedItems.get(key);
            for (int i = 0; i < count; i++) {
                output.add(key);
            }
        }

        return output;
    }

}
