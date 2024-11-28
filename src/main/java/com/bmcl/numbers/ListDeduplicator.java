package com.bmcl.numbers;

import java.util.ArrayList;

import java.util.List;

/**
 *  utility class that removes duplicate numbers
 * from a list.
 */
public class ListDeduplicator implements GenericListDeduplicator {
    private final GenericListSorter sorter;

    public ListDeduplicator(GenericListSorter sorter) {
        this.sorter = sorter;
    }

    public List<Integer> deduplicate(List<Integer> list) {
        List<Integer> sorted = sorter.sort(list);
        List<Integer> unique = new ArrayList<>();
        Integer last = null;
        for (Integer number : sorted)
            if (!number.equals(last)) {
                last = number;
                unique.add(number);
            }
        return unique;
    }
}

