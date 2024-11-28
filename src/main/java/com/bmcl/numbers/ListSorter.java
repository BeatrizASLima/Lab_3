package com.bmcl.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utility class to sort and deduplicate a list of numbers.
 */
public class ListSorter implements GenericListSorter {

    /**
     * Removes duplicates from the given list after sorting it.
     *
     * @param list the list of integers to deduplicate.
     * @return a sorted list with unique integers.
     */
    public List<Integer> deduplicate(List<Integer> list) {
        List<Integer> sorted = sort(list);
        List<Integer> unique = new ArrayList<>();
        Integer last = null;
        for (Integer number : sorted) {
            if (!number.equals(last)) {
                last = number;
                unique.add(number);
            }
        }
        return unique;
    }

    /**
     * Sorts the given list of integers in ascending order.
     *
     * @param list the list to be sorted.
     * @return a sorted version of the list.
     */
    public List<Integer> sort(List<Integer> list) {
        List<Integer> sorted = new ArrayList<>();
        for (Integer number : list)
            sorted.add(number);
        for (int i = 0; i < sorted.size() - 1; i++)
            for (int j = i + 1; j < sorted.size() - 1; j++)
                if (sorted.get(i) > sorted.get(j))
                    Collections.swap(sorted, i, j);
        return sorted;
    }
}
