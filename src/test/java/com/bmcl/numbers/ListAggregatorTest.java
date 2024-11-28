package com.bmcl.numbers;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> list;

    @Test
    public void distinct() {
        // Configuração dos dados de teste
        list = Arrays.asList(1, 2, 4, 2, 5, 4);

        // Instância do ListAggregator
        ListAggregator aggregator = new ListAggregator();

        // Mock do GenericListDeduplicator
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);

        // Configuração do comportamento do stub
        Mockito.when(deduplicator.deduplicate(Mockito.anyList()))
                .thenReturn(Arrays.asList(1, 2, 4, 5));

        // Chamada do método distinct
        int distinct = aggregator.distinct(list, deduplicator);

        // Verificação do resultado esperado
        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void max_bug_8726() {
        // Configuração dos dados de teste
        list = Arrays.asList(1, 2, 4, 2);

        // Instância do ListAggregator
        ListAggregator aggregator = new ListAggregator();

        // Mock do GenericListDeduplicator
        GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);

        // Configuração do comportamento do stub
        Mockito.when(deduplicator.deduplicate(Mockito.anyList()))
                .thenReturn(Arrays.asList(1, 2, 4));

        // Chamada do método distinct
        int distinct = aggregator.distinct(list, deduplicator);

        // Verificação do resultado esperado
        Assertions.assertEquals(3, distinct);
    }
}
