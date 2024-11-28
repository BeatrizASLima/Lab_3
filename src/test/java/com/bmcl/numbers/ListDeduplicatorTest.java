package com.bmcl.numbers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    private List<Integer> list;
    private List<Integer> expected;

    @Test
    public void deduplicate() {
        // Configuração dos dados de teste
        list = Arrays.asList(3, 2, 2, 1, 4, 5);
        expected = Arrays.asList(1, 2, 3, 4, 5);

        // Mock do GenericListSorter
        GenericListSorter sorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(sorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2, 3, 4, 5));

        // Criação do ListDeduplicator usando o mock
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);

        // Chamada do método deduplicate
        List<Integer> distinct = deduplicator.deduplicate(list);

        // Verificação do resultado
        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void bug_deduplicate_8726() {
        // Configuração dos dados de teste
        list = Arrays.asList(1, 2, 4, 2);
        expected = Arrays.asList(1, 2, 4);

        // Mock do GenericListSorter
        GenericListSorter sorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(sorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2, 4));

        // Criação do ListDeduplicator usando o mock
        ListDeduplicator deduplicator = new ListDeduplicator(sorter);

        // Chamada do método deduplicate
        List<Integer> distinct = deduplicator.deduplicate(list);

        // Verificação do resultado
        Assertions.assertEquals(expected, distinct);
    }
}
