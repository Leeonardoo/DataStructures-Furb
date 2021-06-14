package com.leonardo.datastructures;

import com.leonardo.datastructures.sorting.OrdenacaoAbstract;
import com.leonardo.datastructures.sorting.OrdenacaoBolhaOtimizada;
import com.leonardo.datastructures.sorting.OrdenacaoQuickSort;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    OrdenacaoAbstract<Integer> sortingTest = new OrdenacaoQuickSort<>();

    @Test
    @DisplayName("Should sort correctly")
    public void testSorting() {
        sortingTest.setInfo(new Integer[]{70, 2, 88, 15, 90, 30});
        sortingTest.ordenar();

        assertArrayEquals(new Integer[]{2, 15, 30, 70, 88, 90}, sortingTest.getInfo());
    }
}
